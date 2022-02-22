import './index.css';
import React from 'react';
import ReactDOM from 'react-dom';
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";

import UserProvider from './UserProvider';

import Account from './views/Account';
import Login from './views/Account/Login';
import Signup from './views/Account/Signup';
import Mail from './views/Mail';

import App from './App';

ReactDOM.render(
  <React.StrictMode>
    <UserProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<App />}>
            <Route path="account" element={<Account />}>
              <Route path="login" element={<Login />} />
              <Route path="signup" element={<Signup />} />
              <Route path="/account" element={<Navigate to="/account/login" replace/>} />
            </Route>
            <Route path="mail">
              <Route path="list/:category" element={<Mail />}/>
              <Route path="/mail" element={<Navigate to="/mail/list/2" replace/>} />
            </Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </UserProvider>
  </React.StrictMode>,
  document.getElementById('root')
);
