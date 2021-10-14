import React from 'react';
import {Link} from 'react-router-dom';
import '../css/header.css'
import logo from '../img/logo.png';

export default function Header() {
    return (
        <div className="header">
            <a href='/'>
                <img src={logo} width='40' height='40' alt='logo'/>
            </a>
            <ul>
                <li>
                    <Link to="/signin">Sign In</Link>
                </li>
                <li>
                    <Link to="/signup">Sign Up</Link>
                </li>
                <li>
                    <Link to="/mypage">Mypage</Link>
                </li>
            </ul>
        </div>
    );
}