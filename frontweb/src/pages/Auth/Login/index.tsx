import { Link, useHistory, useLocation } from 'react-router-dom';
import './styles.css';
import ButtonIcon from 'Components/ButtonIcon';
import { ReactComponent as LogonIcon } from 'assets/images/logon-icon.svg';
import { useContext, useState } from 'react';
import { AuthContext } from 'AuthContext';
import { useForm } from 'react-hook-form';
import { requestBackendLogin } from 'utils/request';
import { saveAuthData } from 'utils/storage';
import { getTokenData } from 'utils/auth';

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

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();

  const history = useHistory();

  const onSubmit = (formData: FormData) => {
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
        <div className="alert alert-danger">Erro ao tentar efetuar o login</div>
      )}
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="form-floating mb-4 input">
          <input
            {...register('username', {
              required: 'Campo obrigatório',
              pattern: {
                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                message: 'Email inválido',
              },
            })}
            type="text"
            className={`form-control base-input ${
              errors.username ? 'is-invalid' : ''
            }`}
            placeholder="Email"
            name="username"
          />
            <div className="invalid-feedback d-block">
            {errors.password?.message}
          </div>
          <label>E-mail</label>
        </div>
        <div className="mb-2 form-floating">
          <input
            {...register('password', {
              required: 'Campo obrigatório',
            })}
            type="password"
            className={`form-control base-input ${
              errors.password ? 'is-invalid' : ''
            }`}
            placeholder="Password"
            name="password"
            autoComplete="current-password"
          />
          <div className="invalid-feedback d-block">
            {errors.password?.message}
          </div>
          <label>Password</label>
        </div>
        <Link to="/auth/recover" className="login-link-recover">
          Esqueci a senha
        </Link>
        <div className="login-submit">
          <ButtonIcon text="Fazer login" />
        </div>
      </form>
    </div>
  );
}

export default Login;
