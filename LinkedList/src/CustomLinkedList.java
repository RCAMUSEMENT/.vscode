/*
* Student Name: Ryley Carlson
* CSC400 Critical Thinking Assignment: RYLEY'S GALACTIC BOUNTY REGISTRY
* Date: 2026-06-07
* Program: CustomLinkedList.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList implements Iterable<Integer> {
    private Node head;
    private Node tail;
    private int size;
    private int modificationCount;

    public void insert(int data) {
        addLast(data);
    }

    public boolean delete(int data) {
        Node node = findNode(data);
        if (node == null) return false;
        unlink(node);
        return true;
    }

    public void addFirst(int data) {
        linkFirst(data);
    }

    public void addLast(int data) {
        linkLast(data);
    }

    public void add(int index, int data) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(data);
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node nextNode = nodeAt(index);
        Node previousNode = nextNode.previous;
        Node newNode = new Node(data, previousNode, nextNode);
        previousNode.next = newNode;
        nextNode.previous = newNode;
        size++;
        modificationCount++;
    }

    public int removeFirst() {
        if (head == null) throw new NoSuchElementException("Cannot remove from an empty list.");
        return unlink(head);
    }

    public int removeLast() {
        if (tail == null) throw new NoSuchElementException("Cannot remove from an empty list.");
        return unlink(tail);
    }

    public int getFirst() {
        if (head == null) throw new NoSuchElementException("The list is empty.");
        return head.data;
    }

    public int getLast() {
        if (tail == null) throw new NoSuchElementException("The list is empty.");
        return tail.data;
    }

    public int get(int index) {
        checkElementIndex(index);
        return nodeAt(index).data;
    }

    public int set(int index, int data) {
        checkElementIndex(index);
        Node node = nodeAt(index);
        int oldData = node.data;
        node.data = data;
        return oldData;
    }

    public int indexOf(int data) {
        Node current = head;
        for (int index = 0; current != null; index++) {
            if (current.data == data) return index;
            current = current.next;
        }
        return -1;
    }

    public void reverse() {
        if (size <= 1) return;
        Node forward = head;
        Node backward = tail;
        for (int i = 0; i < size / 2; i++) {
            int temp = forward.data;
            forward.data = backward.data;
            backward.data = temp;
            forward = forward.next;
            backward = backward.previous;
        }
        modificationCount++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            builder.append(current.data);
            current = current.next;
            if (current != null) builder.append(" <-> ");
        }
        return builder.append("]").toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    public Iterable<Integer> descending() {
        return () -> new ReverseIterator();
    }

    private void linkFirst(int data) {
        Node oldHead = head;
        Node newNode = new Node(data, null, oldHead);
        head = newNode;
        if (oldHead == null) tail = newNode;
        else oldHead.previous = newNode;
        size++;
        modificationCount++;
    }

    private void linkLast(int data) {
        Node oldTail = tail;
        Node newNode = new Node(data, oldTail, null);
        tail = newNode;
        if (oldTail == null) head = newNode;
        else oldTail.next = newNode;
        size++;
        modificationCount++;
    }

    private int unlink(Node node) {
        int removedValue = node.data;
        Node previousNode = node.previous;
        Node nextNode = node.next;
        if (previousNode == null) head = nextNode;
        else previousNode.next = nextNode;
        if (nextNode == null) tail = previousNode;
        else nextNode.previous = previousNode;

        // >>> ENHANCEMENT: Explicit clean up of references to completely safeguard against memory leaks
        node.data = 0;
        node.previous = null;
        node.next = null;

        size--;
        modificationCount++;
        return removedValue;
    }

    private Node nodeAt(int index) {
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current;
        }
        Node current = tail;
        for (int i = size - 1; i > index; i--) current = current.previous;
        return current;
    }

    private Node findNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return current;
            current = current.next;
        }
        return null;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
    }

    private static final class Node {
        private int data;
        private Node previous;
        private Node next;

        private Node(int data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private final class LinkedListIterator implements Iterator<Integer> {
        private final int expectedModificationCount = modificationCount;
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (expectedModificationCount != modificationCount) throw new ConcurrentModificationException();
            if (current == null) throw new NoSuchElementException();
            int data = current.data;
            current = current.next;
            return data;
        }
    }

    private final class ReverseIterator implements Iterator<Integer> {
        private final int expectedModificationCount = modificationCount;
        private Node current = tail;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (expectedModificationCount != modificationCount) throw new ConcurrentModificationException();
            if (current == null) throw new NoSuchElementException();
            int data = current.data;
            current = current.previous;
            return data;
        }
    }
}

@SuppressWarnings("unused")
final class Main {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        CustomLinkedList targets = new CustomLinkedList();
        loadAsciiArtBanner("banner.txt");
        loadNumbers(targets, "data.txt");
        printSection("INITIAL TARGET MANIFEST");
        printList(targets);
        System.out.println("\n[ACTION] Inserting priority target #777 at the front.");
        targets.addFirst(777);
        printList(targets);
        int insertIndex = Math.min(2, targets.size());
        System.out.println("\n[ACTION] Inserting target #404 at index " + insertIndex + ".");
        targets.add(insertIndex, 404);
        printList(targets);
        System.out.println("\n[ACTION] Replacing index 1 with upgraded target #888.");
        int replaced = targets.set(1, 888);
        System.out.println("Replaced target: " + CYAN + replaced + RESET);
        printList(targets);
        System.out.println("\n[ACTION] Searching and removing target #501.");
        System.out.println("Target #501 first index: " + targets.indexOf(501));
        boolean removed = targets.delete(501);
        System.out.println(removed ? GREEN + "[SUCCESS] Target removed." + RESET : RED + "[NOTICE] Target was not found." + RESET);
        printList(targets);
        System.out.println("\n[ACTION] Reverse traversal without mutating the list.");
        for (int targetId : targets.descending()) {
            System.out.println("Reverse scan: [#" + CYAN + targetId + RESET + "]");
        }
        System.out.println("\n[ACTION] Reversing list links in place.");
        targets.reverse();
        printList(targets);
        System.out.println("\nFirst target ID: " + CYAN + targets.getFirst() + RESET);
        System.out.println("Last target ID: " + CYAN + targets.getLast() + RESET);
        System.out.println("Total active targets: " + CYAN + targets.size() + RESET);
        System.out.println("\n" + CYAN + "[SYSTEM] Session locked. Transmission terminated." + RESET);
    }

    private static void loadNumbers(CustomLinkedList targets, String filename) {
        System.out.println(CYAN + "[SYSTEM] Reading target IDs from: " + filename + RESET);
        try (Scanner scanner = new Scanner(new File(filename))) {
            int numbersLoaded = 0;
            while (scanner.hasNext()) {
                // >>> ENHANCEMENT: Hardened token parsing logic to ensure complete stability against non-integer strings
                if (scanner.hasNextInt()) {
                    targets.insert(scanner.nextInt());
                    numbersLoaded++;
                } else {
                    scanner.next();
                }
            }
            if (numbersLoaded == 0) {
                loadSampleTargets(targets);
                System.out.println(RED + "[NOTICE] Data file contained no integers. Loaded sample targets instead." + RESET);
            } else {
                System.out.println(GREEN + "[SUCCESS] Target IDs loaded." + RESET);
            }
        } catch (FileNotFoundException e) {
            System.out.println(RED + "[ERROR] Data file missing. Loading sample targets instead." + RESET);
            loadSampleTargets(targets);
        }
    }

    private static void loadSampleTargets(CustomLinkedList targets) {
        targets.insert(101);
        targets.insert(501);
        targets.insert(302);
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println("=======================================================");
        System.out.println(GREEN + ">>> " + title + " <<<" + RESET);
        System.out.println("=======================================================");
    }

    private static void printList(CustomLinkedList targets) {
        if (targets.isEmpty()) {
            System.out.println("No active targets.");
            return;
        }
        Iterator<Integer> iterator = targets.iterator();
        while (iterator.hasNext()) {
            System.out.println("Target signal locked: [#" + CYAN + iterator.next() + RESET + "]");
        }
        System.out.println("List view: " + targets);
    }

    private static void loadAsciiArtBanner(String filepath) {
        try (Scanner scanner = new Scanner(new File(filepath))) {
            System.out.print(GREEN);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.print(RESET);
        } catch (FileNotFoundException e) {
            System.out.println(GREEN + "--- GALACTIC BOUNTY REGISTRY ---" + RESET);
        }
    }
}