/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemservicospublicos;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 *
 * @author DEI-ISEP
 * @param <E> Generic list element type
 */
public class DoublyLinkedList<E> implements Iterable<E>, Cloneable {

// instance variables of the DoublyLinkedList
    private final Node<E> header;     // header sentinel
    private final Node<E> trailer;    // trailer sentinel
    private int size = 0;       // number of elements in the list
    private int modCount = 0;   // number of modifications to the list (adds or removes)

    /**
     * Creates both elements which act as sentinels
     */
    public DoublyLinkedList() {

        header = new Node<>(null, null, null);      // create header
        trailer = new Node<>(null, header, null);   // trailer is preceded by header
        header.setNext(trailer);                    // header is followed by trailer
    }

    /**
     * Returns the number of elements in the linked list
     *
     * @return the number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, and false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns (but does not remove) the first element in the list
     *
     * @return the first element of the list
     */
    public E first() {
        return header.getNext().getElement();
    }

    /**
     * Returns (but does not remove) the last element in the list
     *
     * @return the last element of the list
     */
    public E last() {
        return trailer.getPrev().getElement();
    }

// public update methods
    /**
     * Adds an element e to the front of the list
     *
     * @param e element to be added to the front of the list
     */
    public void addFirst(E e) {
        // place just after the header
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element e to the end of the list
     *
     * @param e element to be added to the end of the list
     */
    public void addLast(E e) {
        // place just before the trailer
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list
     *
     * @return the first element of the list
     */
    public E removeFirst() {
        E element = remove(header.getNext());
        return element;
    }

    /**
     * Removes and returns the last element of the list
     *
     * @return the last element of the list
     */
    public E removeLast() {
        E element = remove(trailer.getPrev());
        return element;
    }

// private update methods
    /**
     * Adds an element e to the linked list between the two given nodes.
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(e, predecessor, successor);
        predecessor.setNext(node);
        successor.setPrev(node);
        modCount++;
        size++;
    }

    /**
     * Removes a given node from the list and returns its content.
     */
    private E remove(Node<E> node) {
        if (size > 0) {
            E element = node.getElement();
            Node<E> tempPrev = node.getPrev();
            Node<E> tempNext = node.getNext();
            tempPrev.setNext(tempNext);
            tempNext.setPrev(tempPrev);
            modCount++;
            size--;
            return element;
        } else {
            return null;
        }
    }

// Overriden methods        
    @Override
    public boolean equals(Object obj) {
        DoublyLinkedList <E> that = (DoublyLinkedList <E>) obj;
        if(that.size != size){
            return false;
        }
        if(that.size ==0 && size ==0){
            return true;
        }
        Node<E> temp = header.getNext();
        int cont =0;
        ListIterator <E> itr = that.listIterator();
        while(itr.hasNext()){
            if(temp.element == itr.next()){
                cont++;
                temp = temp.getNext();
            }
        }
        return (cont == size);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if(size == 0){
            throw new CloneNotSupportedException();
        }
        DoublyLinkedList <E> copy = new DoublyLinkedList<>();
        Node<E> temp = header.getNext();
        while (temp != trailer){
            copy.addLast(temp.getElement());
            temp = temp.getNext();
        }
        return copy;
    }

//---------------- nested DoublyLinkedListIterator class ----------------        
    private class DoublyLinkedListIterator implements ListIterator<E> {

        private DoublyLinkedList.Node<E> nextNode, prevNode, lastReturnedNode; // node that will be returned using next and prev respectively
        private int nextIndex;  // Index of the next element
        private int expectedModCount;  // Expected number of modifications = modCount;

        public DoublyLinkedListIterator() {
            this.prevNode = header;
            this.nextNode = header.getNext();
            lastReturnedNode = null;
            nextIndex = 0;
            expectedModCount = modCount;
        }

        final void checkForComodification() {  // invalidate iterator on list modification outside the iterator
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return (nextNode != trailer);
        }

        @Override
        public E next() throws NoSuchElementException {
            checkForComodification();
            if (this.hasNext()) {
                this.prevNode = this.nextNode;
                this.nextNode = prevNode.getNext();
                this.lastReturnedNode = this.prevNode;
                nextIndex++;
                return lastReturnedNode.getElement();
            } else {
                throw new NoSuchElementException("End of list Reached");
            }
        }

        @Override
        public boolean hasPrevious() {
            return (prevNode != header);
        }

        @Override
        public E previous() throws NoSuchElementException {
            checkForComodification();
            if (this.hasPrevious()) {
                this.nextNode = this.prevNode;
                this.prevNode = this.nextNode.getPrev();
                this.lastReturnedNode = this.nextNode;
                nextIndex--;
                return lastReturnedNode.getElement();
            } else {
                throw new NoSuchElementException("Beginning of list Reached");
            }

        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() throws NoSuchElementException {
            if (this.lastReturnedNode == null) {
                throw new NoSuchElementException();
            }
            checkForComodification();
            this.prevNode = this.nextNode.getPrev();
            DoublyLinkedList.this.remove(this.lastReturnedNode);
            this.lastReturnedNode = this.prevNode;
            expectedModCount++;
            if(size == 0 ){
                this.lastReturnedNode = null;
            }
        }

        @Override
        public void set(E e) throws NoSuchElementException {
            if (this.lastReturnedNode == null) {
                throw new NoSuchElementException();
            }
            checkForComodification();
            lastReturnedNode.setElement(e);
        }

        @Override
        public void add(E e) {
            checkForComodification();
            DoublyLinkedList.this.addBetween(e, prevNode, nextNode);
            this.prevNode = nextNode.getPrev();
            this.lastReturnedNode = prevNode;
            expectedModCount++;
        }

    }    //----------- end of inner DoublyLinkedListIterator class ----------

//---------------- Iterable implementation ----------------
    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    public ListIterator<E> listIterator() {
        return new DoublyLinkedListIterator();
    }

//---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;      // reference to the element stored at this node
        private Node<E> prev;   // reference to the previous node in the list
        private Node<E> next;   // reference to the subsequent node in the list

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) { // Not on the original interface. Added due to list iterator implementation
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    } //----------- end of nested Node class ----------

}
