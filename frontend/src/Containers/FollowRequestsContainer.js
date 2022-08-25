import React, { useEffect, useState } from 'react'
import Footer from '../Components/Common/Footer'
import FriendRequests from '../Components/Common/FriendRequests'
import Navbar from '../Components/Common/Navbar'
import userServices from '../Services/UserServices/UserServices'



export default function FollowRequestsContainer() {

  const [user, setUser] = useState({});
  const [friendRequests, setFriendRequests] = useState([]);
  
  var logedUser = JSON.parse(localStorage.getItem("User"));
 
  useEffect(() => {

    setUser(logedUser);
   
   
    for (var i = 0; i < logedUser.followRequests.length; i++) {

         userServices.getUserById(logedUser.followRequests[i])
         .then((data) => {
           
          setFriendRequests((allEvents) => [
                ...allEvents,
               data.data
              ]);

        })
         .catch((error) => console.log(`error`, error));

      }
       
    }, [])
    


  return (
    <div>   
    <Navbar></Navbar>
   <FriendRequests friendRequests={friendRequests}></FriendRequests>
    <Footer></Footer></div>
  )
}
