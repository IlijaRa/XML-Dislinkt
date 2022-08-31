import React, { Profiler, useRef } from 'react'
import { Link } from 'react-router-dom'
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";

export default function CompanyHomePage({company,jobOffers,createJobOfferHandler,addJobCommentHandler}) {

    console.log("jobOffers", jobOffers);

                                      
  let conss = useRef([React.createRef(), React.createRef()]);
  let pross = useRef([React.createRef(), React.createRef()]);
  let ratings = useRef([React.createRef(), React.createRef()]);
  let salaries = useRef([React.createRef(), React.createRef()]);
  let interviews = useRef([React.createRef(), React.createRef()]);

    
  return (
    <div><div id="card">

      <h1>{company.name}{" "} {company.username} <br />
      </h1>

      <div className="image-crop">
        <img
          id="avatar"
          src={company.profilePicture}
        />
      </div>
      <div id="bio">
        <p>
          {company.description}
        </p>
      </div>
      
      {jobOffers.map((jobOffer,i) => 

      
  (
    
  <div className="container">
    <div className="row gutters">
      <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
        <div className="card h-100">
          <div className="card-body">
            <Card className="cardContainer" style={{ width: "30rem" }}>
              <Card.Img variant="top" />
              <Card.Body>
                <Card.Title className="cardTitle">
                 {jobOffer.position} 
                </Card.Title>
            
                <Card.Text>Description: {jobOffer.description}</Card.Text>
                
              </Card.Body>
              <ListGroup className="list-group-flush">
              <ListGroupItem>
              Location: {jobOffer?.location}
  
                 
                </ListGroupItem>
                <ListGroupItem>
              Mobile: {jobOffer?.mobile}
  
              
                </ListGroupItem>
                Daily activities: 
                {jobOffer.daily_activities.map((act,i) => (
                    <ListGroupItem> 
         {act.title}
        
                    </ListGroupItem>
                    ))}


                Requirements: 
                {jobOffer.requirements.map((act,i) => (
                    <ListGroupItem> 
         {act.title}
        
                    </ListGroupItem>
                    ))}

                   
      <label>Pros</label>
      <li key={i}>
      <input type="text" className="form-control" placeholder="Pros" ref={pross.current[i]} />
      </li>
   
      <label>Cons</label>
      <li key={i}>
      <input type="text" className="form-control" placeholder="Cons" ref={conss.current[i]} />
      </li>
  
      <label>Rating</label>
      <li key={i}>
      <input type="text" className="form-control" placeholder="Rating" ref={ratings.current[i]}  />
      </li>
  
      <label>Salary</label>
      <li key={i}>
      <input type="text" className="form-control" placeholder="Salary" ref={salaries.current[i]} />
      </li>

      <label>Interview</label>
      <li key={i}>
      <input type="text" className="form-control" placeholder="Interview" ref={interviews.current[i]}   />
      </li>
    

    
              </ListGroup>
              <Card.Body>
              <Button
                  
                  onClick={() =>  addJobCommentHandler({
                  pros: pross.current[i].current.value,
                  cons: conss.current[i].current.value,
                  rating: ratings.current[i].current.value,
                  salary: salaries.current[i].current.value,
                  interview: interviews.current[i].current.value,
                  jobOfferId: jobOffer.id
                })}
                  style={{ width: "12rem" }}
                  variant="outline-success"
                >
                 Add comment
                </Button>

                <Button
                 onClick={() => {
                  localStorage.setItem("JobOffer", JSON.stringify(jobOffer));
                }}
                  href="jobOfferComments"
                  style={{ width: "12rem" }}
                  variant="outline-info"
                >
                View comments
                </Button>
               
              
              </Card.Body>
            </Card>
          </div>
        </div>
      </div>
    </div>
  </div>
  ))}
</div>
    </div>
  )
}
