package adtsuite.avltree;

public interface AVLTree<K extends Comparable<? super K>, V> {

  // Determines if the tree is empty
  public boolean isEmpty();

  // Gets the root of the tree
  public V getRootElem();

  // Inserts a new item in it's correct position
  public void insert(K key, V item);

  // Deletes the item with the specified key
  public void delete(K key);

  // Retrieves the item with the specified key
  public V retrieve(K key);

  // For testing: returns true if tree is balanced
  public boolean isBalanced();
}
