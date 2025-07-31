# Bank_Management_System 💳
Java-based Bank Management System with WhatsApp/Gmail Notification Integration.

This is a **Java-based Bank Management System** integrated with a **MySQL database**. It features a user-friendly **Swing GUI** and includes **real-time WhatsApp/SMS notifications** powered by the **Twilio API**.

The system includes a 3-page user signup and core banking functionalities such as deposit, withdrawal, fast cash, balance enquiry, mini statement, and PIN change.

---

## ✅ Key Features

### 👤 User Signup (3-Step Process)
Each signup stage collects detailed user information.

- `Signup.java` – Personal Details  
- `SignupTwo.java` – Additional Info  
- `SignupThree.java` – Account Setup

### 💰 Transaction Functionalities

- `Deposit.java` – Add funds  
- `Withdrawl.java` – Withdraw money  
- `FastCash.java` – Quick preset withdrawals  
- `BalanceEnquiry.java` – Check current balance  
- `MiniStatement.java` – View recent transactions  
- `PinChange.java` – Change your ATM PIN

### 🔔 Real-Time Notifications

- WhatsApp/SMS notifications using **Twilio API**
- Triggered on:
  - Deposit
  - Withdrawal
  - Balance Enquiry

---

## 💾 MySQL Database

The following tables are used to store user and transaction information:

- `signup`
- `signuptwo`
- `signupthree`
- `login`
- `bank`

📁 The SQL schema is available in the `/database` folder as `bank_system.sql`.  
It contains all the `CREATE TABLE` statements to set up your local MySQL environment.

---

## 📷 Screenshots & Demo

Images of the GUI screens and database table setup are available in the `/screenshots` folder. These include:

- Signup pages (1–3)
- Login screen
- Dashboard
- All transaction interfaces
- WhatsApp Notification demo

---

## 🚀 Getting Started

### Prerequisites

- Java (JDK 8 or higher)
- MySQL Server
- Eclipse or IntelliJ
- Twilio account for API key
- Internet connection for message sending

### Setup Steps

1. Clone this repository
2. Import the project into Eclipse
3. Configure the MySQL credentials in your `Connection.java`
4. Run the SQL script from `/database/bank_system.sql`
5. Register a user and begin transactions!

---

## 📬 Contact

For queries or improvements, feel free to raise an issue or contribute.

---

### 🔐 Disclaimer

This project is for **educational/demo purposes**. Do not use it in production without proper security, validation, and optimization.


🔹 Step 1 – Personal Details (Signup.java)

<img width="1366" height="768" alt="Screenshot (10)" src="https://github.com/user-attachments/assets/2204b24d-2935-4322-95f9-b5186bad22d5" />

Collects: Name, Father's Name, DOB, Gender, Email, Marital Status, Address, City, Pincode, State.

Data stored in: signup table

🔹 Step 2 – Additional Details (SignupTwo.java)

<img width="1366" height="768" alt="Screenshot (11)" src="https://github.com/user-attachments/assets/20a38361-3a38-4341-98c0-af4149372414" />

Collects: Religion, Category, Income, Education, Occupation, PAN, Aadhar, Senior Citizen status, Existing Account.

Data stored in: signuptwo table

🔹 Step 3 – Account Details (SignupThree.java)

<img width="1366" height="768" alt="Screenshot (12)" src="https://github.com/user-attachments/assets/30792a54-5108-463f-9e33-5d19dad7e97e" />

Selects: Account Type, Card Number (auto-generated), PIN, Services Required.

Data stored in: signupthree + login tables

🔹 4. Login Screen

<img width="1366" height="768" alt="Screenshot (2)" src="https://github.com/user-attachments/assets/844f1529-a6b6-4cd3-b8a9-44b654dab618" />

The Login Screen acts as the secure entry point to the Bank Management System.
Users are required to input their Card Number and PIN to authenticate and access banking services.

Card No: Input field to enter the unique 16-digit card number.

PIN: Password-protected field for secure PIN entry.

Buttons:

SIGN IN: Verifies credentials and redirects to the transaction dashboard.

CLEAR: Clears the entered credentials.

SIGN UP: Redirects to the registration form for new users.

🔒 Security Tip: This system checks the card number and PIN combination against the login table in MySQL.

🔹 5. Main Menu / Transaction Dashboard

Once the user logs in, they are taken to the Main Menu, which simulates an ATM interface. This dashboard allows the user to perform various banking transactions with ease.

<img width="1366" height="768" alt="Screenshot (3)" src="https://github.com/user-attachments/assets/1c3030cf-dcc9-4018-8da6-b0bdeedc5a2f" />

Available Options:

🔼 DEPOSIT: Opens the deposit interface where users can enter and deposit a specific amount.

