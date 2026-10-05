//Q1 — Book Class
public class Book {
    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
        System.out.println();
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "Java Programming";
        b1.author = "James Gosling";
        b1.price = 500;

        Book b2 = new Book();
        b2.title = "Data Structures";
        b2.author = "Robert Lafore";
        b2.price = 600;

        b1.display();
        b2.display();
    }
}
//Output:
Title : Java Programming
Author : James Gosling
Price : 500.0

Title : Data Structures
Author : Robert Lafore
Price : 600.0

  
//Q2 — Circle with Constructor
public class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }

    double circumference() {
        return 2 * 3.14 * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(7);

        System.out.printf("Area = %.2f%n", c.area());
        System.out.printf("Circumference = %.2f%n", c.circumference());
    }
}
//Output:
Area = 153.86
Circumference = 43.96

  
//Q3 — Default and Parameterized Constructors
public class Student {
    String name;
    int marks;

    Student() {
        name = "Unknown";
        marks = 0;
    }

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Marks : " + marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Ravi", 85);

        s1.display();
        System.out.println();
        s2.display();
    }
}
//Output:
Name : Unknown
Marks : 0

Name : Ravi
Marks : 85

  
//Q4 — Counter Object
public class Counter {
    private int count = 0;

    void increment() {
        count++;
    }

    void decrement() {
        if (count > 0)
            count--;
    }

    void reset() {
        count = 0;
    }

    int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter c = new Counter();

        c.increment();
        c.increment();
        c.increment();

        System.out.println("Count = " + c.getCount());

        c.decrement();
        System.out.println("After decrement = " + c.getCount());

        c.reset();
        System.out.println("After reset = " + c.getCount());
    }
}
//Output:
Count = 3
After decrement = 2
After reset = 0

  
//Q5 — Time Class with this() Chaining
public class Time {
    int h, m, s;

    Time(int h) {
        this(h, 0, 0);
    }

    Time(int h, int m) {
        this(h, m, 0);
    }

    Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static void main(String[] args) {
        Time t1 = new Time(10);
        Time t2 = new Time(10, 30);
        Time t3 = new Time(10, 30, 45);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
//Output:
10:00:00
10:30:00
10:30:45

  
//Q6 — Auto-generated IDs
public class Ticket {
    static int counter = 101;

    String id;
    String passenger;

    Ticket(String passenger) {
        id = "T" + counter++;
        this.passenger = passenger;
    }

    void display() {
        System.out.println(id + " - " + passenger);
    }

    public static void main(String[] args) {
        Ticket t1 = new Ticket("Ravi");
        Ticket t2 = new Ticket("Kiran");
        Ticket t3 = new Ticket("Arun");

        t1.display();
        t2.display();
        t3.display();
    }
}
//Output:
T101 - Ravi
T102 - Kiran
T103 - Arun

  
//Q7 — Array of Employee Objects
public class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee[] e = {
            new Employee("Ravi", 30000),
            new Employee("Kiran", 45000),
            new Employee("Arun", 35000),
            new Employee("Vijay", 50000)
        };

        Employee highest = e[0];
        double total = 0;

        for (Employee emp : e) {
            total += emp.salary;

            if (emp.salary > highest.salary)
                highest = emp;
        }

        System.out.println("Highest-paid employee = " + highest.name);
        System.out.println("Salary = " + highest.salary);
        System.out.println("Average salary = " + (total / e.length));
    }
}
//Output:
Highest-paid employee = Vijay
Salary = 50000.0
Average salary = 40000.0

  
//Q8 — Objects as Parameters and Return Values
public class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    Point midpoint(Point other) {
        return new Point((x + other.x) / 2,
                         (y + other.y) / 2);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 6);

        System.out.println("Distance = " + p1.distanceTo(p2));

        Point mid = p1.midpoint(p2);
        System.out.println("Midpoint = (" + mid.x + ", " + mid.y + ")");
    }
}
//Output:
Distance = 7.211102550927978
Midpoint = (2.0, 3.0)

  
//Q9 — Fraction Class
public class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        int g = gcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    Fraction add(Fraction f) {
        int n = numerator * f.denominator
              + f.numerator * denominator;

        int d = denominator * f.denominator;

        return new Fraction(n, d);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.add(f2);

        System.out.println("Fraction 1 = " + f1);
        System.out.println("Fraction 2 = " + f2);
        System.out.println("Sum = " + result);
    }
}
//Output:
Fraction 1 = 1/2
Fraction 2 = 1/3
Sum = 5/6

  
//Q10 — Shopping Cart
public class Cart {
    Item[] items = new Item[10];
    int count = 0;

    void addItem(Item item) {
        if (count < 10) {
            items[count++] = item;
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += items[i].price * items[i].qty;
        }

        return total;
    }

    void printBill() {
        System.out.println("----- BILL -----");

        for (int i = 0; i < count; i++) {
            System.out.println(items[i].name + " x " +
                               items[i].qty + " = " +
                               (items[i].price * items[i].qty));
        }

        System.out.println("Total = " + getTotal());
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addItem(new Item("Pen", 10, 2));
        cart.addItem(new Item("Book", 50, 3));
        cart.addItem(new Item("Bag", 500, 1));

        cart.printBill();
    }
}

class Item {
    String name;
    double price;
    int qty;

    Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
//Output:
----- BILL -----
Pen x 2 = 20.0
Book x 3 = 150.0
Bag x 1 = 500.0
Total = 670.0
