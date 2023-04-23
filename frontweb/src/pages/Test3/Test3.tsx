import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendar } from "@fortawesome/free-solid-svg-icons";

function Test2() {
  return (
    <div>
      <div className="subtitle-container"> <FontAwesomeIcon icon={faCalendar} /> <h4> Tarefas </h4></div>
      <div className="content-container">
      </div>
    </div>
  );
}

export default Test2;
