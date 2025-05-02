# ATM System GUI

A Java-based ATM (Automated Teller Machine) simulation system with graphical user interface built using Java Swing. This application simulates the functionality of a real ATM machine, including user authentication, balance inquiries, cash withdrawals, and fund transfers.

## Features

- **User Authentication**: Secure login with account number and PIN
- **Account Types**: Support for Savings and Cheque accounts
- **Balance Inquiry**: View available and total balance
- **Cash Withdrawal**: Withdraw cash in predefined amounts or custom amounts
- **Fund Transfer**: Transfer funds between accounts
- **Hardware Simulation**: Simulates ATM hardware components like card reader, cash dispenser, and receipt printer

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE (Eclipse recommended)

### Installation

1. Clone the repository or download the source code
2. Open the project in your Java IDE
3. Build the project to compile all Java files

### Running the Application

Run the `ATMCaseStudy.java` file which contains the main method to start the application.

## Usage

1. **Login**:
   - Use one of the predefined account numbers (12345, 98765, or 56789)
   - Enter the corresponding PIN (54321 for account 12345, 56789 for account 98765, 11111 for account 56789)

2. **Main Menu**:
   - Select from Balance Inquiry, Withdrawal, or Transfer

3. **Withdrawal**:
   - Select from predefined amounts or enter a custom amount
   - Note: All withdrawals must be in multiples of $100

4. **Transfer**:
   - Enter the amount to transfer
   - Enter the destination account number
   - Confirm the transaction

5. **Balance Inquiry**:
   - View your available balance and total balance

## Project Structure

- **Account.java**: Base class for bank accounts
- **SavingAccount.java** & **ChequeAccount.java**: Different account types
- **Transaction.java**: Abstract class for ATM transactions
- **BalanceInquiry.java**, **Withdrawal.java**, **Transfer.java**: Transaction subclasses
- **ATM.java**: Main ATM controller class
- **BankDatabase.java**: Simulates a bank database
- **CashDispenser.java**: Simulates the cash dispenser
- **Keypad.java**: Simulates the ATM keypad
- **Screen.java**: Manages the ATM display
- **GUI classes**: Handle the graphical user interface for different transactions

## Test Accounts

| Account Number | PIN   | Type    | Available Balance | Total Balance |
|---------------|-------|---------|-------------------|---------------|
| 12345         | 54321 | Saving  | $1,000.00         | $1,200.00     |
| 98765         | 56789 | Saving  | $200.00           | $200.00       |
| 56789         | 11111 | Saving  | $50,000.00        | $60,000.00    |
| 55555         | 32165 | Cheque  | $300.00           | $300.00       |
| 99999         | 00000 | Cheque  | $1,000.00         | $1,600.00     |
| 77777         | 95123 | Cheque  | $70,000.00        | $90,000.00    |