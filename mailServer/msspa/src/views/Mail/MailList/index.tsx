import './index.scss';
import dayjs from 'dayjs';
import utc from 'dayjs/plugin/utc';
import isToday from 'dayjs/plugin/isToday';
import React, { FC, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Pagination, Typography, message } from 'antd';
import { ArrowLeftOutlined, DeleteOutlined } from '@ant-design/icons';

import { deleteMail, getMailList, readMail } from '../../../data/api';

const { Text, Title, Paragraph } = Typography;

const PAGE_SIZE = 20;

dayjs.extend(utc);
dayjs.extend(isToday)

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
    if(!showDetail && !showCompose) {
      getData();
    }
  }, [page, category, showDetail, showCompose])

  const getData = () => {
    getMailList({
      category,
      page: page,
      size: PAGE_SIZE
    }).then(({data}) => {
      setListData(data);
    })
  }

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

  const onDelete = async (mailId: number, e:any) => {
    e.stopPropagation();
    const { error } = await deleteMail({
      mailId,
      category
    })

    if(!error) {
      message.success('Deleted successfully!');
      if(showDetail) {
        setShowDetail(false);
      } else {
        getData();
      }
    }
  }

  const listContent = (
    <div className="mail-list-container">
      {listData.total > 0 ? <div className="list-pagination">
        <Pagination 
          simple 
          current={page} 
          onChange={changePage} 
          pageSize={PAGE_SIZE} 
          total={listData.total} 
        />
      </div> : null}
      <div className="mail-content">
      {listData.list && listData.list.map((item:any) => {
        let isRead = category === '2' && item.readStatus === 1;
        let time = dayjs(item.sendingTime).utcOffset(0);
        let timeStr;
        if(time.isToday()) {
          timeStr = time.format('h:mm A');
        } else {
          timeStr = time.format('MMM D');
        }

        return (
          <div key={item.mailId} className={`mail-list-item ${isRead ? 'item-read' : ''}`} onClick={() => {onSelectItem(item)}}>
            <Text className="mail-people" ellipsis>{category === "2" ? item.senderEmailAddress : "To: "+item.recipientEmailAddress}</Text>
            <Text className="mail-info" ellipsis>
              <Text className="mail-title">{item.mailTitle}</Text>
              <Text className="mail-content"> - {item.mailContent}</Text>
            </Text>
            <div className="mail-time">
              <Text className="time-text">{timeStr}</Text>
              <DeleteOutlined className="opt-del" onClick={(e) => onDelete(item.mailId, e)} />
            </div>
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
        <DeleteOutlined className="opt-del" onClick={(e) => onDelete(detailData.mailId, e)} />
      </div>
      <div className="mail-content mail-detail">
        <Title className="mail-title" level={2}>{detailData.mailTitle}</Title>
        <div className="mail-people">
          <div className="name-box">
            <div className="mail-sender">{detailData.senderEmailAddress}</div>
            <div className="mail-recipient">to {detailData.recipientEmailAddress}</div>
          </div>
          <div className="send-time">{dayjs(detailData.sendingTime).utcOffset(0).format('MMM D, YYYY, h:mm A')}</div>
        </div>
        <Paragraph className="mail-text">{detailData.mailContent}</Paragraph>
      </div>
    </div>
  );

  return showDetail ? detailContent : listContent;
};

export default MailList;