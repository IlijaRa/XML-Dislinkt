import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Footer from '../Components/Common/Footer'
import HomePage from '../Components/Common/HomePage'
import Navbar from '../Components/Common/Navbar'
import userServices from '../Services/UserServices/UserServices';

export default function HomePageContainer() {

let { username } = useParams();
const [user, setUser] = useState({});
const [posts, setPosts] = useState([]);

var logedUser = JSON.parse(localStorage.getItem("User"));

useEffect(() => {
  userServices.getUserByUsername(username)
    .then((data) => {
      setUser(data.data);
    })
    .catch((error) => console.log(`error`, error));

    userServices.getPostsByUserId(logedUser.id)
    .then((data) => {
      setPosts(data.data);
    })
    .catch((error) => console.log(`error`, error));

}, [])


function likePost(userId,postId) {
  userServices
    .likePost(userId,postId)
    .then((data) => {
      console.log("sucessfuly updated post");
    })
    .catch((error) => {
      console.log("Something wen't wrong try again");
    });
}



function unlikePost(userId,postId) {
  userServices
    .unlikePost(userId,postId)
    .then((data) => {
      console.log("sucessfuly updated post");
    })
    .catch((error) => {
      console.log("Something wen't wrong try again");
    });
}


  return (
    <div>
    <Navbar></Navbar>
    <HomePage
      user={user}
      posts= {posts}
      likePostHandler = {likePost}
      unlikePostHandler = {unlikePost}
    ></HomePage>
    <Footer></Footer>
  </div>
  )
}
