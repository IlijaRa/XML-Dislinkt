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
  },

  getPostsByUserId: (userId) => {
    return axios.get(`${process.env.REACT_APP_API_URL_POST}post?userId=${userId}`);
  },


  likePost: (userId,postId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL_POST}like`,
      {
        userId: userId,
        postId: postId,
      }
    );
  },

  createUser: (user) => {
    return axios.post(`${process.env.REACT_APP_API_URL_USER}create`,user);
  },

  unlikePost: (userId,postId) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL_POST}dislike`,
      {
        userId: userId,
        postId: postId,
      }
    );
  }



};

export default userServices;
