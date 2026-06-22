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
import java.util.Objects;
import java.util.Scanner;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private int modificationCount;

    public void insert(T value) { addLast(value); }
    public void addFirst(T value) { linkFirst(value); }
    public void addLast(T value) { linkLast(value); }

    public void add(int index, T value) {
        checkPositionIndex(index);
        if (index == size) { linkLast(value); return; }
        if (index == 0) { linkFirst(value); return; }

        Node<T> nextNode = nodeAt(index);
        Node<T> previousNode = nextNode.previous;
        Node<T> newNode = new Node<>(value, previousNode, nextNode);
        previousNode.next = newNode;
        nextNode.previous = newNode;
        size++;
        modificationCount++;
    }

    public boolean delete(T value) {
        Node<T> node = findNode(value);
        if (node == null) return false;
        unlink(node);
        return true;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("Cannot remove from an empty list.");
        return unlink(head);
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException("Cannot remove from an empty list.");
        return unlink(tail);
    }

    public T removeAt(int index) {
        checkElementIndex(index);
        return unlink(nodeAt(index));
    }

    public T getFirst() {
        if (head == null) throw new NoSuchElementException("The list is empty.");
        return head.value;
    }

    public T getLast() {
        if (tail == null) throw new NoSuchElementException("The list is empty.");
        return tail.value;
    }

    public T get(int index) {
        checkElementIndex(index);
        return nodeAt(index).value;
    }

    public T set(int index, T value) {
        checkElementIndex(index);
        Node<T> node = nodeAt(index);
        T oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    public boolean contains(T value) { return findNode(value) != null; }

    public int indexOf(T value) {
        Node<T> current = head;
        for (int index = 0; current != null; index++) {
            if (Objects.equals(current.value, value)) return index;
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        Node<T> current = tail;
        for (int index = size - 1; current != null; index--) {
            if (Objects.equals(current.value, value)) return index;
            current = current.previous;
        }
        return -1;
    }

    public void reverse() {
        if (size <= 1) return;
        Node<T> forward = head;
        Node<T> backward = tail;
        for (int i = 0; i < size / 2; i++) {
            T temp = forward.value;
            forward.value = backward.value;
            backward.value = temp;
            forward = forward.next;
            backward = backward.previous;
        }
        modificationCount++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        modificationCount++;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Object[] toArray() {
        Object[] values = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < values.length; i++) {
            values[i] = current.value;
            current = current.next;
        }
        return values;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public Iterable<T> descending() {
        return () -> new ReverseIterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            builder.append(current.value);
            current = current.next;
            if (current != null) builder.append(" <-> ");
        }
        return builder.append("]").toString();
    }

    private void linkFirst(T value) {
        Node<T> oldHead = head;
        Node<T> newNode = new Node<>(value, null, oldHead);
        head = newNode;
        if (oldHead == null) tail = newNode;
        else oldHead.previous = newNode;
        size++;
        modificationCount++;
    }

    private void linkLast(T value) {
        Node<T> oldTail = tail;
        Node<T> newNode = new Node<>(value, oldTail, null);
        tail = newNode;
        if (oldTail == null) head = newNode;
        else oldTail.next = newNode;
        size++;
        modificationCount++;
    }

    private T unlink(Node<T> node) {
        T removedValue = node.value;
        Node<T> previousNode = node.previous;
        Node<T> nextNode = node.next;

        if (previousNode == null) head = nextNode;
        else previousNode.next = nextNode;

        if (nextNode == null) tail = previousNode;
        else nextNode.previous = previousNode;

        node.value = null;
        node.previous = null;
        node.next = null;
        size--;
        modificationCount++;
        return removedValue;
    }

    private Node<T> nodeAt(int index) {
        if (index < size / 2) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current;
        }
        Node<T> current = tail;
        for (int i = size - 1; i > index; i--) current = current.previous;
        return current;
    }

    private Node<T> findNode(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) return current;
            current = current.next;
        }
        return null;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is outside list size " + size + ".");
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is outside valid insert range 0.." + size + ".");
        }
    }

    private static final class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private abstract class CheckedIterator implements Iterator<T> {
        protected final int expectedModificationCount = modificationCount;
        protected Node<T> nextNode;

        private CheckedIterator(Node<T> start) { nextNode = start; }

        @Override public boolean hasNext() { return nextNode != null; }

        @Override
        public T next() {
            if (expectedModificationCount != modificationCount) throw new ConcurrentModificationException();
            if (nextNode == null) throw new NoSuchElementException();
            T value = nextNode.value;
            nextNode = advance(nextNode);
            return value;
        }

        protected abstract Node<T> advance(Node<T> current);
    }

    private final class LinkedListIterator extends CheckedIterator {
        private LinkedListIterator() { super(head); }
        @Override protected Node<T> advance(Node<T> current) { return current.next; }
    }

    private final class ReverseIterator extends CheckedIterator {
        private ReverseIterator() { super(tail); }
        @Override protected Node<T> advance(Node<T> current) { return current.previous; }
    }
}