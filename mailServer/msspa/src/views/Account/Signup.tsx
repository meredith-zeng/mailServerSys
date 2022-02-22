import React, { FC } from 'react';
import { Link } from 'react-router-dom';
import { Form, Input, Button, Typography, Row, Col } from 'antd';

const { Title } = Typography;

const Signup: FC = () => {
  const onFinish = (values: any) => {
    console.log('Success:', values);
  };

  const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <>
      <Title level={2}>Create an account</Title>
      <Form
        className="login-form"
        layout="vertical"
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
        autoComplete="off"
      >
        <Form.Item
          label="Username"
          name="username"
          rules={[{ required: true, message: 'Please input your username!' }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Password"
          name="password"
          rules={[{ required: true, message: 'Please input your password!' }]}
        >
          <Input.Password />
        </Form.Item>

        <Form.Item
          label="Confirm Password"
          name="reenterPassword"
          rules={[{ required: true, message: 'Please confirm your password' }]}
        >
          <Input.Password />
        </Form.Item>

        <Row justify="space-around">
          <Col span={10}>
            <Button className="submit-btn" type="primary" shape="round" htmlType="submit">
              Submit
            </Button>
          </Col>
          <Col span={10}>
            <Button className="submit-btn" shape="round" htmlType="submit">
              <Link to="/account/login">Cancel</Link>
            </Button>
          </Col>
        </Row>
      </Form>
    </>
  );

};

export default Signup;