const axios = require("axios");

const userServices = {
  getUserByUsername: (username) => {
    return axios.get(`${process.env.REACT_APP_API_URL_USER}user?username=${username}`);
  },

  getUserByEmail: (email) => {
    return axios.get(`${process.env.REACT_APP_API_URL_USER}userByEmail?email=${email}`);
  },
};

export default userServices;
