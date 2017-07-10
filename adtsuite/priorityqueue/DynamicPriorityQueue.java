package adtsuite.priorityqueue;

import java.util.stream.IntStream;

public class DynamicPriorityQueue<E> implements PriorityQueue<E> {
  
  // First points to the element with highest priority
  // Last points to the element with least priority

  // Pointer to the first element
  private PQNode<E> first = null;
  private PQNode<E> last = null;
  private int size = 0;

  @Override
  public void enqueue(E e, Comparable priority) {
    PQNode<E> node = new PQNode<E>(e, priority);

    // Empty queue
    if (first == null) {
      first = last = node;
    }
    // If priority >= first
    else if (priority.compareTo(first.getPriority()) >= 0) {
      node.setNext(first);
      first = node;
    }
    // If priority <= last
    else if (priority.compareTo(last.getPriority()) <= 0) {
      last.setNext(node);
      last = node;
    }
    // Traverse up the tree
    else {
      PQNode<E> newPQNode = new PQNode<E>(e, priority);
      PQNode<E> cursor = first;
      while (cursor.getNext() != null
          && priority.compareTo(cursor.getPriority()) > 0) {
        cursor = cursor.getNext();
      }
      newPQNode.setNext(cursor.getNext());
      cursor.setNext(newPQNode);
      // If reached end of list
      if (cursor.getNext() == null) {
        last = newPQNode;
      }
    }
    this.size++;
  }

  // Remove the first element
  @Override
  public E dequeue() {
    E item = first.getElement();
    if (first == last) {
      first = last = null;
    } else {
      first = first.getNext();
    }
    size--;
    return item;
  }

  @Override
  public E getFirst() {
    return this.first.getElement();
  }

  @Override
  public int size() {
    return this.size;
  }
}
