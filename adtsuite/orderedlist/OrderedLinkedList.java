package adtsuite.orderedlist;

import java.util.NoSuchElementException;

public class OrderedLinkedList<K extends Comparable<? super K>, V> implements OrderedList<K, V> {

  // One state:
  private ListNode<K, V> head;
  private int size = 0;

  @Override
  public boolean isEmpty() {
    return this.head == null;
  }

  @Override
  public void put(K key, V val) {
    this.head = putHelper(key, val, this.head);
  }

  // Returns the new list, with the element inserted
  private ListNode<K, V> putHelper(K key, V val, ListNode<K, V> node) {
    // If current node is null then insert the item into a new list node
    if (node == null) {
      return new ListNode<K, V>(key, val);
    }
    // If current node less than one to insert
    if (node.getKey().compareTo(key) < 0) {
      //  Go to next item in the list
      node.setNext(putHelper(key, val, node.getNext()));
      // Return the head of the list
      return node;
    }
    // If current node greater than or equal to the one to insert
    else {
      // The head of the list should now be the new node
      return new ListNode<K, V>(key, val, node);
    }
  }

  @Override
  public V get(K key) {
    return getValue(key, this.head);
  }

  private V getValue(K key, ListNode<K, V> node) {
    // If found item, return it
    if (key.compareTo(node.getKey()) == 0) {
      return node.getVal();
    } else {
      // Not found
      if (node.getNext() == null) {
        // Throw exception if reached end of list
        throw new NoSuchElementException("" + key);
      } else {
        // Check next item
        return getValue(key, node.getNext());
      }
    }
  }

  @Override
  public void remove(K key) {
    this.head = removeItem(key, this.head);
  }

  // Returns the head of the list with the item removed
  private ListNode<K, V> removeItem(K key, ListNode<K, V> node) {
    // Base Case: reached end of list
    if (node == null) {
      return null;
    }
    // If found item
    if (node.getKey().compareTo(key) == 0) {
      // Return the next item
      return node.getNext();
    }
    // If not found item, traverse up the list
    node.setNext(removeItem(key, node.getNext()));
    return node;
  }

  @Override
  public int size() {
    return 0;
  }
}
