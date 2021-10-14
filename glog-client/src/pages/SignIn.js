import React, { useEffect, useState } from 'react';
import '../css/signIn.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye, faEyeSlash} from '@fortawesome/free-solid-svg-icons';
import { faGithub,faGoogle } from '@fortawesome/free-brands-svg-icons';
import { useForm } from 'react-hook-form';
import logo from '../img/logo.png'
import axios from 'axios';


export default function SignIn() {
    const JWT_EXPIRY_TIME = 24 * 3600 * 1000;

    const [userInfo,setUserInfo] = useState({
        email: '',
        password: ''
    })

    const handleInputValue = (key) => (val) => {
        setUserInfo ({...userInfo,[key]:val});
    }

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
        }
        const encodedHeader = base64url(header);
        const encodedPayload = base64url(datas);
        
        const signature = crypto.createHmac('sha256', 'glogkey')
                                .update(encodedHeader + '.' + encodedPayload)
                                .digest('base64')
                                .replace('=', '');
        return signature; 
    }

    const curSignIn = () => {
        if(!userInfo.email || !userInfo.password){
            return null;
        }
        else{
            axios.post('http://localhost:4000/signin',{'token':jwtToken()})
            .then(res=>{
                console.log(res);
            }).catch(error=>{
                console.log(error);
                throw new Error(error);
            });
        }
    }

    const [inputId,setInputId]=useState('');
    const [inputPw,setInputPw]=useState('');

    const handleInputId = (e) => {
        setInputId(e.target.value)
    }

    const handleInputPw = (e) => {
        setInputPw(e.target.value)
    }

    const onClickLogin = () => {
        console.log('click login')
    };

    useEffect(()=>{
        axios.post('http://localhost:4000/signin')
        .then(res=>console.log(res))
        .catch()
    },[])

    const {register, handleSubmit,formState:{errors}} = useForm();

    const [show,setShow] = useState(false);

    const handleShowhide = () => {
        setShow(!show);
    }

    const onSubmit = (data) => {
        console.log(data)
    };
    const onError = (error) => {
        console.log(error);
    };


    return (
        <div className="signin-container">
            <div className="signin-intro">
                <a href="/">
                    <img src={logo} width="40" height="40" alt="logo"/>
                </a>
                <p className="intro"> 환영합니다!</p>
            </div>
            <div className="signin">
                <div className="singin-form">
                    <form onSubmit={handleSubmit(onSubmit,onError)}>
                        <div className="email">
                            <label className="email_label" htmlFor='input_id'>아이디 : </label>
                            <input 
                            type="email"
                            placeholder="ID@Email.com"
                            {...register("email", {
                                required: true, 
                                pattern: /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
                            })}  
                            />
                            <span className="email_error">
                            {errors.email && <span>이메일 형식이 아닙니다.</span>}
                            </span>
                        </div>
                        <div className="password">
                            <label className="password_label">비밀번호 : </label>
                            <input type="password" type={show ? "text" : "password"} name="input_pw" placeholder="Password"/>
                            {
                                show?(
                                    <FontAwesomeIcon
                                    onClick={handleShowhide}
                                    icon={faEye}
                                    id="show_hide"
                                    className="show"
                                    />
                                ) :(
                                    <FontAwesomeIcon
                                    onClick={handleShowhide}
                                    icon={faEyeSlash}
                                    id="show_hide"
                                    className="show"
                                    />
                                )
                            }
                        </div>
                        <button className="signin-btn">로그인</button>
                    </form>
                </div>
                <div className="social-singin-btn">
                    <p>또는</p>
                    <div className="google-btn">
                        <button className="signin_google">
                            <FontAwesomeIcon icon={faGoogle}/>
                            <span className="signin_text"> Google 계정으로 로그인</span>
                        </button>
                    </div>
                    {/* <div className="github-btn">
                        <button className="signin_github">
                        <FontAwesomeIcon icon={faGithub}/>
                            <span className="signin_text"> GitHub 계정으로 로그인</span>
                        </button>
                    </div> */}
                </div>
            </div>
        </div>
    )
}