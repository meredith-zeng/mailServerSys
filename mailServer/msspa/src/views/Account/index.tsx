import './index.scss';
import React, { FC } from 'react';
import { Outlet } from 'react-router-dom';

const Account: FC = () => (
  <div className="account-container">
    <div className="account-form">
      <Outlet />
    </div>
  </div>
);

export default Account;