//Q1. Method Overloading
public class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("add(int,int) = " + add(10, 20));
        System.out.println("add(double,double) = " + add(2.5, 5.0));
        System.out.println("add(int,int,int) = " + add(10, 20, 30));
    }
}
//Output:
add(int,int) = 30
add(double,double) = 7.5
add(int,int,int) = 60

  
//Q2. Run-Time Polymorphism
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

class Cow extends Animal {
    void sound() {
        System.out.println("Cow moos");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {

        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Cow()
        };

        for (Animal a : animals) {
            a.sound();
        }
    }
}
//Output:
Dog barks
Cat meows
Cow moos

  
//Q3. Abstract Class Shape
abstract class Shape {
    abstract double area();

    void print() {
        System.out.println("Area = " + area());
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        System.out.println("Circle:");
        Shape c = new Circle(5);
        c.print();

        System.out.println("Rectangle:");
        Shape r = new Rectangle(4, 6);
        r.print();
    }
}
//Output:
Circle:
Area = 78.5
Rectangle:
Area = 24.0

  
//Q4. Interface Playable
interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Guitar is playing");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Piano is playing");
    }
}

public class PlayableDemo {
    public static void main(String[] args) {

        Playable p1 = new Guitar();
        Playable p2 = new Piano();

        p1.play();
        p2.play();
    }
}
//Output:
Guitar is playing
Piano is playing

  
//Q5. Abstract Class with Constructor
abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculatePay();

    void printSlip() {
        System.out.println("Name = " + name);
        System.out.println("Pay = " + calculatePay());
    }
}

class FullTime extends Employee {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class PartTime extends Employee {
    int hours;
    double rate;

    PartTime(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        return hours * rate;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        Employee e1 = new FullTime("Ravi", 30000);
        Employee e2 = new PartTime("Kiran", 20, 200);

        e1.printSlip();
        e2.printSlip();
    }
}
//Output:
Name = Ravi
Pay = 30000.0
Name = Kiran
Pay = 4000.0

  
//Q6. Multiple Interfaces
interface Camera {
    void takePhoto();
}

interface GPS {
    void getLocation();
}

class SmartPhone implements Camera, GPS {

    public void takePhoto() {
        System.out.println("Photo taken");
    }

    public void getLocation() {
        System.out.println("Location: Bengaluru");
    }
}

public class SmartPhoneDemo {
    public static void main(String[] args) {

        SmartPhone phone = new SmartPhone();

        Camera c = phone;
        GPS g = phone;

        c.takePhoto();
        g.getLocation();
    }
}
//Output:
Photo taken
Location: Bengaluru

  
//Q7. Default and Static Interface Methods
interface Vehicle {

    void wheels();

    default void honk() {
        System.out.println("Vehicle honks");
    }

    static void info() {
        System.out.println("Vehicles are used for transport");
    }
}

class Car implements Vehicle {

    public void wheels() {
        System.out.println("Car has 4 wheels");
    }

    public void honk() {
        System.out.println("Car honks");
    }
}

class Bike implements Vehicle {

    public void wheels() {
        System.out.println("Bike has 2 wheels");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.wheels();
        car.honk();

        bike.wheels();
        bike.honk();

        Vehicle.info();
    }
}
//Output:
Car has 4 wheels
Car honks
Bike has 2 wheels
Vehicle honks
Vehicles are used for transport

  
//Q8. instanceof and Downcasting
class Animal {
}

class Dog extends Animal {
    void fetch() {
        System.out.println("Dog is fetching");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class InstanceDemo {
    public static void main(String[] args) {

        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Dog()
        };

        for (Animal a : animals) {

            if (a instanceof Dog) {
                Dog d = (Dog) a;
                d.fetch();
            } else {
                System.out.println("Cat found");
            }
        }
    }
}
//Output:
Dog is fetching
Cat found
Dog is fetching

  
//Q9. Payment System with Interface
interface Payment {
    double fee(double amount);
    String name();
}

class UPI implements Payment {

    public double fee(double amount) {
        return 0;
    }

    public String name() {
        return "UPI";
    }
}

class Card implements Payment {

    public double fee(double amount) {
        return amount * 0.02;
    }

    public String name() {
        return "Card";
    }
}

class NetBanking implements Payment {

    public double fee(double amount) {
        return 10;
    }

    public String name() {
        return "NetBanking";
    }
}

public class PaymentDemo {

    static void checkout(Payment p, double amount) {
        double fee = p.fee(amount);

        System.out.println(p.name() + " Fee = " + fee);
        System.out.println("Total = " + (amount + fee));
    }

    public static void main(String[] args) {

        checkout(new UPI(), 1000);
        checkout(new Card(), 1000);
        checkout(new NetBanking(), 1000);
    }
}
//Output:
UPI Fee = 0.0
Total = 1000.0
Card Fee = 20.0
Total = 1020.0
NetBanking Fee = 10.0
Total = 1010.0

  
//Q10. Abstraction + Interface
abstract class Notification {
    String recipient;

    Notification(String recipient) {
        this.recipient = recipient;
    }

    abstract void send();
}

interface Schedulable {
    void schedule(String time);
}

class EmailNotification extends Notification implements Schedulable {

    EmailNotification(String recipient) {
        super(recipient);
    }

    void send() {
        System.out.println("Email sent to " + recipient);
    }

    public void schedule(String time) {
        System.out.println("Email scheduled at " + time);
    }
}

class SmsNotification extends Notification {

    SmsNotification(String recipient) {
        super(recipient);
    }

    void send() {
        System.out.println("SMS sent to " + recipient);
    }
}

public class NotificationDemo {
    public static void main(String[] args) {

        EmailNotification email =
            new EmailNotification("ravi@gmail.com");

        email.send();
        email.schedule("10:00 AM");

        SmsNotification sms =
            new SmsNotification("9876543210");

        sms.send();
    }
}
//Output:
Email sent to ravi@gmail.com
Email scheduled at 10:00 AM
SMS sent to 9876543210