🔼 CASH WITHDRAWAL: Enables the withdrawal of a specific amount from the account.

🔼 FAST CASH: Quick withdrawal of predefined amounts (e.g., ₹100, ₹500, ₹1000, etc.).

🔼 MINI STATEMENT: Displays the last few transactions made by the user.

🔼 BALANCE ENQUIRY: Shows the current balance in the user’s bank account.

🔼 PIN CHANGE: Lets the user update or change their existing PIN.

🔼 EXIT: Logs the user out and returns to the login screen.

🛠️ Class Behind: This menu is handled by the Transactions class which listens for button clicks and redirects to respective operations.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


✅ 1. Login Screen

(<img width="1366" height="768" alt="Screenshot (2)" src="https://github.com/user-attachments/assets/20fda932-6f98-4cea-b75c-2ed56783a25c" />

This is the initial screen prompting the user to enter a PIN.

UI provides a numeric keypad for PIN input.

Typical of secure authentication before accessing ATM services.

✅ 2. Transaction Selection Screen

<img width="1366" height="768" alt="Screenshot (3)" src="https://github.com/user-attachments/assets/f83217b7-88ee-4d30-bba3-d581dc015fd0" />

After a successful login, the user is presented with multiple transaction options:

Deposit, Cash Withdrawal, Fast Card, Mini Statement, PIN Change, Balance Enquiry, Exit.

Buttons are aligned on both sides, mimicking a real ATM layout.

✅ 3. Deposit – Amount Entry

<img width="1366" height="768" alt="Screenshot (4)" src="https://github.com/user-attachments/assets/16afc62a-db52-4c37-a3ca-c7bffebd791c" />
<img width="1366" height="768" alt="Screenshot (5)" src="https://github.com/user-attachments/assets/f8551114-5e9e-4011-b630-36ac87d0528d" />

Prompts the user to enter the amount they want to deposit.

Includes two action buttons: Deposit and Back.

✅ 4. Deposit – Success Message

![integration whatsapp](https://github.com/user-attachments/assets/9a325e01-53d7-4cb9-8373-9bd8a33c2c8f)
![integration sms](https://github.com/user-attachments/assets/171993b6-5d4e-42f8-8580-56754d9337c1)

After entering ₹1000 and clicking Deposit, a confirmation dialog appears:

“Rs. 1000 Deposited Successfully”.

An OK button is present for user acknowledgment.

✅ 5. Cash Withdrawal – Amount Entry

(<img width="1366" height="768" alt="Screenshot (6)" src="https://github.com/user-attachments/assets/ad8161cd-fa1f-49ab-8397-8a6f383bfbc2" />

Prompts the user to enter the withdrawal amount.

Displays maximum limit: “MAXIMUM WITHDRAWAL IS RS.10,000”.

Contains Withdraw and Back buttons.

✅ 6. 💸 Fast Cash

<img width="1366" height="768" alt="Screenshot (7)" src="https://github.com/user-attachments/assets/6a9b0197-c47c-46b3-9e22-077378efe79a" />

The FastCash.java class allows users to quickly withdraw fixed amounts like ₹100, ₹500, ₹1000, etc., with one click. It checks balance availability and sends a WhatsApp alert on successful withdrawal using the Twilio API.

✅ 7. 🔐 PIN Change
Handled by: PinChange.java

<img width="1366" height="768" alt="Screenshot (8)" src="https://github.com/user-attachments/assets/ddebc390-9192-49a2-938d-9c6f69c3094f" />


🔼 Allows users to securely update their 4-digit ATM PIN.

🔼 Requires entering the old PIN and confirming the new one.

🔼 Validates if new PIN meets format and confirmation matches.

🔼 Updates the new PIN in the MySQL database upon verification.

🔼 Displays a success message and sends a confirmation via WhatsApp (if enabled).

✅ 8. 🧾 Mini Statement
Handled by: MiniStatement.java

<img width="1366" height="768" alt="Screenshot (9)" src="https://github.com/user-attachments/assets/b28aaf14-823f-4163-ba55-9ec4545d2970" />

🔼 Shows the last 5 transactions (Deposit/Withdrawal) of the user.

🔼 Fetches transaction history from the MySQL bank table.

🔼 Displays date, type, and amount of each transaction.

🔼 Helps users quickly verify recent account activity.

🔼 Optionally integrates with WhatsApp to send mini statement on demand.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

📌 Conclusion
This Bank Management System project demonstrates a real-time simulation of banking operations such as deposits, withdrawals, balance inquiries, mini statements, and more. The integration of WhatsApp notifications using Twilio API adds a modern touch for user interaction and alerting.

🛠️ Technologies Used
Java

MySQL

Swing/AWT for GUI

Twilio API (for WhatsApp/SMS alerts)

JDBC for database connectivity
