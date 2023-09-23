import React from 'react'
import {Routes, Route, Link, BrowserRouter, Navigate, useNavigate} from "react-router-dom";
import { Navbar } from 'react-bootstrap';

import Homepage from "./pages/Homepage"
import Login from "./pages/Login"
import Signup from "./pages/Signup"
import Service from "./pages/Service"
import Notfound from "./pages/Notfound"
import Headernavbar from './pages/Headernavbar';
import Forgetpass from './pages/Forgetpass';
import Dashboard from './pages/Dashboard';
import Heromain from './pages/Heromain';
import Review from './pages/Review';
import Footer from './pages/Footer';
import Contacts from './pages/Contacts';
import Products from './pages/Products';
import Fastfood from './pages/Fastfood';
import Setmenu from './pages/Setmenu';
import Shoppingcart from './pages/Shoppingcart'
import Admincheckorders from './pages/Admincheckorders';
import Drinks from './pages/Drinks';
import Streetfood from './pages/Streetfood';
import Specialfood from './pages/Specialfood';
import Dashboardadmin from './pages/Dashboardadmin';
import Headernavbaradmin from './pages/Headnavbaradmin';
import Deliverylogin from './pages/Deliverylogin';
import Deliverysignup from './pages/Deliverysignup';
import Deliverycheckorders from './pages/Deliverycheckorders';
import Deliveryheadernavbar from './pages/Deliveryheadernavbar';


const App = () =>{
  let localStorageUsername=localStorage.getItem("localStorageUsername");
  let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
  
  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* <Route path='/' element={<Homepage/>} /> */}
          <Route
            path="/"
            element={localStorageLoggedState === '2' ? <Navigate to="/dashboardadmin"/>: 
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Homepage/>}
          />
          {/* <Route path='login' element={<Login/>} /> */}
          <Route
            path="login"
            element={localStorageLoggedState === '1' ? <Navigate to="/"/> : 
            localStorageLoggedState === '2'? <Navigate to="/dashboardadmin"/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Login/>}
          />
          {/* <Route path='signup' element={<Signup/>} /> */}
          <Route
            path="signup"
            element={localStorageLoggedState === '1' ? <Navigate to="/"/> : 
            localStorageLoggedState === '2'? <Navigate to="/deliverysignup"/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Signup/>}
          />
          <Route path='service' element={<Service/>} />
          <Route path='headernavbar' element={<Headernavbar/>} />
          <Route path='headernavbaradmin' element={<Headernavbaradmin/>} />
          <Route path='forgetpass' element={<Forgetpass/>} />
          {/* <Route path='dashboard' element={<Dashboard/>} /> */}
          <Route
            path="dashboard"
            element={localStorageLoggedState === '1' ? <Dashboard /> : 
            localStorageLoggedState === '2'? <Navigate to="/dashboardadmin"/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Navigate to="/"/>}
          />
          {/* <Route path='dashboardadmin' element={<Dashboardadmin/>} /> */}
          <Route
            path="dashboardadmin"
            element={localStorageLoggedState === '1' ? <Navigate to="/dashboard"/> : 
            localStorageLoggedState === '2'? <Dashboardadmin/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Navigate to="/"/>}
          />
          <Route path="heromain" element={<Heromain/>}/>
          <Route path="contacts" element={<Contacts/>}/>
          <Route path="products" element={<Products/>}/>
          <Route path="footer" element={<Footer/>}/>
          <Route path="fastfood" element={<Fastfood/>}/>
          <Route path="setmenu" element={<Setmenu/>}/>
          <Route path="streetfood" element={<Streetfood/>}/>
          <Route path="drinks" element={<Drinks/>}/>
          <Route path="specials" element={<Specialfood/>}/>
          <Route path="shoppingcart" element={<Shoppingcart/>}/>
          {/* <Route path="admincheckorders" element={<Admincheckorders/>}/> */}
          <Route
            path="admincheckorders"
            element={localStorageLoggedState === '1' ? <Navigate to="/" /> : 
            localStorageLoggedState === '2'? <Admincheckorders/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Navigate to="/"/>}
          />
          {/* <Route path="deliverylogin" element={<Deliverylogin/>}/> */}
          <Route
            path="deliverylogin"
            element={localStorageLoggedState === '1' ? <Navigate to="/" /> : 
            localStorageLoggedState === '2'? <Navigate to="/dashboardadmin"/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Deliverylogin/>}
          />
          {/* <Route path="deliverysignup" element={<Deliverysignup/>}/> */}
          <Route
            path="deliverysignup"
            element={localStorageLoggedState === '1' ? <Navigate to="/" /> : 
            localStorageLoggedState === '2'? <Deliverysignup/> :
            localStorageLoggedState === '3'? <Navigate to="/deliverycheckorders"/>:
            <Navigate to="/signup" />}
          />
          {/* <Route path="deliverycheckorders" element={<Deliverycheckorders/>}/> */}
          <Route
            path="deliverycheckorders"
            element={localStorageLoggedState === '1' ? <Navigate to="/" /> : 
            localStorageLoggedState === '2'? <Navigate to="/admincheckorders"/> :
            localStorageLoggedState === '3'? <Deliverycheckorders/>:
            <Navigate to="/"/>}
          />
          <Route path="deliveryheadernavbar" element={<Deliveryheadernavbar/>}/>
          <Route path='*' element={<Notfound/>} />
        </Routes>
      </BrowserRouter>
    </>
  );
};

export default App;
