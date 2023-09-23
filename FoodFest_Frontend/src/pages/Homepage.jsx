import React, {useState, useEffect} from 'react'
import Headernavbar from './Headernavbar';
import Heromain from './Heromain';
import Footer from './Footer'
import Shoppingcart from './Shoppingcart';

import "../css pages/Homepage.css";
import Review from './Review';

const Homepage = () => {
  let localStorageMenuCart=localStorage.getItem("localStorageMenuCart");
  let localStorageUsername=localStorage.getItem("localStorageUsername");
  let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");

  useEffect(() => {
    if(localStorageLoggedState=="2")window.location.href = "/dashboardadmin";
    else if(localStorageLoggedState=="3")window.location.href = "/deliverycheckorders";
  }, [localStorageLoggedState]);
  return (
    <div>
      
      <Headernavbar/>
      <Shoppingcart/>
      <Heromain/>
      <Review/>
      <Footer/>
    </div>
    
  )
}

export default Homepage