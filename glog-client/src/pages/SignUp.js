import React, { useState } from 'react';
import '../css/signUp.css';
import Email from '../components/Email'
import Password from '../components/Password'
import logo from '../img/logo.png';
import { FaGoogle, FaGithub } from 'react-icons/fa';

export default function SignUp() {

    const [isRevealPwd, setIsRevealPwd] = useState(false);

    return (
        <div className="signup-container">
            <div className="intro">
                <a href="/">
                    <img src={logo} width="40" height="40" alt="logo"/>
                </a>
                 <p className="salutation">Glog에 오신 것을 환영합니다.</p>
            </div>
            <div className="user-info">
                <Email/>
                <Password/>
                <div className="nickname">
                    <input type="text" placeholder="닉네임"/>
                </div>
                <div className="signup-btn">가입하기</div>
            </div>
            <div className="social-login-btn">
                <p>또는</p>
                <div className="google-btn">
                    <FaGoogle/><span>google계정으로 계속하기</span>
                </div>
                <div className="github-btn">
                    <FaGithub/><span>github계정으로 계속하기</span>
                </div>
            </div>
        </div>
    );
}
