package com.scu.group8.mailServer.pojo;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.user_email_address
     *
     * @mbggenerated
     */
    private String userEmailAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.user_password
     *
     * @mbggenerated
     */
    private String userPassword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.user_id
     *
     * @return the value of mail_server..user.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.user_id
     *
     * @param userId the value for mail_server..user.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.user_email_address
     *
     * @return the value of mail_server..user.user_email_address
     *
     * @mbggenerated
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.user_email_address
     *
     * @param userEmailAddress the value for mail_server..user.user_email_address
     *
     * @mbggenerated
     */
    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress == null ? null : userEmailAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.user_password
     *
     * @return the value of mail_server..user.user_password
     *
     * @mbggenerated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.user_password
     *
     * @param userPassword the value for mail_server..user.user_password
     *
     * @mbggenerated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}