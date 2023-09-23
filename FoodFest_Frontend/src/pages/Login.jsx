import React, { useState,useEffect } from 'react';
import Axios from 'axios';
import { GoogleLogin} from 'react-google-login';
import { gapi } from 'gapi-script';
import {Link, NavLink} from "react-router-dom";
import { Button } from 'react-bootstrap';
import "../css pages/Login.css"
import {FaRegAddressBook} from "react-icons/fa"
import { IoEllipseSharp } from 'react-icons/io5';

const Login = () => {
    const [ profile, setProfile ] = useState(null);
    const clientId = '1000835904597-ut38ah9s6238riqo9iv189fpcje1fc37.apps.googleusercontent.com';
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loginStatus, setLoginStatus] = useState("");

    let localStorageUsername=localStorage.getItem("localStorageUsername");
    let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
  
    useEffect(() => {
        const initClient = () => {
            gapi.client.init({
                clientId: clientId,
                scope: ''
            });
        };
        gapi.load('client:auth2', initClient);

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
            Axios.post('http://localhost:8080/login', 
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
                    localStorage.setItem("localStorageLoggedState",1);
                    window.open("/", "_top");
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

    



    const onSuccess = (res) => {
        setProfile(res.profileObj);
        localStorage.setItem("localStorageLoggedState",1);
        localStorage.setItem("localStorageUsername",res.profileObj.name);
        window.location.href = "/service";

    };

    const onFailure = (err) => {
        console.log('failed', err);
        localStorage.setItem("localStorageLoggedState",0);
        localStorage.setItem("localStorageUsername",null);
    };
  
  return (
    <div className="loginpage" >
        <form className="logfrm">
            <h2>Login User</h2>
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
            <Link to="/signup" className="logToReg">Don't Have an account? SignUp </Link><br/>
            <Link to="/deliverylogin" className="logToDlog">Delivery Guy Login </Link><br/>
        </form>   
    </div>
  )
}

export default Login