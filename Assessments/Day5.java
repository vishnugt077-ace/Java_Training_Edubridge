//Q1 — Encapsulated Product
public class Product {
    private String name;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price");
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Product p = new Product();

        p.setName("Laptop");
        p.setPrice(50000);

        System.out.println("Name = " + p.getName());
        System.out.println("Price = " + p.getPrice());

        p.setPrice(-1000);
    }
}
//Output:
Name = Laptop
Price = 50000.0
Invalid price

  
//Q2 — Wallet with Controlled Access
public class Wallet {
    private double balance;

    void addMoney(double amount) {
        if (amount > 0)
            balance += amount;
    }

    void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Payment successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Wallet w = new Wallet();

        w.addMoney(1000);
        System.out.println("Balance = " + w.getBalance());

        w.pay(300);
        System.out.println("Balance = " + w.getBalance());

        w.pay(800);
        System.out.println("Balance = " + w.getBalance());
    }
}
//Output:
Balance = 1000.0
Payment successful
Balance = 700.0
Insufficient balance
Balance = 700.0

  
//Q3 — Read-only Roll Number
public class Student {
    private final int rollNumber;
    private String name;

    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    int getRollNumber() {
        return rollNumber;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Ravi");

        System.out.println("Roll Number = " + s.getRollNumber());
        System.out.println("Name = " + s.getName());

        s.setName("Kiran");

        System.out.println("Updated Name = " + s.getName());
    }
}
//Output:
Roll Number = 101
Name = Ravi
Updated Name = Kiran

  
//Q4 — Contact with Validation
public class Contact {
    private String name;
    private String email;
    private String phone;

    void setName(String name) {
        this.name = name;
    }

    void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email");
        }
    }

    void setPhone(String phone) {
        if (phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    void display() {
        System.out.println("Name = " + name);
        System.out.println("Email = " + email);
        System.out.println("Phone = " + phone);
    }

    public static void main(String[] args) {
        Contact c = new Contact();

        c.setName("Ravi");
        c.setEmail("ravi@gmail.com");
        c.setPhone("9876543210");

        c.display();

        c.setEmail("invalidemail");
        c.setPhone("12345");
    }
}
//Output:
Name = Ravi
Email = ravi@gmail.com
Phone = 9876543210
Invalid email
Invalid phone number

  
//Q5 — Single Inheritance
class Vehicle {
    String brand = "Toyota";

    void start() {
        System.out.println("Vehicle started");
    }
}

public class Car extends Vehicle {
    int seats = 5;

    void openSunroof() {
        System.out.println("Sunroof opened");
    }

    public static void main(String[] args) {
        Car c = new Car();

        System.out.println("Brand = " + c.brand);
        System.out.println("Seats = " + c.seats);

        c.start();
        c.openSunroof();
    }
}
//Output:
Brand = Toyota
Seats = 5
Vehicle started
Sunroof opened

  
//Q6 — Multilevel Inheritance
class Person {
    String name = "Ravi";
}

class Employee extends Person {
    double salary = 50000;
}

public class Manager extends Employee {
    int teamSize = 10;

    public static void main(String[] args) {
        Manager m = new Manager();

        System.out.println("Name = " + m.name);
        System.out.println("Salary = " + m.salary);
        System.out.println("Team Size = " + m.teamSize);
    }
}
//Output:
Name = Ravi
Salary = 50000.0
Team Size = 10

  
//Q7 — Constructor Chaining with super
class Animal {
    Animal(String name) {
        System.out.println("Animal constructor");
        System.out.println("Name = " + name);
    }
}

public class Dog extends Animal {
    Dog(String name, String breed) {
        super(name);
        System.out.println("Dog constructor");
        System.out.println("Breed = " + breed);
    }

    public static void main(String[] args) {
        Dog d = new Dog("Tommy", "Labrador");
    }
}
//Output:
Animal constructor
Name = Tommy
Dog constructor
Breed = Labrador

  
//Q8 — Overriding with super.method()
class Shape {
    void describe() {
        System.out.println("This is a shape");
    }
}

public class Square extends Shape {
    int side;

    Square(int side) {
        this.side = side;
    }

    @Override
    void describe() {
        super.describe();
        System.out.println("This is a square");
        System.out.println("Side = " + side);
    }

    public static void main(String[] args) {
        Square s = new Square(5);
        s.describe();
    }
}
//Output:
This is a shape
This is a square
Side = 5

  
//Q9 — Hierarchical Inheritance: Accounts
class Account {
    String holder;
    protected double balance;

    Account(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    void display() {
        System.out.println("Holder = " + holder);
        System.out.println("Balance = " + balance);
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String holder, double balance) {
        super(holder, balance);
    }

    void addInterest(double rate) {
        balance += balance * rate / 100;
    }
}

class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    CurrentAccount(String holder, double balance) {
        super(holder, balance);
    }

    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Withdrawal denied");
        }
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount("Ravi", 10000);
        s.addInterest(5);
        s.display();

        System.out.println();

        CurrentAccount c = new CurrentAccount("Kiran", 3000);
        c.withdraw(7000);
        c.display();
    }
}
//Output:
Holder = Ravi
Balance = 10500.0

Withdrawal successful
Holder = Kiran
Balance = -4000.0

  
//Q10 — Encapsulation + Inheritance
class Employee {
    private double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

public class Manager extends Employee {
    private double bonus;

    Manager(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    double totalPay() {
        return getSalary() + bonus;
    }

    public static void main(String[] args) {
        Manager m = new Manager(50000, 10000);

        System.out.println("Salary = " + m.getSalary());
        System.out.println("Bonus = " + m.bonus);
        System.out.println("Total Pay = " + m.totalPay());
    }
}
//Output:
Salary = 50000.0
Bonus = 10000.0
Total Pay = 60000.0
