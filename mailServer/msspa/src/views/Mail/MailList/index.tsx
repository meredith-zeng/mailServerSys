import './index.scss';
import dayjs from 'dayjs';
import React, { FC, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Pagination, Typography } from 'antd';
import { ArrowLeftOutlined } from '@ant-design/icons';

import { getMailList, readMail } from '../../../data/api';

const { Text, Title, Paragraph } = Typography;

const PAGE_SIZE = 20;

interface Props {
  openCompose: any,
}

const MailList: FC<Props> = ({openCompose}) => {
  const { category } = useParams();
  let [page, setPage] = useState(1);
  let [listData, setListData] = useState<any>({});
  let [detailData, setDetailData] = useState<any>({});
  let [showDetail, setShowDetail] = useState<any>(false);

  const changePage = (val: number) => {
    setPage(val);
  }

  useEffect(() => {
    getMailList({
      category,
      page: page-1,
      size: PAGE_SIZE
    }).then(({data}) => {
      setListData(data);
    })
    setShowDetail(false);
  }, [page, category])

  const onSelectItem = (item: any) => {
    if(category === "2") {
      readMail({mailId: item.id});
    }

    if(category !== "0") {
      setDetailData(item);
      setShowDetail(true);
    } else {
      openCompose(item);
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
        const { sender, recipient, title, content } = item;

        return (
          <div key={item.id} className="mail-list-item" onClick={() => {onSelectItem(item)}}>
            <Text className="mail-people" ellipsis>{category === "2" ? sender : recipient}</Text>
            <Text className="mail-info" ellipsis>
              <Text className="mail-title">{title}</Text>
              <Text className="mail-content"> - {content}</Text>
            </Text>
          </div>
        );
      })}
      </div>
    </div>
  );

  const returnToList = (item: any) => {
    setShowDetail(false);
  }

  const detailContent = (
    <div className="mail-list-container">
      <div className="mail-opt">
        <ArrowLeftOutlined className="opt-back" onClick={returnToList}/>
      </div>
      <div className="mail-content mail-detail">
        <Title className="mail-title" level={2}>{detailData.title}</Title>
        <div className="mail-people">
          <div className="name-box">
            <div className="mail-sender">{detailData.sender}</div>
            <div className="mail-recipient">to {detailData.recipient}</div>
          </div>
          <div className="send-time">{dayjs(detailData.sendingTime).format('MMM DD, YYYY, h:mm A')}</div>
        </div>
        <Paragraph className="mail-text">{detailData.content}</Paragraph>
      </div>
    </div>
  );

  return showDetail ? detailContent : listContent;
};

export default MailList;