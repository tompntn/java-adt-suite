package adtsuite.queue;

public class QueueNode<K> {

  private final K element;
  private QueueNode<K> next = null;
  private QueueNode<K> prev = null;

  public QueueNode(K element) {
    this(element, null,null);
  }

  public QueueNode(K element, QueueNode<K> next) {
    this(element, next, null);
  }

  public QueueNode(K element, QueueNode<K> next, QueueNode<K> prev) {
    this.element = element;
    this.next = next;
    this.prev = prev;
  }

  public boolean hasNext() {
    return next != null;
  }

  public K getElement() {
    return element;
  }

  public QueueNode<K> getNext() {
    return next;
  }

  public void setNext(QueueNode<K> next) {
    this.next = next;
  }

  public QueueNode<K> getPrev() {
    return prev;
  }

  public void setPrev(QueueNode<K> prev) {
    this.prev = prev;
  }
}
