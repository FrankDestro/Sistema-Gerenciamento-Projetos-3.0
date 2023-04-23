import Navbar from 'Components/Navbar';
import SideNav from 'Components/SideNav';
import Auth from 'pages/Auth';
import Projetos from 'pages/Projetos/projetos';
import Test2 from 'pages/Test2/Test2';
import Test3 from 'pages/Test3/Test3';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';

function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Redirect from="/auth" to="/auth/login" exact />
        <Route path="/auth">
          <Auth />
        </Route>


        <Route path="/home">
          <Navbar />
          <div className="main-container">
            <SideNav />
            <div className="app-container">
              <Projetos />
            </div>
          </div>
        </Route>

        <Route path="/projetos">
          <Navbar />
          <div className="main-container">
            <SideNav />
            <Route path="/projetos">
            <div className="app-container">
              <Test2 />
            </div>
            </Route>
          </div>
        </Route>


        <Route path="/tarefas">
          <Navbar />
          <div className="main-container">
            <SideNav />
            <Route path="/tarefas">
            <div className="app-container">
              <Test3 />
            </div>
            </Route>
          </div>
        </Route>


      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
