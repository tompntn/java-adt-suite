# Java ADT Suite
Abstract Data Types (ADT's) included in this package:
- Binary Search Tree
- AVL (self-balancing) Tree
- Priority Queue

All the provided implementations have been thoroughly tested and are safe to use in your project (with unit tests coming soon). Interfaces and implementations are provided for each ADT.

## Binary Search Tree
Create a new Binary Search Tree:
``` java
BST<K, V> bst = new LinkedBST<>();
```
The interface is generic, so `<K, V>` should be substituted with the key/value types you need.

Create an empty tree:
``` java
public void createEmptyTree();
```
Determine if the tree is empty:
``` java
public boolean isEmpty();
```
Get the root of the tree:
``` java
public V getRootElem();
```
Insert a new item in the correct position:
``` java
public void insert(K key, V item);
```
Delete the item with the specified key:
``` java
public void delete(K key);
```
Retrieve the item with the specified key:
``` java
public V retrieve(K key);
```

### AVL Tree
An AVL Tree (named after it's Russian inventors) is a self-balancing binary search tree, keeping the time required to access elements logarithmic in the size of the tree. It can be useful if you are performing many more accesses than insertions/deletions.

Create a new AVL Tree:
``` java
AVLTree<K, V> avlTree = new LinkedAVL<>();
```

All of the functions implemented by the BST are also implemented by the AVL Tree, with the addition of `isBalanced`, which returns true iff the tree is balanced (useful when debugging).
``` java
public boolean isBalanced();
```


## Priority Queue
Creating a new priority queue:
``` java
PriorityQueue<E> priorityQueue = new DynamicPriorityQueue<>();
```

Add an element to the queue:
``` java
public void enqueue(E e, Comparable priority);
```
Get and removes the element at the front of the queue:
``` java
public E dequeue();
```
Get the element at the front of the queue:
``` java
public E getFirst();
```
Get the number of elements in the queue:
``` java
public int size();
```
Check if the queue is empty:
``` java
default public boolean isEmpty();
```
