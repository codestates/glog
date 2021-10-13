import React from 'react';
import { FaGoogle, FaGithub } from 'react-icons/fa';
import axios from 'axios';

export default function SocialAuth() {
    return (
        <>
            <div className='google-btn'>
                <FaGoogle/><span>google계정으로 계속하기</span>
            </div>
            {/* <div className='github-btn'>
                <FaGithub/><span>github계정으로 계속하기</span>
            </div>         */}
        </>
    );
}