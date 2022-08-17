const axios = require("axios");

const userServices = {
  getUserByUsername: (username) => {
    return axios.get(`${process.env.REACT_APP_API_URL_USER}user?username=${username}`);
  },

  getUserByEmail: (email) => {
    return axios.get(`${process.env.REACT_APP_API_URL_USER}userByEmail?email=${email}`);
  },

  loginUser: (username,password) =>{
    return axios.post(`${process.env.REACT_APP_API_URL_USER}login`, {
      username: username,
      password: password,
    });
  }
};

export default userServices;
