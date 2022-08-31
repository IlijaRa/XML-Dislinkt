import React, { useEffect, useState } from "react";
import Footer from "../Components/Common/Footer";
import JobOfferComments from "../Components/Common/JobOfferComments";
import Navbar from "../Components/Common/Navbar";
import agentServices from "../Services/AgentServices/AgentServices";

export default function JobOfferCommentsContainer() {


    const [comments, setComments] = useState([]);

    var jobOffer = JSON.parse(localStorage.getItem("JobOffer"));
  
  
    useEffect(() => {
  
          agentServices.getAllJobCommentsByJobOfferId(jobOffer)
             .then((data) => { 
                setComments(data.data);
            })
             .catch((error) => console.log(`error`, error));

             
           
    
        }, [])
  
  
         





  return <div>
  <Navbar></Navbar>
  <JobOfferComments comments={comments}></JobOfferComments>
  <Footer></Footer>
</div>
}