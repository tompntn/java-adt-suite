package adtsuite.avltree;

import java.util.NoSuchElementException;

public class LinkedAVL<K extends Comparable<? super K>, V> implements AVLTree<K, V> {

  // State
  private AVLTreeNode<K, V> root;

  // Default constructor
  public LinkedAVL() {
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

  // height: height of current level
  private AVLTreeNode<K, V> insertElem(K key, V val, AVLTreeNode<K, V> currentNode) {
    // General strategy: find place where val should be
    // Overwrite this val/create new nodes if no value already stored for that key

    // If currentNode null
    if (currentNode == null) {
      // New nodes have a height of 1
      currentNode = new AVLTreeNode<K, V>(key, val);
    }

    // If we have found the correct place
    else if (currentNode.getKey().compareTo(key) == 0) {
      // Overwrite the previous value
      // No change in height needed
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
      // New height: 1 + height of both subtrees
      currentNode.setHeight(1 + Math.max(getNodeHeight(currentNode.getRight()), getNodeHeight(currentNode.getLeft())));
    }

    // Return the currentNode
    // As this is the root of the new tree
    // Rebalanced
    return rebalance(currentNode);
  }

  @Override
  public void delete(K key) {
    root = deleteElem(key, this.root);
  }

  // Deletes an element from the tree
  // And returns the tree created
  private AVLTreeNode<K, V> deleteElem(K key, AVLTreeNode<K, V> currentNode) {

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

    // Recalculate the height of the tree returned


    // Return the current node
    // Which is the root of the modified tree
    // Rebalanced
    return rebalance(currentNode);
  }

  // Removes the current node from the tree
  // And returns the result of doing so
  private AVLTreeNode<K, V> deleteNode(AVLTreeNode<K, V> node) {

    // Case 0: No Children
    if (node.isLeaf()) {
      return null;
    }

    // Case 1: 1 child
    if (node.getRight() == null) {
      AVLTreeNode<K, V> leftNode = node.getLeft();
      return node.getLeft();
    } else if (node.getLeft() == null) {
      AVLTreeNode<K, V> rightNode = node.getRight();
      return node.getRight();
    }

    // Case 2: 2 children

    // Replacement node: left-most child of right subtree
    AVLTreeNode<K, V> replacementNode = getLeftMostNode(node.getRight());

    // Set replacement node's children
    replacementNode.setRight(deleteLeftMostNode(node.getRight()));
    replacementNode.setLeft(node.getLeft());

    // Recalculate replacement node's height
    replacementNode.setHeight(1 + Math.max(getNodeHeight(replacementNode.getRight()), getNodeHeight(replacementNode.getLeft())));

    // replacementNode will now be the root of the new tree
    return replacementNode;
  }

  // Deletes the left-most node
  // And returns the result of the tree
  private AVLTreeNode<K, V> deleteLeftMostNode(AVLTreeNode<K, V> root) {
    // Base case: no left child
    if (root.getLeft() == null) {
      return root.getRight();
    }

    // Recursive case: go into the left subtree
    root.setLeft(deleteLeftMostNode(root.getLeft()));
    return root;
  }

  private AVLTreeNode<K, V> getLeftMostNode(AVLTreeNode<K, V> root) {
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
  private AVLTreeNode<K, V> search(K key, AVLTreeNode<K, V> currentNode) {
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

  // Returns the rebalanced tree
  private AVLTreeNode<K, V> rebalance(AVLTreeNode<K, V> currentNode) {

    // Which side is it inbalanced on?
    int rSubLHeight = getNodeHeight(currentNode.getRight()) - getNodeHeight(currentNode.getLeft());
    if (rSubLHeight > 1) {
      // Imbalanced on the right hand side
      AVLTreeNode<K, V> childNode = currentNode.getRight();
      if (getNodeHeight(childNode.getLeft()) > getNodeHeight(childNode.getRight())) {
        // Right-left rotation
        return rightLeftRotation(currentNode);
      } else {
        // Left rotation
        return leftRotation(currentNode);
      }
    }
    else if (rSubLHeight < -1) {
      // Imbalanced on the left hand side
      AVLTreeNode<K, V> childNode = currentNode.getLeft();
      if (getNodeHeight(childNode.getRight()) > getNodeHeight(childNode.getLeft())) {
        // Left-right rotation
        return leftRightRotation(currentNode);
      } else {
        // Right rotation
        return rightRotation(currentNode);
      }
    }
    // If neither of these cases apply the node is already balanced
    return currentNode;

  }

  // Left rotation - returns the new tree after left rotation has been performed
  private AVLTreeNode<K, V> leftRotation(AVLTreeNode<K, V> currentNode) {
    // New root: current node's right child
    AVLTreeNode<K, V> root = currentNode.getRight();
    // current node's new right child is root's old left
    currentNode.setRight(root.getLeft());
    // root's new left child is current node
    root.setLeft(currentNode);
    // Update height of current node
    currentNode.setHeight(1 + Math.max(getNodeHeight(currentNode.getLeft()), getNodeHeight(currentNode.getRight())));
    // Update height of root node
    // Update height of current node
    root.setHeight(1 + Math.max(getNodeHeight(root.getLeft()), getNodeHeight(root.getRight())));
    // Return root - the new tree
    return root;
  }

  // Right rotation - returns the new tree formed
  private AVLTreeNode<K, V> rightRotation(AVLTreeNode<K, V> currentNode) {
    // New root: left hand child
    AVLTreeNode<K, V> root = currentNode.getLeft();
    // currentNode's new left hand child is the right hand child of the new root
    currentNode.setLeft(root.getRight());
    // New root's right child is currentNode
    root.setRight(currentNode);
    // Update height of current node
    currentNode.setHeight(1 + Math.max(getNodeHeight(currentNode.getLeft()), getNodeHeight(currentNode.getRight())));
    // Update height of root node
    root.setHeight(1 + Math.max(getNodeHeight(root.getLeft()), getNodeHeight(root.getRight())));
    // Return root node has root of new tree
    return root;
  }

  // Right-left rotation
  private AVLTreeNode<K, V> rightLeftRotation(AVLTreeNode<K, V> currentNode) {

    // Right rotation on current node's right child
    currentNode.setRight(rightRotation(currentNode.getRight()));
    // Left rotation on current node
    return leftRotation(currentNode);

  }

  // Left-right rotation - returns the new tree formed
  private AVLTreeNode<K, V> leftRightRotation(AVLTreeNode<K, V> currentNode) {

    // Left rotation on current node's left child
    currentNode.setLeft(leftRotation(currentNode.getLeft()));
    // Right rotation on current node
    return rightRotation(currentNode);

  }

  // More elegant handling of heights of null nodes
  private int getNodeHeight(AVLTreeNode<K, V> node) {
    if (node == null) {
      return 0;
    } else {
      return node.getHeight();
    }
  }

  @Override
  public boolean isBalanced() {
    return isBalancedNode(this.root);
  }

  private boolean isBalancedNode(AVLTreeNode<K, V> node) {
    // Base case: left node
    if (node == null
    || node.isLeaf()) {
      return true;
    }
    // Check this node is balanced
    if (Math.abs(getNodeHeight(node.getRight()) - getNodeHeight(node.getLeft())) > 1) {
      return false;
    }
    // Is balanced
    else {
      return isBalancedNode(node.getRight())
          && isBalancedNode(node.getLeft());
    }
  }

  @Override
  public String toString() {
    if (isBalanced()) {
      return "Balanced.";
    }
    return "Not balanced";
  }
}
