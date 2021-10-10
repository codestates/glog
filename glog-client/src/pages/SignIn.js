import React, { useEffect, useState } from 'react';
import '../css/signIn.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye, faEyeSlash } from '@fortawesome/free-solid-svg-icons';
import { faGithub,faGoogle } from '@fortawesome/free-brands-svg-icons';

export default function SignIn() {

    const [show,setShow] = useState(false);

    const handleShowhide = () => {
        setShow(!show);
    }

    return (
        <div className="Signin_Page">
            <div calssName="container">
                <div calssName="Signin_input_id">
                    <label htmlFor="input_id">아이디 : </label>
                    <input type="email" name="input_id" placeholder="ID@Email.com"/>
                </div>
                <div className="Signin_input_pw">
                    <label htmlFor="input_pw">비밀번호 : </label>
                    <input type={show ? "text" : "password"} name="input_pw" placeholder="Password"></input>
                    {
                        show?(
                            <FontAwesomeIcon 
                            onClick={handleShowhide}
                            icon={faEye} 
                            id="show_hide" 
                            />
                        ) :(
                            <FontAwesomeIcon 
                            onClick={handleShowhide}
                            icon={faEyeSlash} 
                            id="show_hide" 
                            />
                        )
                    }
                </div>
                <div>
                    <button classname="Signin_btn" type="button">로그인</button>
                    <button classname="Signin_git_btn" type="button">
                        <FontAwesomeIcon icon={faGithub}/>
                    </button>
                    <button calssName="Signin_google_btn" type="button">
                        <FontAwesomeIcon icon={faGoogle}/>    
                    </button>
                </div>
            </div>
        </div>
    );
}