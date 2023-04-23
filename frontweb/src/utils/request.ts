import axios, { AxiosRequestConfig } from "axios";
import { getAuthData } from "./storage";
import history from './history';
import qs from "qs";

// URL DE COMUNICAÇÃO COM API BACKEND
export const BASE_URL =  process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';

const CLIENT_ID = process.env.REACT_APP_CLIENT_ID ?? 'managmentProjectSystem';
const CLIENT_SECRET = process.env.REACT_APP_CLIENT_SECRET ?? 'managmentProjectSystem%%669087';


// REQUISIÇÃO DE LOGIN BACKEND
type LoginData = {
    username: string;
    password: string;
  };
  
  export const requestBackendLogin = (loginData: LoginData) => {
    const headers = {
      'Content-Type': 'application/x-www-form-urlencoded',
      Authorization: 'Basic ' + window.btoa(CLIENT_ID + ':' + CLIENT_SECRET),
    };
  
    const data = qs.stringify({
      ...loginData,
      grant_type: 'password',
    });
  
    return axios({
      method: 'POST',
      baseURL: BASE_URL,
      url: '/oauth/token',
      data,
      headers,
    });
  };

  // REQUISIÇÃO DO BACKEND PARA ROTAS AUTORIZADAS.
export const requestBackend = (config: AxiosRequestConfig) => {
    const headers = config.withCredentials
      ? {
          ...config.headers,
          Authorization: 'Bearer ' + getAuthData().access_token,
        }
      : config.headers;
  
    return axios({ ...config, baseURL: BASE_URL, headers });
  };

// INTERCEPTIONS
axios.interceptors.request.use(
    function (config) {
      console.log('INTERCEPTOR ANTES DA REQUISIÇÃO');
      return config;
    },
    function (error) {
      console.log('INTERCEPTOR ERRO DA REQUISIÇÃO');
      return Promise.reject(error);
    }
  );
  
  axios.interceptors.response.use(
    function (response) {
      console.log('INTERCEPTOR RESPOSTA COM SUCESSO');
      return response;
    },
    function (error) {
      if (error.response.status === 401) {
        console.log('INTERCEPTOR RESPOSTA COM ERRO');
        history.push('/auth');
      }
      return Promise.reject(error);
    }
  );
  