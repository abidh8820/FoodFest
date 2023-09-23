import React, { useState,useEffect } from 'react';
import Axios from 'axios';
import {Link} from "react-router-dom";
import { Button } from 'react-bootstrap';
import "../css pages/Login.css"
import {FaRegAddressBook} from "react-icons/fa"
import Headernavbaradmin from './Headnavbaradmin';

const Deliverysignup = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loginStatus, setLoginStatus] = useState("");

    let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
  
    useEffect(() => {
        // if(localStorageLoggedState=="1")window.location.href = "/";
        // else if(localStorageLoggedState=="3")window.location.href = "/deliverycheckorders";
        // else if(localStorageLoggedState=="0")window.location.href = "/signup";
        // else{
        //     //
        // }
    });


    const signupUser = () => {
        setLoginStatus("please wait...");
        Axios.post('http://localhost:8080/deliverysignup',
        {
            name:username,
            password:password
        }
        ).then((response) =>{
            //alert(response.data["success"]);
            if(response.data){
                setLoginStatus("user data saved");
                localStorage.setItem("localStorageUsername",username);
                localStorage.setItem("localStorageLoggedState",3);
                //window.open("/dashboard", "_top");
                window.location.href = "/profileadmin";
                
            }
            // else if(response.data == "0"){
            //     setRegStatus("user already exists");
            // }
            else{
                setLoginStatus(response.data);
            }
        }).catch(error => {
            if (error.response && error.response.status === 400) {
                setLoginStatus("user already exists");
                // Perform appropriate action, such as redirecting to login page
            } else {
                // Handle other errors
                console.log('Error:', error.message);
            }
        });

        document.querySelector(".logfrm").reset();
        //alert("succ");
    }; 

    const divStyle = {
        overflow: "hidden",
    };

  return (
    <div style={divStyle}>
        <Headernavbaradmin/>
        <div className="loginpage" >
            <form className="logfrm">
                <h2>Delivryman Signup</h2>
                <div className="loginCreds">
                    <FaRegAddressBook className ="loginCredsIcons"/>
                    <input type="text" id="name" name="name" placeholder="Insert Usernanme" onChange={(event) => {setUsername(event.target.value);}}/><br/>
                </div>
                
                <div className="loginCreds">
                    <FaRegAddressBook className ="loginCredsIcons"/>
                    <input type="password" id="pass" name="pass" placeholder="Insert Password" onChange={(event) => {setPassword(event.target.value);}}/><br/>
                </div>
                <p>{loginStatus}</p><br/>
                <Button className="logfrmbut" onClick={signupUser}>Login</Button><br/>
                <Link to="/forgetpass" className="frgtps">Forgot password?</Link><br/>
                {/*<h3  className="logfrmbut" onClick={loginUser}>Login</h3><br/>*/}
                <Link to="/login" className="logToReg">Don't Have an Delivery account? SignUp </Link><br/>
            </form>   
        </div>
    </div>
  )
}

export default Deliverysignup