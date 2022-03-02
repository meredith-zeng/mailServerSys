import axios from "axios";
import { message } from 'antd';

axios.defaults.withCredentials = true;

// const baseUrl = '';
const baseUrl = 'http://localhost:8080';

const getData = async (axiosParams: any, showTip = true) => {
  try {
    const { data } = await axios(axiosParams);
    if(!data.success) {
      if(showTip) {
        message.error(data.message);
      }
      return {
        error: data.message
      };
    } else {
      return {
        data: data.data
      }
    }
  } catch (e: any) {
    if(showTip) {
      message.error(e.message);
    }
    return {
      error: e.message
    };
  }
}

export const userLogout = async () => {
  return getData({
    url: `${baseUrl}/user/logout`,
  })
}

export const userLogin = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/user/login`,
    data: params
  })
}

export const userInfo = async () => {
  return getData({
    url: `${baseUrl}/user/info`,
  }, false)
}

export const userSignup = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/user/signup`,
    data: params
  })
}

export const getMailList = async (params: any) => {
  return getData({
    url: `${baseUrl}/mail/list`,
    params,
  })
}

export const readMail = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/mail/read`,
    data: params
  })
}

export const deleteMail = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/mail/delete`,
    data: params
  })
}

export const sendMail = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/mail/send`,
    data: params
  })
}

export const draftMail = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/mail/draft`,
    data: params
  })
}

