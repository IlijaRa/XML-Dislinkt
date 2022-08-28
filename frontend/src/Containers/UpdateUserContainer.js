import React, { useState } from "react";
import Footer from "../Components/Common/Footer";
import Navbar from "../Components/Common/Navbar";
import UpdateUser from "../Components/Common/UpdateUser";
import userServices from "../Services/UserServices/UserServices";

export default function UpdateUserContainer() {

    
    const [user, setUser] = useState({});
   
  
    var logedUser = JSON.parse(localStorage.getItem("User"));
     
    const [tags, setTags] = useState(logedUser.skills);
    const [tags1, setTags1] = useState(logedUser.interests);
    const [tags2, setTags2] = useState(logedUser.education);
    const [tags3, setTags3] = useState(logedUser.experience);

    console.log("logedUser1", logedUser.skills);
    
  
      function updateUser(user) {
          userServices.updateUser(user)
            .then((data) => {
              if (data.status === 204) setUser({});
              else {
                setUser(data.data.content);
                alert("sucessfuly updated a user");
              }
            })
            .catch((error) => {
              console.log("Something wen't wrong try again", error);
            });
        }

        const removeTags = (indexToRemove) => {
            setTags([...tags.filter((_, index) => index !== indexToRemove)]);
          };
          const addTags = (event) => {
            if (event.target.value !== "") {
              setTags([...tags, event.target.value]);
              //  props.selectedTags([...tags, event.target.value]);
        
              event.target.value = "";
            }
          };
    


          const removeTags1 = (indexToRemove) => {
            setTags1([...tags1.filter((_, index) => index !== indexToRemove)]);
          };
          const addTags1 = (event) => {
            if (event.target.value !== "") {
              setTags1([...tags1, event.target.value]);
              //  props.selectedTags([...tags, event.target.value]);
              event.target.value = "";
            }
          };


          
        const removeTags2 = (indexToRemove) => {
            setTags2([...tags2.filter((_, index) => index !== indexToRemove)]);
          };
          const addTags2 = (event) => {
            if (event.target.value !== "") {
              setTags2([...tags2, event.target.value]);
              event.target.value = "";
            }
          };
    


          const removeTags3 = (indexToRemove) => {
            setTags3([...tags3.filter((_, index) => index !== indexToRemove)]);
          };
          const addTags3 = (event) => {
            if (event.target.value !== "") {
              setTags3([...tags3, event.target.value]);
              event.target.value = "";
            }
          };
    
    


  return <div>
    <Navbar></Navbar>
    <UpdateUser  
        tags={tags}
        removeTags={removeTags}
        addTags={addTags} 
        tags1={tags1}
        removeTags1={removeTags1}
        addTags1={addTags1}
        tags2={tags2}
        removeTags2={removeTags2}
        addTags2={addTags2} 
        tags3={tags3}
        removeTags3={removeTags3}
        addTags3={addTags3}

        updateUserHandler={updateUser} logedUser={logedUser}></UpdateUser>
    <Footer></Footer>
  </div>;
}
