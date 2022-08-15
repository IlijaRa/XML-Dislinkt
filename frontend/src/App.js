import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import RegistrationFormContainer from './Containers/RegistrationFormContainer';
import HomePageContainer from './Containers/HomePageContainer';
import LoginContainer from './Containers/LoginContainer';

function App() {
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route path="/registration">
            <RegistrationFormContainer></RegistrationFormContainer>
          </Route>
          <Route path="/homePage">
            <HomePageContainer></HomePageContainer>
          </Route>
          <Route path="/login">
            <LoginContainer></LoginContainer>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
