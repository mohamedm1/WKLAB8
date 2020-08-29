import java.util.NoSuchElementException;

public class LinkedQueue<E> {

// Objects of the class Elem are used to store the elements of the

// list.

  

private static class Elem<T> {

private final T value;

private Elem<T> previous;

private Elem<T> next;

private Elem(T value, Elem<T> previous, Elem<T> next) {

this.value = value;

this.previous = previous;

this.next = next;

}

}

  

private final Elem<E> head;

private int size;

  

public LinkedQueue() {

head = new Elem<E>(null, null, null);

head.next = head;

head.previous = head;

size = 0;

}

/** Returns the size of the list.

   *

   * @return the size of the list

   */

  

public int size() {

return size;

}

public boolean isEmpty() {

return head==null;

}

  

public E first(){

if(head ==null)

   return null;

return head.value;

}

  

private void addAfter(Elem<E> before, E obj) {

Elem<E> after = before.next;

before.next = new Elem<E>(obj, before, after);

after.previous = before.next;

size++;

}

/** Inserts the specified element at the beginning of this list.

   *

   * @param obj the object to be added

   */

public void addFirst(E obj) {

if (obj == null) {

throw new NullPointerException();

}

  

addAfter(head, obj);

  

}

/** Inserts the specified element at the end of this list.

   *

   * @param obj the object to be added

   */

public void enqueue(E obj) {

  

if (obj == null) {

throw new NullPointerException();

}

  

addAfter(head.previous, obj);

}

  

// Helper method. Removes the specified node.

private void remove(Elem<E> current) {

Elem<E> before = current.previous, after = current.next;

before.next = after;

after.previous = before;

size--;

}

/** Removes the first element from this list.

   */

public void dequeue() {

if (size == 0) {

throw new NoSuchElementException();

}

remove(head.next);

}

  

/** Returns a String representation of this list.

   *

   * @return a String representation of this list

   */

public String toString() {

StringBuffer str = new StringBuffer("{");

Elem<E> p = head.next;

while (p != head) {

str.append(p.value);

if (p.next != head) {

str.append(",");

}

p = p.next;

}

str.append("}");

return str.toString();

}

  

public static void main(String args[]){

   LinkedQueue<Integer> d = new LinkedQueue<Integer>();

   d.enqueue(4);

   d.enqueue(14);

   d.enqueue(104);

   d.enqueue(140);

      

   System.out.println("Queue elements");

   System.out.println(d.toString());

   d.dequeue();

   System.out.println("After removing first:");

   System.out.println(d.toString());

      

}
