/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 *
 * @author DEI-ISEP
 * @param <Reparticao> Generic list element type
 */
public class DoublyLinkedList<Reparticao> implements Iterable<Reparticao>, Cloneable {

// instance variables of the DoublyLinkedList
    private final Node<Reparticao> header;     // header sentinel
    private final Node<Reparticao> trailer;    // trailer sentinel
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
    public Reparticao first() {
        return header.getNext().getReparticao();
    }

    /**
     * Returns (but does not remove) the last element in the list
     *
     * @return the last element of the list
     */
    public Reparticao last() {
        return trailer.getPrev().getReparticao();
    }

// public update methods
    /**
     * Adds an element e to the front of the list
     *
     * @param e element to be added to the front of the list
     */
    public void addFirst(Reparticao e) {
        // place just after the header
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element e to the end of the list
     *
     * @param e element to be added to the end of the list
     */
    public void addLast(Reparticao r) {
        // place just before the trailer
        addBetween(r, trailer.getPrev(), trailer);
    }

    /**
     * Removes and returns the first element of the list
     *
     * @return the first element of the list
     */
    public Reparticao removeFirst() {
        Reparticao reparticao = remove(header.getNext());
        return reparticao;
    }

    /**
     * Removes and returns the last element of the list
     *
     * @return the last element of the list
     */
    public Reparticao removeLast() {
        Reparticao reparticao = remove(trailer.getPrev());
        return reparticao;
    }

// private update methods
    /**
     * Adds an element e to the linked list between the two given nodes.
     */
    private void addBetween(Reparticao e, Node<Reparticao> predecessor, Node<Reparticao> successor) {
        Node<Reparticao> node = new Node<>(e, predecessor, successor);
        predecessor.setNext(node);
        successor.setPrev(node);
        modCount++;
        size++;
    }

    /**
     * Removes a given node from the list and returns its content.
     */
    private Reparticao remove(Node<Reparticao> node) {
        if (size > 0) {
            Reparticao reparticao = node.getReparticao();
            Node<Reparticao> tempPrev = node.getPrev();
            Node<Reparticao> tempNext = node.getNext();
            tempPrev.setNext(tempNext);
            tempNext.setPrev(tempPrev);
            modCount++;
            size--;
            return reparticao;
        } else {
            return null;
        }
    }

// Overriden methods        
    @Override
    public boolean equals(Object obj) {
        DoublyLinkedList <Reparticao> that = (DoublyLinkedList <Reparticao>) obj;
        if(that.size != size){
            return false;
        }
        if(that.size ==0 && size ==0){
            return true;
        }
        Node<Reparticao> temp = header.getNext();
        int cont =0;
        ListIterator <Reparticao> itr = that.listIterator();
        while(itr.hasNext()){
            if(temp.reparticao == itr.next()){
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
        DoublyLinkedList <Reparticao> copy = new DoublyLinkedList<>();
        Node<Reparticao> temp = header.getNext();
        while (temp != trailer){
            copy.addLast(temp.getReparticao());
            temp = temp.getNext();
        }
        return copy;
    }

//---------------- nested DoublyLinkedListIterator class ----------------        
    private class DoublyLinkedListIterator implements ListIterator<Reparticao> {

        private DoublyLinkedList.Node<Reparticao> nextNode, prevNode, lastReturnedNode; // node that will be returned using next and prev respectively
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
        public Reparticao next() throws NoSuchElementException {
            checkForComodification();
            if (this.hasNext()) {
                this.prevNode = this.nextNode;
                this.nextNode = prevNode.getNext();
                this.lastReturnedNode = this.prevNode;
                nextIndex++;
                return lastReturnedNode.getReparticao();
            } else {
                throw new NoSuchElementException("End of list Reached");
            }
        }

        @Override
        public boolean hasPrevious() {
            return (prevNode != header);
        }

        @Override
        public Reparticao previous() throws NoSuchElementException {
            checkForComodification();
            if (this.hasPrevious()) {
                this.nextNode = this.prevNode;
                this.prevNode = this.nextNode.getPrev();
                this.lastReturnedNode = this.nextNode;
                nextIndex--;
                return lastReturnedNode.getReparticao();
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
        public void set(Reparticao r) throws NoSuchElementException {
            if (this.lastReturnedNode == null) {
                throw new NoSuchElementException();
            }
            checkForComodification();
            lastReturnedNode.setReparticao(r);
        }

        @Override
        public void add(Reparticao r) {
            checkForComodification();
            DoublyLinkedList.this.addBetween(r, prevNode, nextNode);
            this.prevNode = nextNode.getPrev();
            this.lastReturnedNode = prevNode;
            expectedModCount++;
        }

    }    //----------- end of inner DoublyLinkedListIterator class ----------

//---------------- Iterable implementation ----------------
    @Override
    public Iterator<Reparticao> iterator() {
        return new DoublyLinkedListIterator();
    }

    public ListIterator<Reparticao> listIterator() {
        return new DoublyLinkedListIterator();
    }

//---------------- nested Node class ----------------
    private static class Node<Reparticao> {

        private Reparticao reparticao;      // reference to the element stored at this node
        private Node<Reparticao> prev;   // reference to the previous node in the list
        private Node<Reparticao> next;   // reference to the subsequent node in the list

        public Node(Reparticao r, Node<Reparticao> prev, Node<Reparticao> next) {
            this.reparticao = r;
            this.prev = prev;
            this.next = next;
        }

        public Reparticao getReparticao() {
            return reparticao;
        }

        public Node<Reparticao> getPrev() {
            return prev;
        }

        public Node<Reparticao> getNext() {
            return next;
        }

        public void setReparticao(Reparticao r) { // Not on the original interface. Added due to list iterator implementation
            this.reparticao = r;
        }

        public void setPrev(Node<Reparticao> prev) {
            this.prev = prev;
        }

        public void setNext(Node<Reparticao> next) {
            this.next = next;
        }
    } //----------- end of nested Node class ----------

}

