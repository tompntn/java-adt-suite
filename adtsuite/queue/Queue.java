package adtsuite.queue;

public interface Queue<K> {

  // Adds an element to the back of the queue
  public void enqueue(K item);

  // Gets the element from the front of the queue without removing it
  public K peek();

  // Get and removes the element at the front of the queue
  public K dequeue();

  // Checks if queue is empty
  public boolean isEmpty();
}
