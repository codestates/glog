import React, { useState } from 'react';
import {FaExclamationCircle } from 'react-icons/fa';

export default function Password() {

    const [isRevealPwd, setIsRevealPwd] = useState(false);

    return (
        <div className="password">
            <div className="pwd">
                <input type={isRevealPwd ? "text" : "password"} placeholder="비밀번호"/>
                <p className="show" onClick={() => setIsRevealPwd(prevState =>!prevState)}>
                    {isRevealPwd? 'hide' : 'show'}
                </p>
                <p className="validation">
                    <FaExclamationCircle className="exclamation"/> 필수사항
                </p>
            </div>
            <div className="pwd-chk">
                <input type={isRevealPwd ? "text" : "password"} placeholder="비밀번호 확인"/>
                <p className="show" onClick={() => setIsRevealPwd(prevState =>!prevState)}>
                    {isRevealPwd? 'hide' : 'show'}
                </p>
                <p className="validation">
                    <FaExclamationCircle className="exclamation"/> 필수사항
                </p>
            </div>
        </div>
    );
}
