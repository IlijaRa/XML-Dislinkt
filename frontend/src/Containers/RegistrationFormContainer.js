import React, { useEffect, useState } from 'react'
import Footer from '../Components/Common/Footer'
import Navbar from '../Components/Common/Navbar'
import RegistrationForm from '../Components/Common/RegistrationForm'
import userServices from '../Services/UserServices/UserServices';

export default function RegistrationFormContainer() {

  






  return (
    <div>
    <Navbar></Navbar>
    <RegistrationForm

    ></RegistrationForm>
    <Footer></Footer>
  </div>
  )
}
