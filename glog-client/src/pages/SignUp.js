import React, { useState } from 'react';
import '../css/signUp.css';
import logo from '../img/logo.png';
import { FaGoogle, FaGithub } from 'react-icons/fa';

export default function SignUp() {

    const [isRevealPwd, setIsRevealPwd] = useState(false);

    return (
        <div className="signup-container">
            <div className="signup-intro">
                <a href="/">
                    <img src={logo} width="40" height="40" alt="logo"/>
                </a>
                 <p className="intro">Glog에 오신 것을 환영합니다.</p>
            </div>
            <div className="user-info">
                <div className="email">
                    <input type="text" placeholder="이메일"/>
                    <p className="hidden">이메일 validation 메세지</p>
                </div>
                <div className="password">
                    <input type={isRevealPwd ? "text" : "password"} placeholder="비밀번호를 입력하세요."/>
                    <p className="show" onClick={() => setIsRevealPwd(prevState =>!prevState)}>{isRevealPwd? 'hide' : 'show'}</p>
                </div>
                <div className="signup-btn">가입하기</div>
            </div>
            <div className="social-login-btn">
                <p>또는</p>
                <div className="google-btn"><FaGoogle/><span>google계정으로 계속하기</span></div>
                <div className="github-btn"><FaGithub/><span>github계정으로 계속하기</span></div>
            </div>
        </div>
    );
}
