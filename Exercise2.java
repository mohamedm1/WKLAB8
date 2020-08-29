


class Node {

int key;

Node next;


public Node(int key) {

this.key = key;

this.next = null;

}

}

public class LinkedQueue {

Node front, rear;

public int size;

public LinkedQueue() {

this.front = null;

this.rear = null;

this.size = 0;

}



void enqueue(int key) {



Node node = new Node(key);



if (this.rear == null) {

this.front = node;

this.rear = node;

this.size++;

return;

}

System.out.println("Enqueued item in LinkedQueue is " + key);

this.rear.next = node;

this.rear = node;

this.size++;

}



Node dequeue() {

d

if (this.front == null)

throw new NullPointerException("LinkedQueue is empty. More elements cannot be deleted!!!");



Node node = this.front;

System.out.println("Dequeued item from LinkedQueue is " + this.front.key);

this.front = this.front.next;

if (this.front == null)

this.rear = null;

this.size--;

return node;

}

// Get Size

public int getSize() {

return this.size;

}

public void removeMiddle() {

Node curr = front;

int length = 0;

Node middle = front;

while (curr.next != null) {

length++;

if (length % 2 == 0) {

middle = middle.next;

}

curr = curr.next;

}

if (length % 2 == 1) {

middle = middle.next;

}

System.out.println("middle element of LinkedQueue : " + middle.key);

}

}



public class ArrayQueue {

  

private int qCapacity;

int qArr[];

int front = 0;

int rear = -1;

int size = 0;

public ArrayQueue(int size){

this.qCapacity = size;

this.qArr = new int[this.qCapacity];

}


public void enqueue(int element) {

if (isFull()) {

throw new IndexOutOfBoundsException("!! Cannot add more elements!!!");

} else {

rear++;

if(rear == qCapacity-1){

rear = 0;

}

  

qArr[rear] = element;

this.size++;

}

System.out.println("Enqueued item is "+qArr[rear]);

  

System.out.println("Queue Capacity:"+qCapacity+" Current Size:"+size);

  

}



public void dequeue() {

if (isEmpty()) {

throw new NullPointerException("Queue is empty. More elements cannot be deleted!!!");

} else {

System.out.println("Dequeued item is "+qArr[front]);

front++;

if(front == qCapacity-1)

front = 0;

this.size--;

System.out.println("Queue Capacity:"+qCapacity+" Current Size:"+size);

}

}



public boolean isFull(){

boolean status = false;

if (size == qCapacity){

status = true;

}

return status;

}



public boolean isEmpty(){

boolean status = false;

if (size == 0){

status = true;

}

return status;

}

}



public class QueueHelper {

public static void main(String[] args) {

System.out.println("=== Linked Queue ====");

LinkedQueue q = new LinkedQueue();

q.enqueue(10);

q.enqueue(20);

q.enqueue(30);

q.enqueue(40);

q.enqueue(50);

q.enqueue(60);

q.removeMiddle();

q.dequeue();

q.dequeue();

System.out.println("== Array Queue ===");

ArrayQueue queue = new ArrayQueue(4);

queue.enqueue(10);

queue.dequeue();

queue.enqueue(20);

queue.enqueue(30);

queue.enqueue(40);

queue.dequeue();

queue.dequeue();

queue.enqueue(50);

queue.dequeue();

queue.enqueue(60);

queue.enqueue(70);

queue.enqueue(80);

queue.enqueue(90);

}

}
