import AccountMenu from 'Components/MenuProfileIcon';
import Notification from 'Components/NotificationIcon';
import { useEffect, useRef, useState } from 'react';
import { TokenData, getTokenData, isAuthenticated } from 'utils/auth';
import history from 'utils/history';
import { removeAuthData } from '../../utils/storage';

import './styles.css';

function Navbar() {
  type AuthData = {
    authenticated: boolean;
    tokenData?: TokenData;
  };

  const [autData, setAuthData] = useState<AuthData>({ authenticated: false });

  useEffect(() => {
    if (isAuthenticated()) {
      setAuthData({ authenticated: true, tokenData: getTokenData() });
    } else {
      setAuthData({
        authenticated: false,
      });
    }
  }, []);

  const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
    event.preventDefault();
    removeAuthData();
    setAuthData({
      authenticated: false,
    });
    history.replace('/');
  };

  // Perfil
  const [showMenu, setShowMenu] = useState(false);
  const menuRef = useRef<HTMLUListElement | null>(null);

  const handleClick = () => {
    setShowMenu(!showMenu);
  };

  const handleClickOutside = (event: MouseEvent) => {
    if (menuRef.current && !menuRef.current.contains(event.target as Node)) {
      setShowMenu(false);
    }
  };

  useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  // Notification
  const [showMenu1, setShowMenu1] = useState(false);
  const menuRef1 = useRef<HTMLDivElement | null>(null);

  const handleClick1 = () => {
    setShowMenu1(!showMenu);
  };

  const handleClickOutside1 = (event: MouseEvent) => {
    if (menuRef1.current && !menuRef1.current.contains(event.target as Node)) {
      setShowMenu1(false);
    }
  };

  useEffect(() => {
    document.addEventListener('mousedown', handleClickOutside1);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside1);
    };
  }, []);

  console.log();

  return (
    <nav className="navbar">
      <div className="navbar-logo">
        <h6>SUITE</h6>
      </div>
      <div className="navbar-right">
        <div>
          <span className="auth-logon-email">
            {autData.tokenData?.user_name}{' '}
          </span>
        </div>
        {/* <div className="navbar-icon">
          <FontAwesomeIcon icon={faEnvelope} />
          <span className="navbar-icon-badge">6</span>
        </div> */}
        <Notification />
        {/* <div className="navbar-icon">
          <FontAwesomeIcon icon={faBell} onClick={handleClick1} />
          <span className="navbar-icon-badge">1</span>
          {showMenu1 && (
            <div className="notification-container" ref={menuRef1}></div>
          )}
        </div> */}
        {/* <div className="navbar-icon" onClick={handleClick}>
          <FontAwesomeIcon icon={faUser} />
          {showMenu && (
            <ul className="perfil-menu" ref={menuRef}>
              <li><FontAwesomeIcon icon={faUserEdit} /> <a href="#">Editar Perfil</a></li>
              <li> <FontAwesomeIcon icon={faGears} /> <a href="#">Configurações</a></li>
              <li > <FontAwesomeIcon icon={faDoorOpen} /> <a href="/auth" onClick={handleLogoutClick}>Sair</a></li>
            </ul>
          )}
        </div> */}
        <AccountMenu />
      </div>
    </nav>
  );
}

export default Navbar;
