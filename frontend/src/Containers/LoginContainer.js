import React, { useState } from 'react'
import { Link, useHistory, useLocation } from "react-router-dom";
import Footer from '../Components/Common/Footer'
import Login from '../Components/Common/Login'
import Navbar from '../Components/Common/Navbar'
import userServices from '../Services/UserServices/UserServices';

export default function LoginContainer() {
  const history = useHistory();
  const [logedUser, setLogedUser] = useState({});


  function loginUser(username, password) {
    userServices
      .loginUser(username, password)
      .then((data) => {
        if (data.status === 204) setLogedUser();
        else {
          userServices
            .loginUser(username, password)
            .then((data) => {
              setLogedUser(data.data);
              localStorage.setItem("User", JSON.stringify(data.data));
              var user = JSON.parse(
                localStorage.getItem("User")
              );
                if (Object.keys(user).length !== 0) {
                 history.push("/homePage/nina"); 
              
                 alert("sucessfuly logedOn a cottage owner");
                 window.location.reload();
                }
               else if (Object.keys(user).length == 0) {
              } 
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }


  return (
    <div> <div>
    <Navbar></Navbar>
    <Login
  loginUserHandler={loginUser}
  logedUser={logedUser}
    ></Login>
    <Footer></Footer>
  </div></div>
  )
}
