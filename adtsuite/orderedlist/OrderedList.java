package adtsuite.orderedlist;

public interface OrderedList<K, V> {

  // Check if list is empty
  public boolean isEmpty();

  // Inserts an item into the list
  public void put(K key, V val);

  // Fetches the item with the specified key
  public V get(K key);

  // Removes the element with the specified search key
  public void remove(K key);

  // Returns the size of the list
  public int size();
}
