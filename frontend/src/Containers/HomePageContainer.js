import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Footer from '../Components/Common/Footer'
import HomePage from '../Components/Common/HomePage'
import Navbar from '../Components/Common/Navbar'
import userServices from '../Services/UserServices/UserServices';

export default function HomePageContainer() {

let { username } = useParams();
const [user, setUser] = useState({});

useEffect(() => {
  userServices.getUserByUsername("nikolaakv")
    .then((data) => {
      setUser(data.data);
    })
    .catch((error) => console.log(`error`, error));
}, [])



  return (
    <div>
    <Navbar></Navbar>
    <HomePage
      user={user}
    ></HomePage>
    <Footer></Footer>
  </div>
  )
}
