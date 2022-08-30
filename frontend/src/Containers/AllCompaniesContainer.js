import React, { useEffect, useState } from "react";
import AllCompanies from "../Components/Common/AllCompanies";
import Footer from "../Components/Common/Footer";
import Navbar from "../Components/Common/Navbar";
import agentServices from "../Services/AgentServices/AgentServices";

export default function AllCompaniesContainer() {

    const [companies, setCompanies] = useState([]);

    var logedUser = JSON.parse(localStorage.getItem("User"));
  
  
    useEffect(() => {
  
          agentServices.getAllCompanies()
             .then((data) => { 
                setCompanies(data.data);
            })
             .catch((error) => console.log(`error`, error));
    
        }, [])
  
  
        //  function updateCompany(company) {
        //     agentServices.updateCompany(company)
        //        .then((data) => {
        //          console.log("sucessfuly updated");
        //        })
        //        .catch((error) => {
        //          console.log("Something wen't wrong try again");
        //        });
        //    }
  
  
  
    return  (
      <div>   
      <Navbar></Navbar>
      <AllCompanies companies={companies}></AllCompanies>
      <Footer></Footer>
      </div>
    )
  
    }