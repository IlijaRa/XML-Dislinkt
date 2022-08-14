import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.css'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  
} from "react-router-dom";
import "./index.css";
import RegistrationContainer from './Containers/RegistrationContainer';

function App() {
  return (
    <div className="container">
    <Router>
      <Switch>
        <Route path="/registration">
          <RegistrationContainer></RegistrationContainer>
        </Route>
      </Switch>
    </Router>
  </div>
  );
}

export default App;
