import React, { useEffect, useState } from 'react'
import Footer from '../Components/Common/Footer'
import Navbar from '../Components/Common/Navbar'
import NewFeeds from '../Components/Common/NewFeeds'
import postService from '../Services/PostServices/PostServices';
import userServices from '../Services/UserServices/UserServices';

export default function NewFeedContainer() {

    const [user, setUser] = useState({});
    const [posts, setPosts] = useState([]);
    const [post,setPost] = useState({});

    var logedUser = JSON.parse(localStorage.getItem("User"));
   

    useEffect(() => {

    setUser(logedUser);
   
   
    for (var i = 0; i < logedUser.following.length; i++) {

         userServices.getPostsByUserId(logedUser.following[i])
         .then((data) => {
           
            setPosts((allEvents) => [
                ...allEvents,
               data.data
              ]);

        })
         .catch((error) => console.log(`error`, error));

      }
       
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
  
  
  function addComment(comment,postId) {
    postService
      .createComment(comment,postId)
      .then((data) => {
        console.log("sucessfuly updated post");
        window.location.reload();
  
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }


  function createPost(post) {
    postService.cratePost(post)
      .then((data) => {
        if (data.status === 204) setUser({});
        else {
          setPost(data.data.content);
          console.log("sucessfuly added a post");
       
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  

  return (
    <div> 
    <Navbar></Navbar>
    <NewFeeds 
      user={user} posts={posts}  
      likePostHandler = {likePost}
      unlikePostHandler = {unlikePost}
      addCommentHandler = {addComment} 
      createPostHandler = {createPost}>
      </NewFeeds>
    <Footer></Footer>
  </div>
  )
}