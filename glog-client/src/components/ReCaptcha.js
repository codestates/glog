import React from 'react';
import ReCAPTCHA from "react-google-recaptcha";

export default function ReCaptcha() {
    console.log(process.env.REACT_APP_RECAPTCHA_SITE_KEY);
    const verifyCallback = (recaptchaToken) => {
        //console.log('recapchaToken :: ' , recaptchaToken);
    }
    const verifyError = (error) => {
        console.log('reCaptcha error : ', error);
    }
    return (
        <div className="reCaptcha">
            <ReCAPTCHA
                sitekey={process.env.REACT_APP_RECAPTCHA_SITE_KEY}
                onChange={verifyCallback}
                onErrored={verifyError}
            />
        </div>
    );
}