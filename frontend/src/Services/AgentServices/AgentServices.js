const axios = require("axios");

const agentServices = {




  createAgent: (agent) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AGENT}createAgent`,agent);
  },

  login: (username,password) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AGENT}login`,
    {
        username:username,
        password:password,
    }
    );
  },

  getAgentById: (agentId) => {
    return axios.get(`${process.env.REACT_APP_API_URL_AGENT}agentId/${agentId}`);
  },

  getAgentByUsername: (username) => {
    return axios.get(`${process.env.REACT_APP_API_URL_AGENT}username/${username}`);
  },



  ////////////////COMPANY

  getAllCompanies: () => {
    return axios.get(`${process.env.REACT_APP_API_URL_AGENT}companies`);
  },


  createCompany: (ownerId, company) => {
    return axios.post(`${process.env.REACT_APP_API_URL_AGENT}${ownerId}/create`,company);
  },

  approveCompany: (adminId, companyId) => {
    return axios.put(`${process.env.REACT_APP_API_URL_AGENT}approve`,
    {
      adminId: adminId,
      companyId: companyId,
    }
    );
  },


  updateCompany: (company) => {
    return axios.put(`${process.env.REACT_APP_API_URL_AGENT}update/${company.id}`,
   company
    );
  },

  getAllCompaniesOfOwner: (ownerId) => {
    return axios.get(`${process.env.REACT_APP_API_URL_AGENT}${ownerId}/companies`);
  },

};

export default agentServices;
