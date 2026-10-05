//Q1 — AboutMe
public class AboutMe {
    public static void main(String[] args) {
        System.out.println("Name : Ravi Kumar");
        System.out.println("Course : Java Programming");
        System.out.println("College : ABC Engineering College");
    }
}
//Output:
Name : Ravi Kumar
Course : Java Programming
College : ABC Engineering College

    
//Q2 — DataTypes.java
public class DataTypes {
    public static void main(String[] args) {
        byte b = 10;
        short s = 200;
        int i = 1000;
        long l = 100000L;
        float f = 10.5f;
        double d = 25.75;
        char c = 'A';
        boolean bool = true;

        System.out.println("byte : " + b);
        System.out.println("short : " + s);
        System.out.println("int : " + i);
        System.out.println("long : " + l);
        System.out.println("float : " + f);
        System.out.println("double : " + d);
        System.out.println("char : " + c);
        System.out.println("boolean : " + bool);
    }
}
//Output:
byte : 10
short : 200
int : 1000
long : 100000
float : 10.5
double : 25.75
char : A
boolean : true

    
//Q3 — SwapNumbers
public class SwapNumbers {
    public static void main(String[] args) {
        int a = 15;
        int b = 40;

        System.out.println("Before: a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After : a = " + a + ", b = " + b);
    }
}
//Output:
Before: a = 15, b = 40
After : a = 40, b = 15

    
//Q4 — SimpleInterest
public class SimpleInterest {
    public static void main(String[] args) {
        double P = 10000;
        double R = 7.5;
        double T = 3;

        double SI = (P * R * T) / 100;
        double totalAmount = P + SI;

        System.out.println("Simple Interest = " + SI);
        System.out.println("Total Amount = " + totalAmount);
    }
}
//Output:
Simple Interest = 2250.0
Total Amount = 12250.0

    
//Q5 — EvenOdd
public class EvenOdd {
    public static void main(String[] args) {
        int a = 24;
        int b = 37;

        if (a % 2 == 0)
            System.out.println(a + " is Even");
        else
            System.out.println(a + " is Odd");

        if (b % 2 == 0)
            System.out.println(b + " is Even");
        else
            System.out.println(b + " is Odd");
    }
}
//Output:
24 is Even
37 is Odd

    
//Q6 — LargestOfThree
public class LargestOfThree {
    public static void main(String[] args) {
        int a = 45;
        int b = 89;
        int c = 23;

        if (a >= b && a >= c)
            System.out.println("Largest number is " + a);
        else if (b >= a && b >= c)
            System.out.println("Largest number is " + b);
        else
            System.out.println("Largest number is " + c);
    }
}
//Output:
Largest number is 89

    
//Q7 — GradeCalculator
public class GradeCalculator {
    public static void main(String[] args) {
        int[] marks = {92, 78, 55, 30};

        for (int mark : marks) {
            if (mark >= 90)
                System.out.println(mark + " → Grade A");
            else if (mark >= 75)
                System.out.println(mark + " → Grade B");
            else if (mark >= 50)
                System.out.println(mark + " → Grade C");
            else
                System.out.println(mark + " → Grade F");
        }
    }
}
//Output:
92 → Grade A
78 → Grade B
55 → Grade C
30 → Grade F

    
//Q8 — DayOfWeek
public class DayOfWeek {
    public static void main(String[] args) {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Day 1 is Monday");
                break;
            case 2:
                System.out.println("Day 2 is Tuesday");
                break;
            case 3:
                System.out.println("Day 3 is Wednesday");
                break;
            case 4:
                System.out.println("Day 4 is Thursday");
                break;
            case 5:
                System.out.println("Day 5 is Friday");
                break;
            case 6:
                System.out.println("Day 6 is Saturday");
                break;
            case 7:
                System.out.println("Day 7 is Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
//Output:
Day 3 is Wednesday

    
//Q9 — LeapYear
public class LeapYear {
    public static void main(String[] args) {
        int[] years = {2024, 1900, 2000};

        for (int y : years) {
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
                System.out.println(y + " is a Leap Year");
            else
                System.out.println(y + " is Not a Leap Year");
        }
    }
}
//Output:
2024 is a Leap Year
1900 is Not a Leap Year
2000 is a Leap Year

    
//Q10 — Theory
(a) Output
JDK → JRE → JVM
(b) Output
javac Hello.java → Hello.class
java Hello → JVM executes the bytecode
(c) Output
1. Java uses automatic garbage collection; C++ supports manual memory management.
2. Java programs run on JVM; C++ programs normally compile to native machine code.
3. Java does not support multiple inheritance through classes; C++ supports it.
(d) Output
Java is platform independent because Java source code is compiled into bytecode.
The bytecode can run on any operating system that has a compatible JVM.
Therefore, Java follows the principle "Write Once, Run Anywhere".
