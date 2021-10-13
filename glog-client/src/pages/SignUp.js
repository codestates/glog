import React, { useState } from 'react';
import '../css/signUp.css';
import Email from '../components/Email'
import Password from '../components/Password'
import ReCaptcha from '../components/ReCaptcha'
import SocialAuth from '../components/SocialAuth'
import logo from '../img/logo.png';
import crypto from 'crypto';
import axios from 'axios';

export default function SignUp() {
    const [userInfo, setUserInfo] = useState({
        email: '',
        password: '',
        nickname: ''
    });
    const handleInputValue = (key) => (val) => {
        setUserInfo({ ...userInfo, [key]: val });
    };

    const base64url = (source) => {
        return Buffer(JSON.stringify(origin))
        .toString('base64')
        .replace('=', '');
    }

    const jwtToken= () => {
        const header = {
            'type' : 'JWT',
            'alg' : 'HS256'
        };
        const datas = {
            'email': userInfo.email,
            'password': userInfo.password,
            'nickname': userInfo.nickname
        }
        const encodedHeader = base64url(header);
        const encodedPayload = base64url(payload);
        
        const signature = crypto.createHmac('sha256', 'secret')
                                .update(encodedHeader + '.' + encodedPayload)
                                .digest('base64')
                                .replace('=', '');
        console.log('token :: ', signature);
        return signature; 
    }

    const goSignUp = () => {
        if(!userInfo.nickname) {
            let tmpStr = userInfo.email.split('@');
            let id = tmpStr[0];
            setUserInfo({ ...userInfo, ['nickname'] : id});
        }
        //TODO: 보내기 전 유효성 검사하기 - email/password형식 확인
        axios({
            method: 'POST',
            url: 'http://localhost:4000/signup',
            data: jwtToken()
        }).then((res) => {
            console.log(res);
            //TODO: success 데이터 넘어오면 login page로 넘기기
        }).catch((error) => {
            console.log(error);
            throw new Error(error);
        });
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
                <ReCaptcha/>
                <div className='signup-btn' onClick={goSignUp}>가입하기</div>
            </div>
            <div className='social-login-btn'>
                <p>또는</p>
                <SocialAuth/>
            </div>
        </div>
    );
}
