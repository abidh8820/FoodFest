import {React,useState,useEffect } from 'react';
import Axios from 'axios';
import {Link, NavLink} from "react-router-dom";
import { Button } from 'react-bootstrap';
import "../css pages/Checkorders.css"
import Headernavbaradmin from './Headnavbaradmin';

const Admincheckorders = () => {
    const [cartItems, setCartItems] = useState([]);
    let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
    let localStorageUsername=localStorage.getItem("localStorageUsername");

    useEffect(() => {
        //alert(localStorageUsername);
        // if(localStorageLoggedState=="1")window.location.href = "/";
        // else if(localStorageLoggedState=="3")window.location.href = "/deliverycheckorders";
        // else if(localStorageLoggedState=="0")window.location.href = "/";
        // else{
        //     //
        // }
        Axios.get('http://localhost:8080/admincheckorders',
        ).then((response) =>{
            //alert(JSON.stringify(response.data));
            setCartItems(response.data);
        }, [localStorageUsername]);
    });
    
    const updateorderstatus = (cartItem)=>{
        //alert(idd +" "+ cartItem.name);
        Axios.post('http://localhost:8080/updateorderstatus',
        {
            id:cartItem.idorders,
            name:cartItem.name,
            order:localStorageUsername,
            total:cartItem.total,
            time:cartItem.time,
        }
        ).then((response) =>{
            //
            //window.location.reload(false);
        });
    }

  return (
    <div>
        <Headernavbaradmin/>
        <h1>All orders are here</h1>
        <table className="orders" id="orderHead">
            <td className="orders_time">Time</td>
            <td className="orders_name">Name</td>
            <td className="ordersnestedbar">
                <div className="ordersnested">
                    <td className="orders_item_name">Item name</td>
                    <td className="orders_pieces">Quantity</td>
                </div>
            </td>
            <td className="orders_total_price">Total price</td>
            
            <td className="orders_status">Status</td>
            <br/>
        </table>
    
        {cartItems.map((cartItem) => (
            <table key={cartItem.order_id} className="orders">
                <td className="orders_time">{cartItem.time}</td>
                <td className="orders_name">{cartItem.name}</td>
                <td className="ordersnestedbar">
                    {JSON.parse(cartItem.order).map((curelem) => (
                        <div key={curelem.name} className="ordersnested">
                            <td className="orders_item_name">{curelem.name}</td>
                            <td className="orders_pieces">{curelem.prodCount}</td>
                        </div>
                    ))}
                </td>
                <td className="orders_total_price">{cartItem.total}</td>
                <td className="orders_status" onClick={()=>updateorderstatus(cartItem)}>{cartItem.status}</td>
            </table>
        ))} 
    </div>
  )
}

export default Admincheckorders