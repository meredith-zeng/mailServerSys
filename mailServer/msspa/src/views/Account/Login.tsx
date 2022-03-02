import React, { FC } from 'react';
import { Link } from 'react-router-dom';
import { MailTwoTone } from '@ant-design/icons';
import {Form, Input, Button, Typography, message} from 'antd';
import { userLogin } from '../../data/api';

const { Title, Text } = Typography;

const Login: FC = () => {
  const onFinish = async (values: any) => {
    const { error } = await userLogin(values);
    if(!error) {
      message.success('log in successfully!');
      window.location.reload();
    }
  };

  const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <>
      <div className="title-box">
        <MailTwoTone className="title-icon" />
        <Title level={4}>Sign in to continue</Title>
      </div>
      <Form
        className="login-form"
        layout="vertical"
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
        autoComplete="off"
      >
        <Form.Item
          label="Email"
          name="userEmailAddress"
          rules={[{ required: true, message: 'Please input your username' }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Password"
          name="userPassword"
          rules={[{ required: true, message: 'Please input your password' }]}
        >
          <Input.Password />
        </Form.Item>

        <Button className="submit-btn" type="primary" shape="round" htmlType="submit">
          Sign in
        </Button>
        <div className="signup-text-box">
          <Text>New to email? <Link to="/account/signup">Create an account</Link></Text>
        </div>
      </Form>
    </>
  );

};

export default Login;