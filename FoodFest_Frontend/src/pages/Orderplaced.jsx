import {React,useState,useEffect } from 'react';
import Axios from 'axios';
import { Button } from 'react-bootstrap';
import {AiOutlineClose} from "react-icons/ai"
import "../css pages/Orderplaced.css"

const Orderplaced = () => {
    const refreshCart = () => {
        document.querySelector(".orderPlaced").style.visibility="hidden";
        window.location.reload(false);
        //alert("hu");
        
    }
  return (
    <div className="orderPlaced">
        <div className="messageBox">
            <h1>Your Order Has Been Placed</h1>
            <Button onClick={() => refreshCart()}>Done</Button>
        </div>
    </div>
  )
}

export default Orderplaced