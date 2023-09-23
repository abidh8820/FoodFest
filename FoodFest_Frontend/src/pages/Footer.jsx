import {React,useEffect,useState} from 'react'
import { Button } from 'react-bootstrap';
import {Link, NavLink} from "react-router-dom";
import "../css pages/Footer.css"
import {FaRegAddressBook,FaFacebookF,FaInstagram,FaWhatsapp,FaTwitter} from "react-icons/fa"
import {FiFacebook} from "react-icons/fi"

const Footer = () => {
  return (
    <div className="footer">
        <div className="footerIconBarBack">
            <div className="footerIconBar">
                <Link to="#"><FaFacebookF className="footerIcons" /></Link>
                <Link to="#"><FaInstagram className="footerIcons" /></Link>
                <Link to="#"><FaWhatsapp className="footerIcons" /></Link>
                <Link to="#"><FaTwitter className="footerIcons" /></Link>
            </div>
        </div>
        <div className="footerOpts">
            <div className="footerOpt">
                <p>Resources</p>
                <a href="#">Application</a>
                <a href="#">Documentation</a>
                <a href="#">Systema</a>
                <a href="#">FAQ</a>
            </div>
            <div className="footerOpt">
                <p>Pricing</p>
                <a href="#">Overview</a>
                <a href="#">Premium PLans</a>
                <a href="#">Affiliate Program</a>
                <a href="#">Promotions</a>
            </div>
            <div className="footerOpt">
                <p>Company</p>
                <a href="#">Home</a>
                <a href="#">About Us</a>
                <a href="#">Partnerships</a>
                <a href="#">Career</a>
                <a href="#">Press</a>
            </div>
            <div className="footerOpt">
                <p>Social</p>
                <a href="#">Facebook</a>
                <a href="#">Twitter</a>
                <a href="#">Instagram</a>
                <a href="#">LinkedIn</a>
            </div>
        </div>
        <div className="footerCopyright">
            <p>All rights reserved by Mr Sheikh</p>
        </div>
    </div>
    
  )
}

export default Footer