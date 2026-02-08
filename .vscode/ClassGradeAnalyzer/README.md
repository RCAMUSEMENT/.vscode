# 📊 Grade Statistics Calculator
**Developed by Ryley**

This is a extremely robust Java console application that will calculate all of the essential classroom statistics, maps numeric scores to specific letter grades, and generates a visual distribution bar chart.

## 🚀 Features
*   **Safe Input:** Includes validation to prevent endless loops and handle invalid non-numeric data.
*   **Smart Sorting:** Automatically sorts grades from highest to lowest for clear reporting.
*   **Custom Grading Scale:** Maps scores to a precise scale (A through F, including +/-).
*   **Visual Distribution:** Generates a text-based histogram (bar chart) using asterisks.
*   **Advanced Stats:** Calculates Average, Maximum, Minimum, and Population Standard Deviation.

## 🛠️ How to Run
1.  Please make sure you have **Java (JDK 8 or higher)** installed.
2.  Save the code as `GradeStatistics.java`.
3.  Open your terminal or command prompt and navigate to the file location.
4.  Compile the program:
    ```bash
    javac GradeStatistics.java
    ```
5.  Run the program:
    ```bash
    java GradeStatistics
    ```

## 📈 Grading Scale Used (This is the same scale as CSU Global's)
| Grade | Range |
| :--- | :--- |
| **A** | 95.0% - 100% |
| **A-** | 90.0% - <95.0% |
| **B+** | 86.7% - <90.0% |
| **B** | 83.3% - <86.7% |
| **B-** | 80.0% - <83.3% |
| **C+** | 75.0% - <80.0% |
| **C** | 70.0% - <75.0% |
| **D** | 60.0% - <70.0% |
| **F** | <60.0% |

## 🖥️ Sample Output

--- Welcome to Ryley's Grade Statistics Calculator ---
Please enter ten floating-point grades ranging from (0-100) for each student:
Enter grade #1: 98.5
Enter grade #2: abc
! This is an invalid input. Please enter a number ranging from 0 to 100.
Enter grade #2: 105
! The grade is out of range. Please enter 0-100.
Enter grade #2: 92
Enter grade #3: 88.4
Enter grade #4: 84
Enter grade #5: 81.2
Enter grade #6: 77
Enter grade #7: 72.5
Enter grade #8: 65
Enter grade #9: 55
Enter grade #10: 90

--- Individual Grade Report (Sorted) ---
98.50% [A]
92.00% [A-]
90.00% [A-]
88.40% [B+]
84.00% [B]
81.20% [B-]
77.00% [C+]
72.50% [C]
65.00% [D]
55.00% [F]

--- Final Class Grade Statistics ---
The Average grade for the class is: 80.36% (B-)
The Maximum grade for the class is: 98.50% (A)
The Minimum grade for the class is: 55.00% (F)
The Standard deviation for the class is: 12.84

--- Grade Distribution (Bar Chart) ---
A   [1]: *
A-  [2]: **
B+  [1]: *
B   [1]: *
B-  [1]: *
C+  [1]: *
C   [1]: *
D   [1]: *
F   [1]: *
----------------------------

*Created as part of a Java Programming project for CSC320 Programming 1*
