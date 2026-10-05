//Q1. Stack Using an Array
public class Q11Stack {

    static class MyStack {
        int[] stack = new int[3];
        int top = -1;

        void push(int value) {
            if (top == stack.length - 1) {
                System.out.println("Stack Overflow");
            } else {
                stack[++top] = value;
            }
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
                System.out.println("Stack is empty");
                return -1;
            }
            return stack[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {

        MyStack s = new MyStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Peek = " + s.peek());

        while (!s.isEmpty()) {
            System.out.println("Popped: " + s.pop());
        }

        s.pop();
    }
}
//Output:
Stack Overflow
Peek = 30
Popped: 30
Popped: 20
Popped: 10
Stack Underflow

  
//Q2. Reverse a String Using a Stack
import java.util.ArrayDeque;

public class Q12ReverseStack {

    public static void main(String[] args) {

        String str = "STACK";

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        System.out.println("Stack after pushing: " + stack);

        String reverse = "";

        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }

        System.out.println("Reversed string: " + reverse);
    }
}
//Output:
Stack after pushing: [K, C, A, T, S]
Reversed string: KCATS

  
//Q3. Balanced Brackets
import java.util.ArrayDeque;

public class Q13BalancedBrackets {

    static boolean isBalanced(String expr) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : expr.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty())
                    return false;

                char open = stack.pop();

                if ((ch == ')' && open != '(') ||
                    (ch == ']' && open != '[') ||
                    (ch == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("{[()()]} : " +
                isBalanced("{[()()]}"));

        System.out.println("([)] : " +
                isBalanced("([)]"));

        System.out.println("(( : " +
                isBalanced("(("));
    }
}
//Output:
{[()()]} : true
([)] : false
(( : false

  
//Q4. Evaluate a Postfix Expression
import java.util.ArrayDeque;

public class Q14Postfix {

    public static void main(String[] args) {

        String expression = "5 3 + 8 2 - *";

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : expression.split(" ")) {

            if (token.matches("\\d+")) {

                stack.push(Integer.parseInt(token));
                System.out.println("After " + token + ": " + stack);

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
                System.out.println("After " + token + ": " + stack);
            }
        }

        System.out.println("Final Answer = " + stack.pop());
    }
}
//Output:
After 5: [5]
After 3: [3, 5]
After +: [8]
After 8: [8, 8]
After 2: [2, 8, 8]
After -: [6, 8]
After *: [48]
Final Answer = 48

  
//Q5. Circular Queue Using an Array
public class Q15CircularQueue {

    static class CircularQueue {

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
                System.out.print(queue[(front + i) % queue.length] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        q.enqueue(5);

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue(5);
        q.enqueue(6);

        q.display();
    }
}
//Output:
Queue Full
Dequeued: 1
Dequeued: 2
Queue: 3 4 5 6

  
//Q6. Queue Using Two Stacks
import java.util.ArrayDeque;

public class Q16QueueTwoStacks {

    static class MyQueue {

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

            return out.pop();
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        System.out.println("Dequeue: " + q.dequeue());

        q.enqueue("D");

        while (!q.in.isEmpty() || !q.out.isEmpty()) {
            System.out.println("Dequeue: " + q.dequeue());
        }
    }
}
//Output:
Dequeue: A
Dequeue: B
Dequeue: C
Dequeue: D

  
//Q7. Build and Count a Linked List
public class Q17LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
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

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);
        list.insertFront(10);

        list.display();

        System.out.println("Node count = " + list.count());
    }
}
//Output:
10 -> 20 -> 30 -> 40 -> null
Node count = 4

  
//Q8. Reverse a Linked List
public class Q18ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

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

        System.out.println("Before:");
        display(head);

        head = reverse(head);

        System.out.println("After:");
        display(head);
    }
}
//Output:
Before:
1 -> 2 -> 3 -> 4 -> 5 -> null
After:
5 -> 4 -> 3 -> 2 -> 1 -> null

  
//Q9. Middle of a Linked List
public class Q19MiddleLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

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

        Node list1 = createList(new int[]{10, 20, 30, 40, 50});
        Node list2 = createList(new int[]{10, 20, 30, 40, 50, 60});

        System.out.println("Middle of 5 nodes = " +
                findMiddle(list1));

        System.out.println("Middle of 6 nodes = " +
                findMiddle(list2));
    }
}
//Output:
Middle of 5 nodes = 30
Middle of 6 nodes = 40

  
//Q10. Merge Two Sorted Linked Lists
public class Q20MergeLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

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

        if (a != null)
            tail.next = a;
        else
            tail.next = b;

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
//Output:
Merged list:
1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9 -> null
