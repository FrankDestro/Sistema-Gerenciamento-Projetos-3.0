import { Route, Switch } from 'react-router-dom';
import { ReactComponent as AuthImage } from 'assets/images/auth-image.svg';
import Login from './Login';
import './styles.css';

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="login-container">
        <div className="auth-banner-container">
          {/* <h1>Management Project</h1> */}
          <AuthImage />
        </div>
        <div className="auth-form-container">
          <Switch>
            <Route path="/auth/login">
              <Login />
            </Route>
            <Route path="/auth/signup">
              <h1>Card de Signup</h1>
            </Route>
            <Route path="/auth/recover">
              <h1>Card de Recover</h1>
            </Route>
          </Switch>
        </div>
      </div>
    </div>
  );
};

export default Auth;
