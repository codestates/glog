import React, { useState } from 'react';
import '../css/signUp.css';
import Email from '../components/Email'
import Password from '../components/Password'
import ReCaptcha from '../components/ReCaptcha'
import SocialAuth from '../components/SocialAuth'
import logo from '../img/logo.png';

export default function SignUp() {
    const [userInfo, setUserInfo] = useState({
        email: '',
        password: '',
        nickname: ''
    });
    const handleInputValue = (key) => (val) => {
        setUserInfo({ ...userInfo, [key]: val });
    };
    const goSignUp = () => {

        if(!userInfo.nickname) {
            let tmpStr = userInfo.email.split('@');
            let id = tmpStr[0];
            setUserInfo({ ...userInfo, ['nickname'] : id});
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
