import React, { useState } from 'react';
import {FaExclamationCircle } from 'react-icons/fa';

export default function Password({handleInputValue}) {

    const [isRevealPwd, setIsRevealPwd] = useState(false);
    const [pwdValid, setPwdValid] = useState(true);
    const [pwdMsg, setPwdMsg] = useState('');
    const [pwdChkValid, setPwdChkValid] = useState(true);
    const [pwdChkMsg, setPwdChkMsg] = useState('');
    const [pwd, setPwd] = useState('');

    const validatePwd = (event) => {
        const pwdRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/
        let pwd = event.target.value;

        if(!pwdRegex.test(pwd)) {
            setPwdValid(false);
            setPwdMsg('비밀번호는 최소8자 및 최대 12자, 영문/숫자/특수문자 조합이어야 합니다.');
        }else if(!pwd){
            setPwdValid(false);
            setPwdMsg('비밀번호는 필수사항 입니다.');
        }else {
            setPwdValid(true);
            setPwd(pwd);
            handleInputValue(pwd);
        }
    }

    const isPwdMatches = (event) => {
        let pwdCheck = event.target.value;
        if(pwd !== pwdCheck) {
            setPwdChkValid(false);
            setPwdChkMsg('비밀번호와 일치하지 않습니다.');
        }else if(!pwdCheck) {
            setPwdChkValid(false);
            setPwdChkMsg('비밀번호 확인은 필수사항 입니다.');
        }else {
            setPwdChkValid(true);
        }
    }


    return (
        <div className='password'>
            <div className='pwd'>
                <input className={!pwdValid? 'error' : 'required'} 
                        type={isRevealPwd ? 'text' : 'password'} 
                        placeholder='비밀번호' 
                        onChange={(e) => validatePwd(e)}/>
                <p className='show' onClick={() => setIsRevealPwd(prevState =>!prevState)}>
                    {isRevealPwd? 'hide' : 'show'}
                </p>
                <p className={!pwdValid? 'errorMessage' : 'validation'}>
                    {!pwdValid? '' : <FaExclamationCircle className='exclamation'/>}
                    {!pwdValid? pwdMsg : ' 필수사항'}
                </p>
            </div>
            <div className='pwd-chk'>
                <input className={!pwdChkValid? 'error' : 'required'} 
                        type={isRevealPwd ? 'text' : 'password'} 
                        placeholder='비밀번호 확인'
                        onChange={(e) => isPwdMatches(e)}/>
                <p className={!pwdChkValid? 'errorMessage' : 'validation'}>
                    {!pwdChkValid ? '' : <FaExclamationCircle className='exclamation'/>}
                    {!pwdChkValid? pwdChkMsg : ' 필수사항'}
                </p>
            </div>
        </div>
    );
}
