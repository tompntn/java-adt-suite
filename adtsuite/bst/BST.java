package adtsuite.bst;

public interface BST<K extends Comparable<? super K>, V> {

  // Creates an empty tree
  public void createEmptyTree();

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
}
