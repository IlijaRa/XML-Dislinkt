import React from "react";
import {
    Card,
    ListGroup,
    ListGroupItem,
    CardGroup,
    Button,
  } from "react-bootstrap";

export default function AllCompanies({companies}) {


console.log("companies", companies);
var companiess = companies.filter(obj => {
    return obj.approved === true
  })

  console.log("comp", companiess);
  

  return ( <div><div className="header">
  {" "}
  <h1 style={{ textAlign: "center" }}> All companies </h1>
  </div>
  
  {companiess.map((company,i) => 
  
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
                 {company.name}
                </Card.Title>
                <Card.Text>Description: {company.description}</Card.Text>
                <Card.Text>Address: {company.address}</Card.Text>
                
              </Card.Body>
              <ListGroup className="list-group-flush">
              <ListGroupItem>
              Email: {company.email}
  
                 
                </ListGroupItem>
                <ListGroupItem>
              Mobile: {company.mobile}
  
                 
                </ListGroupItem>
                <ListGroupItem> 
            <img src={company?.profilePicture} className="center" width="200"
                      height="170"
                      />
           
                      </ListGroupItem>
  
              </ListGroup>
              <Card.Body>
            
                <Button
                  style={{ width: "12rem" }}
                  variant="outline-success"
                >
              Videcemo nesto
                </Button>
              
              
              </Card.Body>
            </Card>
          </div>
        </div>
      </div>
    </div>
  </div>
  ))}</div>);
  }
  