import React, { useState } from 'react';
import '../css/signUp.css';
import Email from '../components/Email'
import Password from '../components/Password'
//import ReCaptcha from '../components/ReCaptcha'
import SocialAuth from '../components/SocialAuth'
import logo from '../img/logo.png';
import crypto from 'crypto';
import axios from 'axios';

export default function SignUp() {
    const JWT_EXPIRY_TIME = 24 * 3600 * 1000; // 만료 시간 (24시간 밀리 초로 표현)

    const [userInfo, setUserInfo] = useState({
        email: '',
        password: '',
        nickname: ''
    });
    const handleInputValue = (key) => (val) => {
        setUserInfo({ ...userInfo, [key]: val });
    };

    const base64url = (source) => {
        return Buffer(JSON.stringify(source))
        .toString('base64')
        .replace('=', '');
    }

    const jwtToken= () => {
        const header = {
            'type' : 'JWT',
            'alg' : 'HS256'
        };
        const datas = {
            'sub': 'gLogSubject',
            'exp': JWT_EXPIRY_TIME,
            'email': userInfo.email,
            'password': userInfo.password,
            'nickname': userInfo.nickname
        }
        const encodedHeader = base64url(header);
        const encodedPayload = base64url(datas);

        const signature = crypto.createHmac('sha256', 'glogkey')
                                .update(encodedHeader + '.' + encodedPayload)
                                .digest('base64')
                                .replace('=', '');

        return encodedHeader + '.' + encodedPayload + '.' + signature; 
    }

    const goSignUp = () => {
        const emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        const pwdRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;
        
        if(userInfo.nickname === '') {
            let tmpStr = userInfo.email.split('@');
            let id = tmpStr[0];
            userInfo.nickname = id;
        }
        //TODO: 보내기 전 유효성 검사하기 - email/password형식 확인
        if(!userInfo.email || !userInfo.password 
            || !emailRegex.test(userInfo.email)
            || !pwdRegex.test(userInfo.password)) {
            alert('필수사항을 확인해주세요.');
            return;
        } else {
            axios.post('http://localhost:4000/signup', {'token':jwtToken()})
                .then(res => {
                    console.log(res);
                }).catch(error => {
                    console.log(error);
                    throw new Error(error);
                });
        }
    }

    return (
        <div className='signup-container'>
            <div className='intro'>
                <a href='/'>
                    <img src={logo} width='40' height='40' alt='logo'/>
                </a>
                <p className='salutation'>Glog에 오신 것을 환영합니다.</p>
            </div>
            <div className='user-info'>
                <Email handleInputValue={handleInputValue('email')}/>
                <Password handleInputValue={handleInputValue('password')}/>
                <div className='nickname'>
                    <input className='required' 
                        type='text' 
                        placeholder='닉네임' 
                        onChange={(e) => setUserInfo({...userInfo, ['nickname']:e.target.value})}/>
                </div>
                {/* <ReCaptcha/> */}
                <div className='signup-btn' onClick={goSignUp}>가입하기</div>
            </div>
            <div className='social-login-btn'>
                <p>또는</p>
                <SocialAuth/>
            </div>
        </div>
    );
}
