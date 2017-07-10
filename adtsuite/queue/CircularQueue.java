package adtsuite.queue;

import java.util.NoSuchElementException;

public class CircularQueue<K> implements Queue<K> {

  // Static implementation, stores items as a circular array
  private final int CAPACITY = 50;
  private K[] items = (K[]) new Object[CAPACITY];
  private int size = 0;
  // With pointers to head and tail of the queue
  private int head = CAPACITY - 1;
  private int tail = CAPACITY - 1;

  // Add item to the back of the queue
  @Override
  public void enqueue(K item) {
    if (this.isFull()) {
      throw new RuntimeException("Queue full.");
    }
    items[this.tail] = item;
    if (this.tail == 0) {
      this.tail = this.CAPACITY - 1;
    } else {
      this.tail = this.tail - 1;
    }
    this.size++;
  }

  // Returns the item at the head of the list
  @Override
  public K peek() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Queue empty.");
    }
    return items[this.head];
  }

  // Returns and removes the item at the head of the list
  @Override
  public K dequeue() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Queue empty.");
    }
    K item = items[this.head];
    // Decrease the head by 1
    if (this.head == 0) {
      this.head = this.CAPACITY - 1;
    } else {
      this.head = this.head - 1;
    }
    this.size--;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  private boolean isFull() {
    return this.size == this.CAPACITY;
  }
}
