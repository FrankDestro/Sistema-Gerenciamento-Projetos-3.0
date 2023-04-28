import Alert from '@mui/material/Alert';
import TextField from '@mui/material/TextField';
import { AuthContext } from 'AuthContext';
import ButtonIcon from 'Components/ButtonIcon';
import { ReactComponent as LogonIcon } from 'assets/images/logon-icon.svg';
import { useContext, useState } from 'react';

import { useForm } from 'react-hook-form';
import { Link, useHistory, useLocation } from 'react-router-dom';
import { getTokenData } from 'utils/auth';
import { requestBackendLogin } from 'utils/request';
import { saveAuthData } from 'utils/storage';

import './styles.css';

type FormData = {
  username: string;
  password: string;
};

type LocationState = {
  from: string;
};

function Login() {
  const location = useLocation<LocationState>();

  const { from } = location.state || { from: { pathname: '/home' } };

  const { setAuthContextData } = useContext(AuthContext);

  const [hasError, setHasError] = useState(false);

  const [isLoading, setIsLoading] = useState(false);

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();

  const history = useHistory();

  const onSubmit = (formData: FormData) => {
    setIsLoading(true);
    requestBackendLogin(formData)
      .then((response) => {
        saveAuthData(response.data);
        setHasError(false);
        setAuthContextData({
          authenticated: true,
          tokenData: getTokenData(),
        });
        history.replace(from);
      })
      .catch((error) => {
        setIsLoading(false);
        setHasError(true);
        console.log('ERRO', error);
      });
  };

  return (
    <div className="login-card">
      <div className="profile-icon">
        <LogonIcon />
      </div>
      <h1>logar</h1>
      {hasError && (
        <div className="alert-erro-logon">
          <Alert variant="filled" severity="error">
            Erro ao efetuar Logon!
          </Alert>
        </div>
      )}
      <form onSubmit={handleSubmit(onSubmit)}>
        <TextField
          id="outlined-textarea"
          label="E-mail"
          placeholder="example@gmail.com"
          multiline
          {...register('username', {
            required: 'Campo obrigatório',
            pattern: {
              value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
              message: 'Email inválido',
            },
          })}
          name="username"
          type="text"
          className={`form-control base-input ${
            errors.username ? 'is-invalid' : ''
          }`}
        />
        <div className="form-floating mb-4 input">
          <div className="invalid-feedback d-block">
            {errors.username?.message}
          </div>
        </div>

        <TextField
          id="outlined-password-input"
          label="Password"
          type="password"
          autoComplete="current-password"
          {...register('password', {
            required: 'Campo obrigatório',
          })}
          name="password"
          className={`form-control base-input ${
            errors.password ? 'is-invalid' : ''
          }`}
        />
        <div className="form-floating mb-4 input">
          <div className="invalid-feedback d-block">
            {errors.password?.message}
          </div>
        </div>

        <Link to="/auth/recover" className="login-link-recover">
          Esqueci a senha
        </Link>
        <div className="login-submit">
          <ButtonIcon
            text="Entrar"
            buttonState={isLoading ? 'loading' : 'idle'}
            isLoading={isLoading}
            disabled={isLoading}
            textExe={"Logando"}
          />
        </div>
      </form>
    </div>
  );
}

export default Login;
