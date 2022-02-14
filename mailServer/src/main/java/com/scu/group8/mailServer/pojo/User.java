package com.scu.group8.mailServer.pojo;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.User_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.User_email_address
     *
     * @mbggenerated
     */
    private String userEmailAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.User_passowrd
     *
     * @mbggenerated
     */
    private String userPassowrd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.User_gender
     *
     * @mbggenerated
     */
    private String userGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_server..user.User_phone_number
     *
     * @mbggenerated
     */
    private String userPhoneNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.User_id
     *
     * @return the value of mail_server..user.User_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.User_id
     *
     * @param userId the value for mail_server..user.User_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.User_email_address
     *
     * @return the value of mail_server..user.User_email_address
     *
     * @mbggenerated
     */
    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.User_email_address
     *
     * @param userEmailAddress the value for mail_server..user.User_email_address
     *
     * @mbggenerated
     */
    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress == null ? null : userEmailAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.User_passowrd
     *
     * @return the value of mail_server..user.User_passowrd
     *
     * @mbggenerated
     */
    public String getUserPassowrd() {
        return userPassowrd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.User_passowrd
     *
     * @param userPassowrd the value for mail_server..user.User_passowrd
     *
     * @mbggenerated
     */
    public void setUserPassowrd(String userPassowrd) {
        this.userPassowrd = userPassowrd == null ? null : userPassowrd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.User_gender
     *
     * @return the value of mail_server..user.User_gender
     *
     * @mbggenerated
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.User_gender
     *
     * @param userGender the value for mail_server..user.User_gender
     *
     * @mbggenerated
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_server..user.User_phone_number
     *
     * @return the value of mail_server..user.User_phone_number
     *
     * @mbggenerated
     */
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_server..user.User_phone_number
     *
     * @param userPhoneNumber the value for mail_server..user.User_phone_number
     *
     * @mbggenerated
     */
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber == null ? null : userPhoneNumber.trim();
    }
}