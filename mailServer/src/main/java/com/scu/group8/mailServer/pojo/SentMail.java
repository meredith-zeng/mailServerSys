package com.scu.group8.mailServer.pojo;

public class SentMail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sent_mail.mail_id
     *
     * @mbggenerated
     */
    private Integer mailId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sent_mail.owner_id
     *
     * @mbggenerated
     */
    private Integer ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sent_mail.received_user_id
     *
     * @mbggenerated
     */
    private Integer receivedUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sent_mail.sent_status
     *
     * @mbggenerated
     */
    private Integer sentStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sent_mail.mail_id
     *
     * @return the value of sent_mail.mail_id
     *
     * @mbggenerated
     */
    public Integer getMailId() {
        return mailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sent_mail.mail_id
     *
     * @param mailId the value for sent_mail.mail_id
     *
     * @mbggenerated
     */
    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sent_mail.owner_id
     *
     * @return the value of sent_mail.owner_id
     *
     * @mbggenerated
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sent_mail.owner_id
     *
     * @param ownerId the value for sent_mail.owner_id
     *
     * @mbggenerated
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sent_mail.received_user_id
     *
     * @return the value of sent_mail.received_user_id
     *
     * @mbggenerated
     */
    public Integer getReceivedUserId() {
        return receivedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sent_mail.received_user_id
     *
     * @param receivedUserId the value for sent_mail.received_user_id
     *
     * @mbggenerated
     */
    public void setReceivedUserId(Integer receivedUserId) {
        this.receivedUserId = receivedUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sent_mail.sent_status
     *
     * @return the value of sent_mail.sent_status
     *
     * @mbggenerated
     */
    public Integer getSentStatus() {
        return sentStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sent_mail.sent_status
     *
     * @param sentStatus the value for sent_mail.sent_status
     *
     * @mbggenerated
     */
    public void setSentStatus(Integer sentStatus) {
        this.sentStatus = sentStatus;
    }
}