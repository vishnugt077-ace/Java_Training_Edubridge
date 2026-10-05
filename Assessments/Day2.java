//Q1 — Stack Using an Array
class MyStack {
    int[] stack = new int[3];
    int top = -1;

    void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = value;
        System.out.println("Pushed: " + value);
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class Q11 {
    public static void main(String[] args) {
        MyStack s = new MyStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        while (!s.isEmpty()) {
            System.out.println("Popped: " + s.pop());
        }

        s.pop();
    }
}
//Output
Pushed: 10
Pushed: 20
Pushed: 30
Stack Overflow
Popped: 30
Popped: 20
Popped: 10
Stack Underflow

  
//Q2 — Reverse a String Using a Stack
import java.util.ArrayDeque;

public class Q12 {
    public static void main(String[] args) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        String str = "STACK";

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        System.out.println("Stack after pushing: " + stack);

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        System.out.println("Reversed string: " + reversed);
    }
}
//Output
Stack after pushing: [K, C, A, T, S]
Reversed string: KCATS
  
//Q3 — Balanced Brackets
import java.util.ArrayDeque;

public class Q13 {

    static boolean isBalanced(String expr) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : expr.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if ((c == ')' && open != '(') ||
                    (c == ']' && open != '[') ||
                    (c == '}' && open != '{')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(
            "{[()()]} : " + isBalanced("{[()()]}")
        );

        System.out.println(
            "([)] : " + isBalanced("([)]")
        );

        System.out.println(
            "(( : " + isBalanced("((")
        );
    }
}
//Output
{[()()]} : true
([)] : false
(( : false

  
//Q4 — Evaluate a Postfix Expression
import java.util.ArrayDeque;

public class Q14 {

    public static void main(String[] args) {

        String expression = "5 3 + 8 2 - *";

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : expression.split(" ")) {

            if (token.matches("\\d+")) {

                stack.push(Integer.parseInt(token));

            } else {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            }

            System.out.println("Stack: " + stack);
        }

        System.out.println("Final Answer: " + stack.pop());
    }
}
//Output
Stack: [5]
Stack: [3, 5]
Stack: [8]
Stack: [8, 8]
Stack: [2, 8]
Stack: [6, 8]
Stack: [48]
Final Answer: 48

  
//Q5 — Circular Queue Using an Array
Code — Q15.java
class CircularQueue {

    int[] queue = new int[4];

    int front = 0;
    int rear = -1;
    int size = 0;

    void enqueue(int value) {

        if (size == queue.length) {
            System.out.println("Queue Full");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    int dequeue() {

        if (size == 0) {
            System.out.println("Queue Empty");
            return -1;
        }

        int value = queue[front];

        front = (front + 1) % queue.length;
        size--;

        return value;
    }

    void display() {

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            System.out.print(
                queue[(front + i) % queue.length] + " "
            );
        }

        System.out.println();
    }
}

public class Q15 {

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        q.enqueue(5);

        q.dequeue();
        q.dequeue();

        q.enqueue(5);
        q.enqueue(6);

        q.display();
    }
}
//Output
Queue Full
Queue: 3 4 5 6
  
//Q6 — Queue Using Two Stacks
import java.util.ArrayDeque;

class MyQueue {

    ArrayDeque<String> in = new ArrayDeque<>();
    ArrayDeque<String> out = new ArrayDeque<>();

    void enqueue(String value) {
        in.push(value);
    }

    String dequeue() {

        if (out.isEmpty()) {

            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            return "Queue Empty";
        }

        return out.pop();
    }
}

public class Q16 {

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue("D");

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
    }
}
//Output
Dequeued: A
Dequeued: B
Dequeued: C
Dequeued: D

  
//Q7 — Build and Count a Linked List
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    Node head;

    void insertEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void insertFront(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    int count() {

        int count = 0;

        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}

public class Q17 {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);

        list.insertFront(10);

        list.display();

        System.out.println("Node count: " + list.count());
    }
}
//Output
10 -> 20 -> 30 -> 40 -> null
Node count: 4

  
//Q8 — Reverse a Linked List
Code — Q18.java
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q18 {

    static Node reverse(Node head) {

        Node prev = null;
        Node cur = head;

        while (cur != null) {

            Node next = cur.next;

            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }

    static void display(Node head) {

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original:");
        display(head);

        head = reverse(head);

        System.out.println("Reversed:");
        display(head);
    }
}
//Output
Original:
1 -> 2 -> 3 -> 4 -> 5 -> null
Reversed:
5 -> 4 -> 3 -> 2 -> 1 -> null

  
//Q9 — Middle of a Linked List
Code — Q19.java
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q19 {

    static int findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    static Node createList(int[] values) {

        Node head = new Node(values[0]);
        Node temp = head;

        for (int i = 1; i < values.length; i++) {

            temp.next = new Node(values[i]);
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Node list1 =
            createList(new int[]{10, 20, 30, 40, 50});

        Node list2 =
            createList(new int[]{10, 20, 30, 40, 50, 60});

        System.out.println(
            "Middle of 5 nodes: " + findMiddle(list1)
        );

        System.out.println(
            "Middle of 6 nodes: " + findMiddle(list2)
        );
    }
}
//Output
Middle of 5 nodes: 30
Middle of 6 nodes: 40

  
//Q10 — Merge Two Sorted Linked Lists
Code — Q20.java
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q20 {

    static Node merge(Node a, Node b) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {

            if (a.data <= b.data) {

                tail.next = a;
                a = a.next;

            } else {

                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    static void display(Node head) {

        while (head != null) {

            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node a = new Node(1);
        a.next = new Node(4);
        a.next.next = new Node(7);

        Node b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(8);
        b.next.next.next = new Node(9);

        Node result = merge(a, b);

        System.out.println("Merged list:");
        display(result);
    }
}
//Output
Merged list:
1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9 -> null
