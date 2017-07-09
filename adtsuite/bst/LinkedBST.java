package adtsuite.bst;

import java.util.NoSuchElementException;

public class LinkedBST<K extends Comparable<? super K>, V> implements BST<K, V> {

  // State
  private BSTTreeNode<K, V> root;

  @Override
  public void createEmptyTree() {
    this.root = null;
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public V getRootElem() {
    return this.root.getValue();
  }

  @Override
  public void insert(K key, V val) {
    this.root = insertElem(key, val, this.root);
  }

  private BSTTreeNode<K, V> insertElem(K key, V val, BSTTreeNode<K, V> currentNode) {
    // General strategy: find place where val should be
    // Overwrite this val/create new nodes if no value already stored for that key

    // If currentNode null
    if (currentNode == null) {
      currentNode = new BSTTreeNode<K, V>(key, val);
    }

    // If we have found the correct place
    else if (currentNode.getKey().compareTo(key) == 0) {
      // Overwrite the previous value
      currentNode.setValue(val);
    }

    // Not the correct place - look in subtrees
    // Set the children to be the root of the tree created when inserting into the subtrees
    else {
      // Left subtree
      if (currentNode.getKey().compareTo(key) > 0) {
        currentNode.setLeft(insertElem(key, val, currentNode.getLeft()));
      }
      // Right subtree
      else {
        currentNode.setRight(insertElem(key, val, currentNode.getRight()));
      }
    }

    // Return the currentNode
    // As this is the root of the new tree
    return currentNode;
  }

  @Override
  public void delete(K key) {
    root = deleteElem(key, this.root);
  }

  // Deletes an element from the tree
  // And returns the tree created
  private BSTTreeNode<K, V> deleteElem(K key, BSTTreeNode<K, V> currentNode) {

    // If hit leaf node
    if (currentNode == null) {
      throw new NoSuchElementException(key.toString());
    }

    // If found the correct place
    if (currentNode.getKey().compareTo(key) == 0) {
      // Delete node using auxiliary method
      return deleteNode(currentNode);
    }

    // Not found yet, so look in subtrees
    if (currentNode.getKey().compareTo(key) > 0) {
      // Left subtree
      currentNode.setLeft(deleteElem(key, currentNode.getLeft()));
    } else {
      // Right subtree
      currentNode.setRight(deleteElem(key, currentNode.getRight()));
    }

    // Return the current node
    // Which is the root of the modified tree
    return currentNode;
  }

  // Removes the current node from the tree
  // And returns the result of doing so
  private BSTTreeNode<K, V> deleteNode(BSTTreeNode<K, V> node) {

    // Case 0: No Children
    if (node.isLeaf()) {
      return null;
    }

    // Case 1: 1 child
    if (node.getRight() == null) {
      return node.getLeft();
    } else if (node.getLeft() == null) {
      return node.getRight();
    }

    // Case 2: 2 children

    // Replacement node: left-most child of right subtree
    BSTTreeNode<K, V> replacementNode = getLeftMostNode(node.getRight());

    // Set replacement node's children
    replacementNode.setLeft(node.getLeft());
    replacementNode.setRight(deleteLeftMostNode(node.getRight()));

    // replacementNode will now be the root of the new tree
    return replacementNode;
  }

  // Deletes the left-most node
  // And returns the result of the tree
  private BSTTreeNode<K, V> deleteLeftMostNode(BSTTreeNode<K, V> root) {
    // Base case: no left child
    if (root.getLeft() == null) {
      return root.getRight();
    }

    // Recursive case: go into the left subtree
    root.setLeft(deleteLeftMostNode(root.getLeft()));
    return root;
  }

  private BSTTreeNode<K, V> getLeftMostNode(BSTTreeNode<K, V> root) {
    // Base case: left pointer is null
    if (root.getLeft() == null) {
      return root;
    }
    // Recursive case: go into the left subtree
    return getLeftMostNode(root.getLeft());
  }

  @Override
  public V retrieve(K key) {
    return search(key, this.root).getValue();
  }

  // Search the tree for the node with that key
  private BSTTreeNode<K, V> search(K key, BSTTreeNode<K, V> currentNode) {
    // Base case: leaf node
    if (currentNode == null) {
      throw new NoSuchElementException(key.toString());
    }
    // Base case: element found
    if (key.compareTo(currentNode.getKey()) == 0) {
      return currentNode;
    }
    // Key less than current node
    else if (key.compareTo(currentNode.getKey()) < 0) {
      // Search left subtree
      return search(key, currentNode.getLeft());
    }
    // Key greater than current node
    else {
      // Search right subtree
      return search(key, currentNode.getRight());
    }
  }
}
