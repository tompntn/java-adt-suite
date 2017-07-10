package adtsuite.stack;

import java.util.EmptyStackException;

public class ArrayBasedStack<K> implements Stack<K> {

  private final int CAPACITY;
  private final K[] items;
  private int size = 0;

  public ArrayBasedStack(int capacity) {
    this.CAPACITY = capacity;
    items = (K[]) new Object[CAPACITY];
  }

  public ArrayBasedStack() {
    // Default capacity of 50
    this(50);
  }

  // Adds an item to the head of the stack
  @Override
  public void push(K item) {
    if (isFull()) {
      throw new StackOverflowError();
    }
    items[size++] = item;
  }

  private boolean isFull() {
    return size >= CAPACITY;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  @Override
  public K pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return items[--size];
  }

  @Override
  public K peek() {
    return items[size - 1];
  }
}
