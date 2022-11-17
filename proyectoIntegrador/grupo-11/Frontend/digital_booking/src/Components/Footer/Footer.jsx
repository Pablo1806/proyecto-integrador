import React from 'react';
import './Footer.css';
// imports font-awesome icons
import { FaFacebook, FaInstagram, FaTwitter, FaLinkedinIn } from 'react-icons/fa';


function Footer() {
    return (
        <footer className="Footer">
            <div className="Footer__container">
                <div className="Footer__container--left">
                <span>©2022 Digital Booking</span>
                </div>
                <div className="Footer__container--right">
                <span><FaFacebook /></span>
                <span><FaLinkedinIn /></span>
                <span><FaTwitter /></span>
                <span><FaInstagram /></span>
                </div>
            </div>
        </footer>
    );
}

export { Footer };