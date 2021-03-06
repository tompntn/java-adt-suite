# Java ADT Suite
Abstract Data Types (ADT's) included in this package:
- Binary Search Tree
- AVL (self-balancing) Tree
- Queue
- Priority Queue
- Stack
- Ordered List

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

## AVL Tree
An AVL Tree (named after it's Russian inventors) is a self-balancing binary search tree, keeping the time required to access elements logarithmic in the size of the tree. It can be useful if you are performing many more accesses than insertions/deletions.

Create a new AVL Tree:
``` java
AVLTree<K, V> avlTree = new LinkedAVL<>();
```

All of the functions implemented by the BST are also implemented by the AVL Tree, with the addition of `isBalanced`, which returns true iff the tree is balanced (useful when debugging).
``` java
public boolean isBalanced();
```

## Queue
Two queue implementations are provided: a static circular queue and a dynamic linked queue.
The associated constructors are:
``` java
Queue<E> circularQueue = new CircularQueue<>();
```
``` java
Queue<E> linkedQueue = new LinkedQueue<>();
```

Add an element to the back of the queue:
``` java
public void enqueue(K item);
```

Get and remove the element from the front of the queue:
``` java
public K dequeue();
```

Get the element from the front of the queue (without removing it):
``` java
public K peek();
```

Check if the queue is empty:
``` java
public boolean isEmpty();
```

## Priority Queue
Create a new priority queue:
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

## Stack
The provided implementation is a static, array-based stack, with a Capacity value which is passed to the constructor:
``` java
Stack<String> stack = new ArrayBasedStack<>(30);
```
If no value is passed the capacity defaults to 50.

Add an item to the stack:
``` java
public void push(K item);
```
Return an item from the top of the stack and removes that item:
``` java
public K pop();
```
Return an item from the top of the stack (without removing it):
``` java
public K peek();
```

## Ordered List
Creating a new list:
``` java
OrderedList<K, V> orderedList = new OrderedLinkedList<>();
```

Check if the list is empty:
``` java
public boolean isEmpty();
```

Insert an item into the list:
``` java
public void put(K key, V val);
```

Fetch the item with the specified key:
``` java
public V get(K key);
```

Remove the element with the specified search key:
``` java
public void remove(K key);
```

Return the size of the list:
``` java
public int size();
```
