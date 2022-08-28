import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import RegistrationFormContainer from './Containers/RegistrationFormContainer';
import HomePageContainer from './Containers/HomePageContainer';
import LoginContainer from './Containers/LoginContainer';
import PublicProfilesContainer from './Containers/PublicProfilesContainer';
import NewFeedContainer from './Containers/NewFeedContainer';
import FollowRequestsContainer from './Containers/FollowRequestsContainer';
import MessageContainer from './Containers/MessageContainer';
import JobOffersContainer from './Containers/JobOffersContainer';
import CreateJobOfferContainer from './Containers/CreateJobOfferContainer';
import UpdateUserContainer from './Containers/UpdateUserContainer';


function App() {
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route path="/registration">
            <RegistrationFormContainer></RegistrationFormContainer>
          </Route>
          <Route path="/homePage/:username">
            <HomePageContainer></HomePageContainer>
          </Route>
          <Route path="/login">
            <LoginContainer></LoginContainer>
          </Route>
          <Route path="/publicProfiles">
            <PublicProfilesContainer></PublicProfilesContainer>
          </Route>
          <Route path="/newFeed">
            <NewFeedContainer></NewFeedContainer>
          </Route>
          <Route path="/followRequests">
            <FollowRequestsContainer></FollowRequestsContainer>
          </Route>
          <Route path="/messages">
            <MessageContainer></MessageContainer>
          </Route>
          <Route path="/jobOffers">
            <JobOffersContainer></JobOffersContainer>
          </Route>
          <Route path="/createJobOffer">
            <CreateJobOfferContainer></CreateJobOfferContainer>
          </Route>
          <Route path="/updateUser">
            <UpdateUserContainer></UpdateUserContainer>
          </Route>
         
        </Switch>
      </Router>
    </div>
  );
}

export default App;
