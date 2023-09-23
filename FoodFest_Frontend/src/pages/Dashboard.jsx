import {React,useEffect,useState, Component} from 'react'
import Axios from 'axios';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { gapi } from 'gapi-script';
import Headernavbar from './Headernavbar';
import "../css pages/Dasboard.css"
import ReactApexChart from "react-apexcharts";

const Dash = () => {
    
    const clientId = '1000835904597-ut38ah9s6238riqo9iv189fpcje1fc37.apps.googleusercontent.com';
    const [ profile, setProfile ] = useState(null);
    let localStorageUsername=localStorage.getItem("localStorageUsername");
    let localStorageLoggedState=localStorage.getItem("localStorageLoggedState");
    const [myorders, setMyorders]=useState([10,20,30,20]);
    const [totalcount,setTotalcount]=useState(0);
    const [totalprice,setTotalprice]=useState(0);
    const [chartData, setChartData] = useState({
        options: {
            chart: {
                id: "basic-bar"
            }
        },
        series: [
            {
                name: "Price",
                data: myorders
            }
        ]
    });

    

    //logout from page
    const logOut = () => {
        setProfile(null);
        localStorage.setItem("localStorageLoggedState",0);
        localStorage.setItem("localStorageUsername",null);  
        window.location.href = "/";
    };

    useEffect(() => {
        // alert(localStorageLoggedState);
        //alert(localStorageUsername);
        
        // if(localStorageLoggedState=="0")window.location.href = "/";
        // else if(localStorageLoggedState=="2")window.location.href = "/dashboardadmin";
        // else if(localStorageLoggedState=="3")window.location.href = "/deliverycheckorders";
        // else{
        //     //
        // }

        Axios.post('http://localhost:8080/profile',
        {
            name:localStorageUsername
        }
        ).then((response) =>{
            //alert(JSON.stringify(response.data));
            let len=response.data.length;
            let sum=0;
            setMyorders(response.data);
            setTotalcount(len);
            
            for(let i=0;i<len;i++){
                sum+=parseInt(response.data[i]);
            }
            setTotalprice(sum);
            
            setChartData({
                options: {
                    chart: {
                        id: "basic-bar"
                    }
                },
                series: [
                    {
                        name: "Price",
                        data: myorders
                    }
                ]
            });
        }, [localStorageUsername]);
    });

    

    return (
        <>
         {/* <GoogleLogout clientId={clientId} buttonText="Log out" onLogoutSuccess={logOut} /> */}
            <Headernavbar/>
            <div className="dashboard">
                <div className="nameText">
                    <h1>Hi {localStorageUsername}</h1>
                </div>
                <div className="allInfo">
                    <div className="orderInfoBar">
                        <div className="orderInfo">
                            <h3>Order count</h3>
                            <h2>{totalcount} orders</h2>
                            <p>till today</p>
                        </div>
                        <div className="orderInfo">
                            <h3>Total Cost</h3>
                            <h2>{totalprice} Tk</h2>
                            <p>till today</p>
                        </div>
                        <div className="orderInfo">
                            <h3>Discounts</h3>
                            <h2>0 Tk</h2>
                            <p>till today</p>
                        </div>
                        <div className="orderInfo">
                            <h3>Specials</h3>
                            <h2>None</h2>
                            <p>till today</p>
                        </div>
                    </div>
                    <div className="orderGraph">
                        <ReactApexChart options={chartData.options} series={chartData.series} type="line" height={350} />
                        <div>
                            {/*myorders.map((item) => (
                                <div>
                                    <div>
                                        <p>{item}</p>
                                    </div>
                                </div>
                            ))*/}
                        </div>
                    </div>
                </div>
            </div>
            
        </>
    
  )
}

export default Dash