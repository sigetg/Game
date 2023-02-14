/*
 * Author: George Sigety - sigetyg@bc.edu
 */

public class OrderedDoublyLinkedList<T extends Comparable<T>> implements OrderedList<T> {
  public enum Direction {
    ASCENDING,
    DESCENDING
  }
  private class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;
    public Node(T value) {
      this.value = value;
    }
    public T getValue() {
      return value;
    }
    public Node<T> getNext() {
      return next;
    }
    public void setNext(Node<T> next) {
      this.next = next;
    }
    public Node<T> getPrevious() {
      return previous;
    }
    public void setPrevious(Node<T> previous) {
      this.previous = previous;
    }
    public String toString() {
      return value.toString();
    }
  }

  //Instance Variables
  private Node<T> head;
  private Node<T> tail;
  private Direction direction;
  private int size;
  private T before;
  private T after;

  //Constructor
  public OrderedDoublyLinkedList(Direction direction) {
    this.direction = direction;
  }

  //Methods
  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {return size == 0;}

  @Override
  public T first() {
    if (isEmpty()) return null;
      return head.getNext().getValue();
  }

  @Override
  public T last() {
    if (isEmpty()) return null;
  return tail.getPrevious().getValue();
  }
  //What is addBetween?
  @Override
  public void addFirst(T name) {
    Node<T> newNode = new Node<>(name);
    if (isEmpty()) {
      head = newNode;
      tail = head;
    }
    size++;
  }

  @Override
  public void addLast(T name) {
    Node<T> newNode = new Node<>(name);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
      tail = newNode;
    }
    size++;
  }

  @Override
  public T removeFirst() {
    if (isEmpty( )) return null;
    return remove(head.getNext( ));
  }

  @Override
  public T removeLast() {
    if (isEmpty()) return null;
    return remove(tail.getPrevious());
  }

  private T remove(Node<T> node) {
    Node<T> before = node.getPrevious( );
    Node<T> after = node.getNext( );
    before.setNext(after);
    before.setPrevious(after);
    size--;
    return node.getValue();
  }
  private boolean comesBefore(Node<T> first, Node<T> second) {
    int result = first.getValue().compareTo(second.getValue());
    if (direction == Direction.ASCENDING) {
      return result < 0;
    } else {
      return result >= 0;
    }
  }
  @Override
  public void insert(T name) {
    Node<T> newNode = new Node<>(name);
    if (head == null) {
      head = newNode;
      tail = head;
    } else {
      Node<T> current = head;
      while (current != null && comesBefore(current, newNode)) {
        current = current.getNext();
      }
      if (current == null) {
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
      } else if (current == head) {
        newNode.setNext(head);
        head.setPrevious(newNode);
        head = newNode;
      } else {
        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        newNode.getPrevious().setNext(newNode);
        current.setPrevious(newNode);
      }
    }
  }
  @Override
  public void print(String format) {
    Node<T> current = head;
    while (current != null) {
      System.out.printf(format, current);
      current = current.getNext();
    }
  }
}
