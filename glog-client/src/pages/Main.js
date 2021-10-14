import React from 'react';
import '../css/main.css';
import Header from './Header';
import {FaHeart} from 'react-icons/fa';

export default function Main() {
    return (
        <>
            <Header/>
            <div className="main">
                <div className="post">
                    <img src="https://media.vlpt.us/images/haero_kim/post/dc7ef74c-23c2-445c-9017-be77e4a251bf/다운로드 (17).png?w=640" />
                    <h4>제목</h4>
                    <p>본문내용 미리보기</p>
                    <div className="sub-info">
                        <span>2021년 10월 14일</span>
                        <span class="separator">·</span>
                        <span>15개의 댓글</span>
                    </div>
                    <div className="user-info">
                        <a class="userinfo" href="/@dev_bomdong">
                            <img src="https://media.vlpt.us/images/dev_bomdong/profile/9a4ae7eb-fd63-42a6-b463-5177ec36f593/ae61c4371df42b13541c045a814673ab.jpg" alt="user thumbnail of dev_bomdong"/>
                            <span>by <b>dev_bomdong</b></span>
                        </a>
                        <div class="likes">
                            <FaHeart/>
                            25
                        </div>
                    </div>
                </div>
                <div className="post">
                    <img src="https://media.vlpt.us/images/haero_kim/post/dc7ef74c-23c2-445c-9017-be77e4a251bf/다운로드 (17).png?w=640" />
                    <h4><b>제목</b></h4>
                    <p>본문내용 미리보기</p>
                    <div className="sub-info">
                        <span>2021년 10월 14일</span>
                        <span class="separator">·</span>
                        <span>15개의 댓글</span>
                    </div>
                    <div className="user-info">
                        <a class="userinfo" href="/@dev_bomdong">
                            <img src="https://media.vlpt.us/images/dev_bomdong/profile/9a4ae7eb-fd63-42a6-b463-5177ec36f593/ae61c4371df42b13541c045a814673ab.jpg" alt="user thumbnail of dev_bomdong"/>
                            <span>by <b>dev_bomdong</b></span>
                        </a>
                        <div class="likes">
                            <FaHeart/>
                            25
                        </div>
                    </div>
                </div>
                <div className="post">
                    <img src="https://media.vlpt.us/images/haero_kim/post/dc7ef74c-23c2-445c-9017-be77e4a251bf/다운로드 (17).png?w=640" />
                    <h4><b>제목</b></h4>
                    <p>본문내용 미리보기</p>
                    <div className="sub-info">
                        <span>2021년 10월 14일</span>
                        <span class="separator">·</span>
                        <span>15개의 댓글</span>
                    </div>
                    <div className="user-info">
                        <a class="userinfo" href="/@dev_bomdong">
                            <img src="https://media.vlpt.us/images/dev_bomdong/profile/9a4ae7eb-fd63-42a6-b463-5177ec36f593/ae61c4371df42b13541c045a814673ab.jpg" alt="user thumbnail of dev_bomdong"/>
                            <span>by <b>dev_bomdong</b></span>
                        </a>
                        <div class="likes">
                            <FaHeart/>
                            25
                        </div>
                    </div>
                </div>
                

            </div>
        </>
    );
}