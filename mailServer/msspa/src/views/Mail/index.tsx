import './index.scss';
import React, { FC, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Layout, Menu, Button } from 'antd';

import LayoutHeader from './LayoutHeader';

import MailCompose from './MailCompose';
import MailList from './MailList';

const { Sider, Content } = Layout;

const Mail: FC = () => {
  const { category } = useParams();
  let [showCompose, setShowCompose] = useState(false);
  let [composeData, setComposeData] = useState({});

  const openCompose = (data: any = {}) => {
    setComposeData(data);
    setShowCompose(true);
  }

  const closeCompose = () => {
    setComposeData({});
    setShowCompose(false);
  }

  return (
    <Layout className="mail-container">
      <LayoutHeader />
      <Layout className="layout">
        <Sider className="sidebar">
          <div className="btn-box">
            <Button type="primary" shape="round" onClick={() => openCompose()}>Compose</Button>
          </div>
          <Menu
            className="side-menu"
            selectedKeys={[category!]}
          >
            <Menu.Item key="2">
              <Link to="/mail/list/2">Inbox</Link>
            </Menu.Item>
            <Menu.Item key="1">
              <Link to="/mail/list/1">Sent</Link>
            </Menu.Item>
            <Menu.Item key="0">
              <Link to="/mail/list/0">Draft</Link>
            </Menu.Item>
          </Menu>
        </Sider>
        <Content className="content">
          <MailList openCompose={openCompose} showCompose={showCompose}/>
          {showCompose ? <MailCompose defaultData={composeData} onClose={closeCompose}/> : null}
        </Content>
      </Layout>
    </Layout>
  );
}

export default Mail;