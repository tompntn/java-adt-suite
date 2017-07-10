package adtsuite.stack;

public interface Stack<K> {
  // Adds an item to the stack
  public void push(K item);

  // Removes an item from the stack and returns that item
  public K pop();

  // Returns the item from the top of the stack, without removing it
  public K peek();
}
