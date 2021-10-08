import React from 'react';
import {Link} from 'react-router-dom';
import '../css/header.css'

export default function Header() {
    return (
        <header>
            <nav>
                <ul>
                    <li>
                        <Link to="/signin">Sign In</Link>
                    </li>
                    <li>
                        <Link to="/signup">Sign Up</Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
}