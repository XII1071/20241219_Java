package p07Collection;

import java.util.*;

public class Ex04StackQueue {
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(0);
    stack.push(1);
    stack.push(new Object());
    System.out.println(stack);
    System.out.println(stack.size());
    System.out.println(stack.contains(1));
    stack.pop();
    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println(stack);
    System.out.println(stack.empty());

    Queue queue = new LinkedList();
    queue.offer(1);
    queue.offer("a");
    queue.offer(true);
    System.out.println(queue);
    queue.poll();
    System.out.println(queue);
    System.out.println(queue.peek());
    System.out.println(queue);

    Vector v = new Vector();
    v.add(0);
    v.add(1);
    v.add(2);
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    e = v.elements();
    for (int i = 0; e.hasMoreElements(); i++) {
      if (i != 0) System.out.print(",");
      System.out.print(e.nextElement());
    }
    Iterator it = v.iterator();
    for (int i = 0; it.hasNext(); i++) {
      if (i != 0) System.out.print(",");
      System.out.print(it.next());
    }
    it = v.iterator();
  }
}