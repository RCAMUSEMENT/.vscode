# 🏦 Banking System - CSC372 Module 1 💰

Welcome to the **Bank Account Management System**! This project was developed as part of the **CSC372 Module 1 Critical Thinking Assignment**. It demonstrates the power of **Object-Oriented Programming (OOP)** in Java.

---

## 👤 Student Information
*   **Name:** Ryley Carlson
*   **Assignment:** CSC372 Module 1 Critical Thinking
*   **Date:** 2026-03-20

---

## 🛠️ Project Structure

1.  **`BankAccount.java` (The Superclass) 🏗️**
    *   Defines the core blueprint for a bank account (Part 1).
    *   Handles names, ID, and balance logic.

2.  **`CheckingAccount.java` (The Subclass) 💳**
    *   Inherits from BankAccount (Part 2).
    *   **Overdraft Protection:** Automatically applies a **$30.00 fee** if balance is negative.
    *   Handles interest rate attributes and processing.

3.  **`BankAccountTest.java` (The Driver) 🏁**
    *   The entry point featuring an interactive menu.
    *   Includes **Input Verifiers** to ensure valid data entry.

---

## ✨ Features
*   ✅ **Encapsulation:** Private attributes with controlled access.
*   ✅ **Inheritance:** CheckingAccount extends BankAccount.
*   ✅ **Validation:** Input verifiers prevent program crashes.
*   ✅ **Interaction:** Menu-driven interface with "continue" prompts.

---

## 🚀 How to Run

1.  Compile all files: `javac *.java`
2.  Run the test class: `java BankAccountTest`

---
**Made by Ryley Carlson**

