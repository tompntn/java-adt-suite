# Java ADT Suite
Abstract Data Types (ADT's) included in this package:
- Binary Search Tree
- AVL (self-balancing) Tree
- Priority Queue

All the provided implementations have been thoroughly tested and are safe to use in your project (with unit tests coming soon). Interfaces and implementations are provided for each ADT.

## Binary Search Tree
Creating a new tree:
`BST<K, V> bst = new LinkedBST<>();`
The interface is generic, so `<K, V>` should be substituted with the key/value types you need.

Create an empty tree:
`public void createEmptyTree();`
Determine if the tree is empty:
`public boolean isEmpty();`
Get the root of the tree:
`public V getRootElem();`
Insert a new item in the correct position:
`public void insert(K key, V item);`
Delete the item with the specified key:
`public void delete(K key);`
Retrieve the item with the specified key:
`public V retrieve(K key);`

### AVL Tree
An AVL Tree (named after it's Russian inventors) is a self-balancing binary search tree, keeping the time required to access elements logarithmic in the size of the tree. It can be useful if you are performing many more accesses than insertions/deletions.

Creating a new AVL Tree:
`AVLTree<K, V> avlTree = new LinkedAVL<>();`

All of the functions implemented by the BST are also implemented by the AVL Tree, with the addition of `isBalanced`, which returns true iff the tree is balanced (useful when debugging).
`public boolean isBalanced();`


## Priority Queue
Creating a new priority queue:
`PriorityQueue<E> priorityQueue = new DynamicPriorityQueue<>();`

Add an element to the queue:
`public void enqueue(E e, Comparable priority);`
Get and removes the element at the front of the queue:
`public E dequeue();`
Get the element at the front of the queue:
`public E getFirst();`
Get the number of elements in the queue:
`public int size();`
Check if the queue is empty:
`default public boolean isEmpty();`
