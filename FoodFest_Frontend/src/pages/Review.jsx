import React, { useState,useEffect } from 'react';
import Axios from 'axios';
import "../css pages/Review.css"

const Review = () => {
  return (
    <div className="review">
        <h1>They all love our food</h1>
        <p>Good food is not only delicious, but it is also essential for our physical and mental well-being. It provides us with the necessary nutrients, energy, and satisfaction to keep us going throughout the day.</p>
        <div className="reviewCardBar">
            <div className="reviewCard">
                <img src="https://avatars.githubusercontent.com/u/83116065?s=400&u=7fffac9a04dba6c16d4707d2cfabc85cce0e2beb&v=4"></img>
                <h3>Tafsir Rahman</h3>
                <p>Exceptional food, delightful ambiance, and impeccable service—a culinary experience to remember.</p>
            </div>
            <div className="reviewCard">
                <img src="https://i.pinimg.com/originals/08/b8/0f/08b80f4e96b53bf8b4420b179a098519.jpg"></img>
                <h3>Arafat Bin Amin</h3>
                <p>This restaurant's flavors dance on the palate, leaving a lasting impression of gastronomic delight.</p>
            </div>
            <div className="reviewCard">
                <img src="https://avatars.githubusercontent.com/u/75539110?v=4"></img>
                <h3>Mohsina Tabassum</h3>
                <p>Surprises with its mouthwatering dishes, eager to return for another unforgettable culinary adventure.</p>
            </div>
        </div>
    </div>
  )
}

export default Review