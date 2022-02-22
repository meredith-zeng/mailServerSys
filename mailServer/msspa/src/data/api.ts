import axios from "axios";
import { message } from 'antd';

axios.defaults.withCredentials = true;

const baseUrl = '';
// const baseUrl = 'localhost:8000';

const getData = async (axiosParams: any, showTip = true) => {
  try {
    const { data } = await axios(axiosParams);
    if(data.code !== 200) {
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
  // return getData({
  //   url: `${baseUrl}/user/info`,
  // }, false)

  return {
    data: {
      username: 'testUserName',
    },
    error: null
  }
}

export const userSignup = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/user/signup`,
    data: params
  })
}

export const getMailList = async (params: any) => {
  // return getData({
  //   url: `${baseUrl}/mail/list`,
  //   params,
  // })

  return {
    data: {
      total: 200,
      page: 0,
      list: [{
        id: 1111,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 2222,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 3333,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 4444,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 55,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 66,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 77,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 88,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }, {
        id: 99,
        sender: 'xxxxxxxxx',
        recipient: 'yyyyyyyyy',
        title: 'imtitleimtitleimtitleimtitleimtitle',
        content: 'imcontentimcontentimcontentimcontentimcontent',
        sendingTime: 1645468819229,
        status: 0,
      }]
    },
    error: null
  };
}

export const readMail = async (params: any) => {
  return getData({
    method: 'POST',
    url: `${baseUrl}/mail/read`,
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

