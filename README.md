# Bank_Mangement_System_JAVA_3rd_Semester_Final_Project

## Bank Management System
A comprehensive desktop banking application developed using Java Swing and MySQL. This system simulates the core functionalities of a real-world banking environment, managing the user lifecycle from account creation (signup) to daily financial transactions.

## About the Project
The Bank Management System is designed to automate manual banking tasks. It focuses on data integrity, utilizing Database Normalization (up to 3NF) to ensure efficient storage. The application follows the MVC (Model-View-Controller) architectural pattern principles, separating the GUI logic from database operations.

## Key Features
### User Onboarding (Signup Flow)
A multi-stage application process to ensure detailed data capture:
Page 1 (Personal Details): Captures Name, DOB, Address, Email.
Page 2 (Demographics): Captures Income, Education, Pan/Aadhar, Religion.
Page 3 (Account Details): Generates Card Number & PIN, selects Account Type (Savings/Current).

### Core Banking Operations
Secure Login: Authentication using Card Number and PIN.
Deposit & Withdrawal: Real-time balance updates.
Fast Cash: Quick withdrawal options (similar to ATM interfaces).
Mini Statement: Fetches the last 5 transactions.
Pin Change: User-initiated security updates.
Balance Enquiry: Instant view of current funds.

## System Design & Database
The database is robustly designed based on an Extended Entity-Relationship Diagram (EERD).
Normalization: The schema adheres to 1NF and 2NF, with project-specific decisions made for 3NF (e.g., keeping City/State in the signup table for simplicity).

### Relationships:
Uses Primary Keys and Foreign Keys with ON DELETE CASCADE to maintain referential integrity.
1:1 Relationship between Customer and Account Info.
1:M Relationship between Account and Transactions.

## Schema Overview:
signup: Stores personal user data.
signuptwo: Stores additional demographic info.
signupthree: Stores account specific details.
login: manages access credentials.
bank: Logs all transaction history.
