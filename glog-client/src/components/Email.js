import React from 'react';
import {FaExclamationCircle } from 'react-icons/fa';

export default function Email() {

    return (
        <div className="email">
            <input type="text" placeholder="이메일"/>
            <p className="validation">
                <FaExclamationCircle className="exclamation"/> 필수사항
            </p>
        </div>
    );
}