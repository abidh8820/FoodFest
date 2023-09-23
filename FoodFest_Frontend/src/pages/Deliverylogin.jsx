import React, { useState,useEffect } from 'react';
import Axios from 'axios';
import {Link} from "react-router-dom";
import { Button } from 'react-bootstrap';
import "../css pages/Login.css"
import {FaRegAddressBook} from "react-icons/fa"

const Deliverylogin = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loginStatus, setLoginStatus] = useState("");

    let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
  
    useEffect(() => {

        // if(localStorageLoggedState=="1")window.location.href = "/";
        // else if(localStorageLoggedState=="2")window.location.href = "/dashboardadmin";
        // else if(localStorageLoggedState=="3")window.location.href = "/deliverycheckorders";
        // else{
        //     //
        // }
        
    });


    const loginUser = () => {        
        
        //alert("hu "+ csrfToken);
        setLoginStatus("please wait...");
        if(username==="sheikh" && password==="rub"){
            setLoginStatus("logging in");
            localStorage.setItem("localStorageUsername",username);
            localStorage.setItem("localStorageLoggedState",2);
            window.location.href = "/dashboardadmin";
        }
        else{
            Axios.post('http://localhost:8080/deliverylogin', 
            {
                name:username,
                password:password
            }
            ).then((response) =>{
                setLoginStatus(response.data);
                if(response.data){
                    //alert("hi");
                    setLoginStatus("logging in");
                    localStorage.setItem("localStorageUsername",username);
                    localStorage.setItem("localStorageLoggedState",3);
                    window.open("/deliverycheckorders", "_top");
                }
                else{
                    setLoginStatus("Wrong id or password");
                }
            })
            .catch(error => {
                //console.error(error);
                if (error.response && error.response.status === 401) {
                    setLoginStatus("Wrong id or password");
                    // Perform appropriate action, such as redirecting to login page
                } else {
                    // Handle other errors
                    console.log('Error:', error.message);
                }
            });
        }
        //alert("succc");
        document.querySelector(".logfrm").reset();
    };  
  return (
    <div className="loginpage" >
        <form className="logfrm">
            <h2>Login Deliveryman</h2>
            <div className="loginCreds">
                <FaRegAddressBook className ="loginCredsIcons"/>
                <input type="text" id="name" name="name" placeholder="Insert Usernanme" onChange={(event) => {setUsername(event.target.value);}}/><br/>
            </div>
            
            <div className="loginCreds">
                <FaRegAddressBook className ="loginCredsIcons"/>
                <input type="password" id="pass" name="pass" placeholder="Insert Password" onChange={(event) => {setPassword(event.target.value);}}/><br/>
            </div>
            <p>{loginStatus}</p><br/>
            <Button className="logfrmbut" onClick={loginUser}>Login</Button><br/>
            <Link to="/forgetpass" className="frgtps">Forgot password?</Link><br/>
            {/*<h3  className="logfrmbut" onClick={loginUser}>Login</h3><br/>*/}
            <Link to="/login" className="logToReg">User Login</Link><br/>
        </form>   
    </div>
  )
}

export default Deliverylogin