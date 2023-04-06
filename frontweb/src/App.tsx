import Navbar from 'Components/Navbar';
import SideNav from 'Components/SideNav';
import Test1 from 'pages/Test1/Test1';
import './App.css';
import './assets/styles/custom.scss';

function App() {

  return (
    <>
      <Navbar />
      <div className="main-container">
        <SideNav />
        <div className="app-container">
          <Test1 />
        </div>
      </div>
    </>
  );
}

export default App;
