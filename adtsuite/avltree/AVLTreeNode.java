package adtsuite.avltree;

public class AVLTreeNode<K extends Comparable<? super K>, V> {

  private K key;
  private V value;
  private AVLTreeNode<K, V> left;
  private AVLTreeNode<K, V> right;
  // Height: height of tallest subtree
  private int height;

  public AVLTreeNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.height = 1;
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

  public AVLTreeNode<K, V> getLeft() {
    return this.left;
  }

  public void setLeft(AVLTreeNode<K, V> left) {
    this.left = left;
  }

  public AVLTreeNode<K, V> getRight() {
    return right;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setRight(AVLTreeNode<K, V> right) {
    this.right = right;
  }

  public boolean isLeaf() {
    return left == null
        && right == null;
  }

  // Returns the difference in height of the subtrees
  int getSubtreeDifference() {
    // 0 children
    if (this.isLeaf()) {
      return 0;
    }
    // 1 child
    else if (this.getLeft() == null) {
      return this.getRight().getHeight();
    }
    else if (this.getRight() == null) {
      return -this.getRight().getHeight();
    }
    // 2 children
    else {
      return this.getRight().getHeight() - this.getLeft().getHeight();
    }
  }

  @Override
  public String toString() {
    return this.key.toString() + ": " + this.value.toString()
        + " (height: " + this.getHeight() + ")";
  }
}
