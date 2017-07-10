package adtsuite.queue;

public class LinkedQueue<K> implements Queue<K> {

  // Pointer to head and tail of list
  private QueueNode<K> head = null;
  private QueueNode<K> tail = null;

  // Adds an item to the back of the queue
  @Override
  public void enqueue(K item) {
    tail = new QueueNode<K>(item, tail);
    if (this.isEmpty()) {
      head = tail;
    }
    if (tail.hasNext()) {
      tail.getNext().setPrev(tail);
    }
  }

  @Override
  public K peek() {
    if (isEmpty()) {
      throw new RuntimeException("Queue empty!");
    }
    return head.getElement();
  }

  // Removes an item from the front of the list
  @Override
  public K dequeue() {
    K item = head.getElement();
    head = head.getPrev();
    return item;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }
}
