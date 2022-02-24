import React, { FC } from 'react';
import { UserOutlined } from '@ant-design/icons';
import { Popover, Layout } from 'antd';

import { userLogout } from '../../data/api';

import { useUser } from '../../UserProvider';

const { Header } = Layout;

const LayoutHeader: FC = () => {
  const { user } = useUser();
  const logoutFnc = async () => {
    const { error } = await userLogout();
    if(!error) {
      window.location.reload();
    }
  }

  return (
    <Header className="header">
      <div className="header-title">Mail</div>
      
      <Popover
        overlayClassName="user-menu-pop"
        content={<div className="logout-btn" onClick={logoutFnc}>Sign Out</div>} 
        trigger="hover" 
        placement="bottomRight"
      >
        <div className="icon-container">
          <UserOutlined className="header-icon"/>
          <span>{user.username}</span>
        </div>
      </Popover>
    </Header>
  );
}

export default LayoutHeader;