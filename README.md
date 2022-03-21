# mailServerSys
## Overview
COEN 275: Jihao Chen, Jinming Nian, Yulin Zeng

### Problem Definition
Create a mail server that receives incoming email from users and senders and forwards outgoing messages for delivery. Implement an UI for users to login into the application. 

### Requirement Analysis
- Login/SignUp
  - Users sign up and login with email address and password: we can store these strings in database for authentication. 
- Draft & Send email
  - Draft email is saved in user’s draft box. 
  - Draft email can be edited anytime, and the updates will be saved.
  - User can send a draft email at anytime. 
  - Sent email is saved in user’s outbox. 
  - Sending email to an existing user will make the mail visible for both the sender and the receiver.
- Check all the received emails
  - Every user has an “Inbox” where they can see all the mails sent to them. 
  - When a single page can’t fit all the mails in, user can flip through different pages to view their mail list.
- Read an email: User can click on a mail either in their inbox, outbox, or draft box to see details about the mail:
    - Sender 
    - Title
    - Content 
    - Time sent/edited
 
### Assumption
- User don’t have to register with a certain domain. E.g. xxx@xxmail.com
- User only send email to existing users.
- User can send email to themselves. The email would then be visible in their inbox and outbox.
- Forwarding is not supported at this time, but could be easily implemented 
- Users only send email to one person at a time.

## Use cases
### Use cases anlysis
- The only actor in our system: Email User
  - Intuitively, the person who uses our mail server to draft, send, receive, and read emails.
- Use cases for Mail Server
  - Sign Up: Create user profile in backend database so that the user can login later on.
  - Login: Use email address and password to gain access to the user’s mailbox.
  - Check emails: User can see a list of inbox mails once logged.
  - Read emails: In inbox, outbox, or draft box, user can click on any mail to read its content. 
  - Draft emails: User can start writing an email and not send it. The progress is saved. 
  - Send emails: User can send emails or saved drafts to any users. 
  - Delete emails: User can delete any email in any of their boxes.

### Use Case Diagram


