import './index.scss';
import React, { FC } from "react";
import { Form, Button, Input, message } from 'antd';
import { CloseOutlined } from '@ant-design/icons';

import { sendMail, draftMail } from '../../../data/api';

interface Props {
  defaultData: any,
  onClose: any,
}

const MailCompose: FC<Props> = ({defaultData, onClose}) => {
  const [form] = Form.useForm();

  const onSend = async () => {
    let values = await form.validateFields();
    if(defaultData.mailId) {
      values.mailId = defaultData.mailId;
    }
    const { error } = await sendMail(values);
    if(!error) {
      message.success('Sent successfully!');
      onClose();
    }
  }

  const onDraft = async () => {
    let values = form.getFieldsValue(true);
    if(defaultData.mailId) {
      values.mailId = defaultData.mailId;
    }
    const { error } = await draftMail(values);
    if(!error) {
      message.success('Save successfully!');
      onClose();
    }
  }

  const onFinishFailed = (errorInfo: any) => {
    console.log('Failed:', errorInfo);
  };

  const initialData = {
    recipientEmailAddress: defaultData.recipientEmailAddress,
    mailTitle: defaultData.mailTitle,
    mailContent: defaultData.mailContent,
  }

  return (
    <div className="mail-compose">
      <div className="title-box">
        <span>New Mail</span>
        <CloseOutlined className="close-icon" onClick={onClose}/>
      </div>
      <Form
        form={form}
        className="compose-form"
        layout="vertical"
        onFinishFailed={onFinishFailed}
        autoComplete="off"
        initialValues={initialData}
      >
        <Form.Item
          label="To"
          name="recipientEmailAddress"
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Title"
          name="mailTitle"
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Content"
          name="mailContent"
          className="content-box"
        >
          <Input.TextArea rows={4} />
        </Form.Item>

        <div className="opt-box">
          <Button className="submit-btn" shape="round" onClick={onDraft}>
            Save as draft
          </Button>
          <Button className="submit-btn" type="primary" shape="round" onClick={onSend}>
            Send
          </Button>
        </div>
      </Form>
    </div>
  );
}

export default MailCompose;