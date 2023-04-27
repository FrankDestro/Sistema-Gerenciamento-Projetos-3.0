import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserFriends } from "@fortawesome/free-solid-svg-icons";
import CollapsibleTable from 'Components/Table';

function Test2() {
  return (
    <div>
      <div className="subtitle-container"> <FontAwesomeIcon icon={faUserFriends} /> <h4> Pagina de Projetos </h4></div>
      <div className="content-container">
      <CollapsibleTable></CollapsibleTable>
      </div>
    </div>
  );
}

export default Test2;
