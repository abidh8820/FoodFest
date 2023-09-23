import React from 'react'
import { Button } from 'react-bootstrap';
import {Link, NavLink} from "react-router-dom";
import "../css pages/Heromain.css"
import logo from "../images/FLogo.png"
const Heromain = () => {

  const imageSlide2 = () => {
    document.querySelector(".heromainslides").style.marginLeft = "0%";
    document.querySelector(".heromainslides").style.transition = "all 1.5s";
  }
  const imageSlide3 = () => {
    document.querySelector(".heromainslides").style.marginLeft = "-100%";
    document.querySelector(".heromainslides").style.transition = "all 1.5s";
  }
  const imageSlide1 = () => {
    document.querySelector(".heromainslides").style.marginLeft = "-200%";
    document.querySelector(".heromainslides").style.transition = "all 1.5s";
  }

  return (
    <>
        <div className="heromainBackground">
          <div className="heromainslider">
            <div className="heromainslides">
              <img src="https://b.zmtcdn.com/mx-onboarding-hero87f77501659a5656cad54d98e72bf0d81627911821.webp" className="heromainSlideImage"/>
              <img src="https://media.istockphoto.com/id/1081422898/photo/pan-fried-duck.jpg?s=612x612&w=0&k=20&c=kzlrX7KJivvufQx9mLd-gMiMHR6lC2cgX009k9XO6VA=" className="heromainSlideImage"/>
              <img src="https://media.istockphoto.com/id/1295387240/photo/delicious-meal.jpg?b=1&s=170667a&w=0&k=20&c=aE5C-O5C9rtiO_1lzROlZ9fN-t2XDmIjR4c4DviWuE8=" className="heromainSlideImage"/>
            </div>
            <div className="heromainSlideBut">
              <img src=" https://b.zmtcdn.com/mx-onboarding-hero87f77501659a5656cad54d98e72bf0d81627911821.webp" className="heromainSlideButImage heromainSlideImage1" onClick={imageSlide2}/>
              <img src="https://media.istockphoto.com/id/1081422898/photo/pan-fried-duck.jpg?s=612x612&w=0&k=20&c=kzlrX7KJivvufQx9mLd-gMiMHR6lC2cgX009k9XO6VA=" className="heromainSlideButImage heromainSlideImage2" onClick={imageSlide3}/>
              <img src="https://media.istockphoto.com/id/1295387240/photo/delicious-meal.jpg?b=1&s=170667a&w=0&k=20&c=aE5C-O5C9rtiO_1lzROlZ9fN-t2XDmIjR4c4DviWuE8=" className="heromainSlideButImage heromainSlideImage3" onClick={imageSlide1}/>
            </div>
          </div>
        </div>
        <div className="heromanAbout">
          <h1>Welcome to The Best Cafe in VA!</h1>
          <p>A gathering place in Downtown Farmville! Stop by and enjoy coffee, tea, live music, soups, salad, sandwiches, ice cream and much more!</p>
        </div>
        
        <div className="heromainBackgroundSec" id="products">
          <div className="heromainBackgroundSecParts">
            <div className="heromainBackgroundSecPartsBack">
              <Link to="/fastfood" className="heromainBackgroundSecPartsLink">Fast Food</Link><br/>
            </div>
          </div>
          <div className="heromainBackgroundSecParts">
            <div className="heromainBackgroundSecPartsBack">
              <Link to="/setmenu" className="heromainBackgroundSecPartsLink">Set Menu</Link><br/>
            </div>
          </div>
        </div>
        
        <div className="heromainBackgroundThi">
          <div className="heromainBackgroundThiBack">
            <Link to="/specials" className="heromainBackgroundThiLink">Our Specials</Link><br/>
          </div>
        </div>

        <div className="heromainBackgroundFor">
          <div className="heromainBackgroundForParts">
            <div className="heromainBackgroundForPartsBack">
              <Link to="/streetfood" className="heromainBackgroundForPartsLink">Street Food</Link><br/>
            </div>
          </div>
          <div className="heromainBackgroundForParts">
            <div className="heromainBackgroundForPartsBack">
              <Link to="/drinks" className="heromainBackgroundForPartsLink">Drinks</Link><br/>
            </div>
          </div>
        </div>
    </>
  )
}

export default Heromain