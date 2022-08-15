import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from "react-router-dom";
import RegistrationFormContainer from './Containers/RegistrationFormContainer';

function App() {
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route path="/registration">
            <RegistrationFormContainer></RegistrationFormContainer>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
