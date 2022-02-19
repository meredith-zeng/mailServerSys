package com.scu.group8.mailServer.pojo;

public class ReceivedMail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column received_mail.mail_id
     *
     * @mbggenerated
     */
    private Integer mailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column received_mail.owner_id
     *
     * @mbggenerated
     */
    private Integer ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column received_mail.sent_user_id
     *
     * @mbggenerated
     */
    private Integer sentUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column received_mail.read_status
     *
     * @mbggenerated
     */
    private Integer readStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column received_mail.mail_id
     *
     * @return the value of received_mail.mail_id
     *
     * @mbggenerated
     */
    public Integer getMailId() {
        return mailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column received_mail.mail_id
     *
     * @param mailId the value for received_mail.mail_id
     *
     * @mbggenerated
     */
    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column received_mail.owner_id
     *
     * @return the value of received_mail.owner_id
     *
     * @mbggenerated
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column received_mail.owner_id
     *
     * @param ownerId the value for received_mail.owner_id
     *
     * @mbggenerated
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column received_mail.sent_user_id
     *
     * @return the value of received_mail.sent_user_id
     *
     * @mbggenerated
     */
    public Integer getSentUserId() {
        return sentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column received_mail.sent_user_id
     *
     * @param sentUserId the value for received_mail.sent_user_id
     *
     * @mbggenerated
     */
    public void setSentUserId(Integer sentUserId) {
        this.sentUserId = sentUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column received_mail.read_status
     *
     * @return the value of received_mail.read_status
     *
     * @mbggenerated
     */
    public Integer getReadStatus() {
        return readStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column received_mail.read_status
     *
     * @param readStatus the value for received_mail.read_status
     *
     * @mbggenerated
     */
    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
}