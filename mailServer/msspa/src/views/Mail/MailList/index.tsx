import './index.scss';
import dayjs from 'dayjs';
import utc from 'dayjs/plugin/utc';
import React, { FC, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Pagination, Typography, message } from 'antd';
import { ArrowLeftOutlined, DeleteOutlined } from '@ant-design/icons';

import { deleteMail, getMailList, readMail } from '../../../data/api';

const { Text, Title, Paragraph } = Typography;

const PAGE_SIZE = 20;

dayjs.extend(utc);

interface Props {
  openCompose: any,
  showCompose: boolean
}

const MailList: FC<Props> = ({openCompose, showCompose}) => {
  const { category } = useParams();
  let [page, setPage] = useState(1);
  let [listData, setListData] = useState<any>({});
  let [detailData, setDetailData] = useState<any>({});
  let [showDetail, setShowDetail] = useState<any>(false);

  const changePage = (val: number) => {
    setPage(val);
  }

  useEffect(() => {
    if(!showDetail || !showCompose) {
      getMailList({
        category,
        page: page,
        size: PAGE_SIZE
      }).then(({data}) => {
        setListData(data);
      })
    }
  }, [page, category, showDetail, showCompose])

  useEffect(() => {
    setShowDetail(false);
  }, [category])

  const returnToList = (item: any) => {
    setShowDetail(false);
  }

  const onSelectItem = (item: any) => {
    if(category === "2") {
      readMail({mailId: item.mailId});
    }

    if(category !== "0") {
      setDetailData(item);
      setShowDetail(true);
    } else {
      openCompose(item);
    }
  }

  const onDelete = async () => {
    const { error } = await deleteMail({
      mailId: detailData.mailId,
      category: category
    })

    if(!error) {
      message.success('Deleted successfully!');
      setShowDetail(false);
    }
  }

  const listContent = (
    <div className="mail-list-container">
      <div className="list-pagination">
        <Pagination 
          simple 
          current={page} 
          onChange={changePage} 
          pageSize={PAGE_SIZE} 
          total={listData.total} 
        />
      </div>
      <div className="mail-content">
      {listData.list && listData.list.map((item:any) => {
        let isRead = category === '2' && item.readStatus === 1;
        return (
          <div key={item.mailId} className={`mail-list-item ${isRead ? 'item-read' : ''}`} onClick={() => {onSelectItem(item)}}>
            <Text className="mail-people" ellipsis>{category === "2" ? item.senderEmailAddress : item.recipientEmailAddress}</Text>
            <Text className="mail-info" ellipsis>
              <Text className="mail-title">{item.mailTitle}</Text>
              <Text className="mail-content"> - {item.mailContent}</Text>
            </Text>
            <Text className="mail-time">{dayjs(item.sendingTime).utcOffset(0).format('h:mm A')}</Text>
          </div>
        );
      })}
      </div>
    </div>
  );

  const detailContent = (
    <div className="mail-list-container">
      <div className="mail-opt">
        <ArrowLeftOutlined className="opt-back" onClick={returnToList}/>
        <DeleteOutlined className="opt-del" onClick={onDelete} />
      </div>
      <div className="mail-content mail-detail">
        <Title className="mail-title" level={2}>{detailData.mailTitle}</Title>
        <div className="mail-people">
          <div className="name-box">
            <div className="mail-sender">{detailData.senderEmailAddress}</div>
            <div className="mail-recipient">to {detailData.recipientEmailAddress}</div>
          </div>
          <div className="send-time">{dayjs(detailData.sendingTime).utcOffset(0).format('MMM DD, YYYY, h:mm A')}</div>
        </div>
        <Paragraph className="mail-text">{detailData.mailContent}</Paragraph>
      </div>
    </div>
  );

  return showDetail ? detailContent : listContent;
};

export default MailList;