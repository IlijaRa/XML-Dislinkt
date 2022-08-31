import React, { useEffect, useState } from "react";
import CompanyHomePage from "../Components/Common/CompanyHomePage";
import Footer from "../Components/Common/Footer";
import Navbar from "../Components/Common/Navbar";
import agentServices from "../Services/AgentServices/AgentServices";


export default function CompanyHomePageContainer() {

    const [jobOffers, setJobOffers] = useState([]);

    var company = JSON.parse(localStorage.getItem("Company"));
  
  
    useEffect(() => {
  
          agentServices.getAllJobOffersByCompany(company.id)
             .then((data) => { 
                setJobOffers(data.data);
            })
             .catch((error) => console.log(`error`, error));

             
           
    
        }, [])
  
  
          function createJobOffer(jobComment) {
             agentServices.createJobOffer(jobComment)
                .then((data) => {
                  console.log("sucessfuly createdJob comment");
                })
                .catch((error) => {
                  console.log("Something wen't wrong try again");
               });
           }
  
           function addJobComment(jobOffer) {
            agentServices.createJobComment(jobOffer)
               .then((data) => {
                 console.log("sucessfuly createdJob comment");
               })
               .catch((error) => {
                 console.log("Something wen't wrong try again");
              });
          }


  return (
    <div>   
    <Navbar></Navbar>
    <CompanyHomePage company={company} createJobOfferHandler={createJobOffer} addJobCommentHandler={addJobComment} jobOffers={jobOffers}></CompanyHomePage>
    <Footer></Footer></div>
  )
}