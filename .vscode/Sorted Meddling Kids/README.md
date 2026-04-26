# 🔎 CASE FILE: Sorted Meddling Kids

Welcome to the **Coolsville High Registrar**. This project was created to track and organize the students of Coolsville High—especially those pesky meddling kids who keep solving mysteries around town.

## 📝 The Mystery Overview
This Java application manages a registry of 10 students. To keep things orderly at the school office, we’ve implemented a custom **Ghostly Selection Sort** that can reorganize the student list by their names or their official roll numbers.

### 🛠 The Tech Specs
* **Language:** Java
* **Data Structure:** `ArrayList<MeddlingKid>`
* **Algorithm:** Custom Selection Sort (No `Collections.sort` allowed!)
* **Sorting Rules:** Two custom `Comparator` classes for multi-criteria sorting.

---

## 📁 The Clue Files
To keep the mystery organized, the project is broken down into separate Java source files:

1. **`MeddlingKid.java`**: The "Suspect Profile." Stores the `rollno`, `name`, and `address`.
2. **`ClueComparators.java`**: The "Detective Rules." Contains the logic for comparing students.
3. **`CoolsvilleRegistrar.java`**: The "Office Central." Handles the main menu and the sorting algorithm.

---

## 🚀 Cracking the Case (How to Run)

1. **Gather the Clues:** Make sure all three `.java` files are in the same folder.
2. **Compile the Evidence:** Open your terminal and run:
    ```bash
    javac CoolsvilleRegistrar.java
    ```
3. **Solve the Mystery:** Run the program with:
    ```bash
    java CoolsvilleRegistrar
    ```

---


> "I would have gotten away with an unsorted list, too, if it weren't for you meddling kids and your blasted dogs!"