package adtsuite.orderedlist;

public class ListNode<K extends Comparable<? super K>, V> {

  // Fields
  private K key;
  private V val;
  private ListNode<K, V> next = null;

  // Default constructor
  public ListNode(K key, V val) {
    this.key = key;
    this.val = val;
  }
  // Secondary constructor
  public ListNode(K key, V val, ListNode<K, V> next) {
    this(key, val);
    this.next = next;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getVal() {
    return val;
  }

  public void setVal(V val) {
    this.val = val;
  }

  public ListNode<K, V> getNext() {
    return next;
  }

  public void setNext(ListNode<K, V> next) {
    this.next = next;
  }
}
