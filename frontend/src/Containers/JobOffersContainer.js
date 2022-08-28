import React, { useEffect, useState } from "react";
import Footer from "../Components/Common/Footer";
import JobOffers from "../Components/Common/JobOffers";
import Navbar from "../Components/Common/Navbar";
import jobOfferService from "../Services/JobOfferServices/JobOfferServices";

export default function JobOffersContainer() {

    const [user, setUser] = useState({});
    const [jobOffers, setJobOffers] = useState([]);

    var logedUser = JSON.parse(localStorage.getItem("User"));


    useEffect(() => {

          jobOfferService.getAllJobOffers()
             .then((data) => { 
                setJobOffers(data.data);
            })
             .catch((error) => console.log(`error`, error));
    
        }, [])


        function searchByPosition(search) {
            jobOfferService.findJobOfferBySearch(search)
              .then((data) => {
                setJobOffers(data.data);
                console.log("sucessfuly searched");
              })
              .catch((error) => {
                console.log("Something wen't wrong try again");
              });
          }
    

return <div>
    <Navbar></Navbar>
    <JobOffers jobOffers={jobOffers} searchByPositionHandler={searchByPosition}></JobOffers>
    <Footer></Footer>
</div>
}
