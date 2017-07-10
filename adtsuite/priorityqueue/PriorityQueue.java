package adtsuite.priorityqueue;

public interface PriorityQueue<E> {

  // Adds an element to the queue
  public void enqueue(E e, Comparable priority);

  // Gets and removes the element at the front of the queue
  public E dequeue();

  // Gets the element at the front of the queue
  public E getFirst();

  // Gets the number of elements in the queue
  public int size();

  // Checks that the queue is empty or not
  default public boolean isEmpty() {
    // Works for all implementations that have implemented size() correctly
    return size() == 0;
  }
}
