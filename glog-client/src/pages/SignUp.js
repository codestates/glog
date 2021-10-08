import React from 'react';
import '../css/signUp.css';

export default function SignUp() {
    return (
        <div>
            <div>
                <span>아이디</span>
                <input type="text" />
            </div>
            <div>
                <span>@</span>
                <select name="email">
                    <option value="">선택</option>
                    <option value="naver">naver.com</option>
                    <option value="google">google.com</option>
                    <option value="hanmail">hanmail.com</option>
                    <option value="hatmail">hatmail.com</option>
                    <option value="kakao">kakao.com</option>
                </select>
            </div>
        </div>
    );
}