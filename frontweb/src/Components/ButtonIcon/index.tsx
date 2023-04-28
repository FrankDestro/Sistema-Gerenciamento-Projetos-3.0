import './styles.css';
import Spinner from 'react-bootstrap/Spinner'

type Props = {
  text: string;
  buttonState: string;
  isLoading: boolean;
  disabled?: boolean;
  textExe : string;
}

const ButtonIcon = ({ text, buttonState, isLoading, disabled, textExe }: Props) => {
  return (
    <div className="btn-container">
      <button className="btn btn-secondary btn-icon-container" disabled={disabled || isLoading}>
        {buttonState === 'loading' ? (
          <>
            <span className="mr-2">{textExe}</span>
            <Spinner
              as="span"
              animation="border"
              size="sm"
              role="status"
              aria-hidden="true"
              className="ml-2"
            />
          </>
        ) : (
          <h6>{text}</h6>
        )}
      </button>
    </div>
  );
};

 export default ButtonIcon;
