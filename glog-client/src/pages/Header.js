import React from 'react';
import {Link} from 'react-router-dom';
import '../css/header.css'
import logo from '../img/logo.png';

export default function Header() {
    return (
        <div className="header">
            <a className="logo" href='/'>
                <img src={logo} width='50' height='50' alt='logo'/>
                <span>GLOG</span>
            </a>
            <ul className="btn">
                <li>
                    <Link to="/signin">SignIn</Link>
                </li>
                <li>
                    <Link to="/signup">SignUp</Link>
                </li>
                <li>
                    <Link to="/mypage">Mypage</Link>
                </li>
            </ul>
        </div>
    );
}