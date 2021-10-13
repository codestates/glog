import React, { useState } from 'react';
import {FaExclamationCircle } from 'react-icons/fa';

export default function Email({handleInputValue}) {
    const [isValid, setIsValid] = useState(true);
    const [emailMsg, setEmailMessage] = useState('');

    const validateEmail = (event) => {
        const emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/;
        let email = event.target.value;

        if(!emailRegex.test(email)) {
            setIsValid(false);
            setEmailMessage('이메일 형식이 아닙니다.');
        }else if(email === ''){
            setIsValid(false);
            setEmailMessage('이메일은 필수사항 입니다.');
        }else {
            setIsValid(true);
            handleInputValue(email);
        }
    }

    return (
        <div className='email'>
            <input className={!isValid? 'error' : 'required'} 
                type='text' 
                placeholder='이메일' 
                onChange={(e) => validateEmail(e)}/>
            <p className={!isValid? 'errorMessage' : 'validation'}>
                {!isValid ? '' : <FaExclamationCircle className='exclamation'/>}
                {!isValid? emailMsg : ' 필수사항'}
            </p>
        </div>
    );
}