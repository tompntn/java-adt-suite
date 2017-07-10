package adtsuite.priorityqueue;

public class PQNode<E> {

  private E element;
  private final Comparable priority;
  private PQNode<E> next;

  public PQNode(E element, Comparable priority) {
    this(element, priority, null);
  }

  public PQNode(E element, Comparable priority, PQNode<E> next) {
    this.element = element;
    this.priority = priority;
    this.next = next;
  }

  public E getElement() {
    return this.element;
  }

  public void setElement(E element) {
    this.element = element;
  }

  public PQNode<E> getNext() {
    return this.next;
  }

  public void setNext(PQNode<E> next) {
    this.next = next;
  }

  public Comparable getPriority() {
    return this.priority;
  }

  @Override
  public String toString() {
    if (this.getNext() != null) {
      return element.toString() + " (next: " + this.getNext().toString() + ")";
    } else {
      return this.element.toString();
    }
  }
}
