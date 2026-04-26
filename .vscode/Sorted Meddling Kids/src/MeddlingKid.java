/**
 * Ryley's Sorted Meddling Kids
 * Student Name: Ryley Carlson
 * CSC372 Module 6 Critical Thinking Assignment
 * Date: 2026-04-26
 * Program: Sorted Meddling Kids.java
 * Description: A Java program that manages a list of "Meddling Kids" (characters from the Scooby-Doo franchise)
 * and allows the user to sort them by name or roll number using custom comparators and a selection sort algorithm.
 */

public class MeddlingKid {
    @SuppressWarnings("FieldMayBeFinal")
    private int rollno;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String address;

    public MeddlingKid(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() { return rollno; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("| %-5d | %-12s | %-20s |", rollno, name, address);
    }
}