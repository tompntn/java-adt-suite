package adtsuite.bst;

public class BSTTreeNode<K extends Comparable<? super K>, V> {

  private K key;
  private V value;
  private BSTTreeNode<K, V> left;
  private BSTTreeNode<K, V> right;

  public BSTTreeNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public BSTTreeNode<K, V> getLeft() {
    return this.left;
  }

  public void setLeft(BSTTreeNode<K, V> left) {
    this.left = left;
  }

  public BSTTreeNode<K, V> getRight() {
    return right;
  }

  public void setRight(BSTTreeNode<K, V> right) {
    this.right = right;
  }

  public boolean isLeaf() {
    return left == null
        && right == null
        && key == null
        && value == null;
  }

  @Override
  public String toString() {
    return key.toString() + ": " + value.toString();
  }
}
