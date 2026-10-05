//Q1 — Largest of Three Using a Method
public class Largest {
    static int max(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;
    }

    public static void main(String[] args) {
        System.out.println("Largest = " + max(12, 45, 30));
    }
}
//Output:
Largest = 45

  
//Q2 — Pass by Value Experiment
public class PassByValue {

    static void changeNum(int x) {
        x = 100;
    }

    static void changeArr(int[] a) {
        a[0] = 100;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] arr = {5};

        System.out.println("num before: " + num);
        changeNum(num);
        System.out.println("num after: " + num);

        System.out.println("arr[0] before: " + arr[0]);
        changeArr(arr);
        System.out.println("arr[0] after: " + arr[0]);
    }
}
//Output:
num before: 5
num after: 5
arr[0] before: 5
arr[0] after: 100

  
//Q3 — Average with Varargs
public class Average {

    static double average(double... nums) {
        double sum = 0;

        for (double n : nums) {
            sum += n;
        }

        return sum / nums.length;
    }

    public static void main(String[] args) {
        System.out.println("Average 1 = " + average(4, 8, 6));
        System.out.println("Average 2 = " + average(10, 20));
    }
}
//Output:
Average 1 = 6.0
Average 2 = 15.0

  
//Q4 — Static vs Instance
public class Rectangle {
    int length;
    int width;

    int area() {
        return length * width;
    }

    static boolean isSquare(int l, int w) {
        return l == w;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();

        r.length = 10;
        r.width = 5;

        System.out.println("Area = " + r.area());
        System.out.println("Is square? " + Rectangle.isSquare(10, 5));
    }
}
//Output:
Area = 50
Is square? false

  
//Q5 — Recursive Sum
public class RecursiveSum {

    static int sum(int n) {
        if (n == 0)       // Base case
            return 0;

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Sum of 1 to 10 = " + sum(10));
    }
}
//Output:
Sum of 1 to 10 = 55

  
//Q6 — Factorial Table
public class FactorialTable {

    static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
}
//Output:
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
6! = 720

  
//Q7 — Recursive Power
public class RecursivePower {

    static int power(int base, int exp) {
        if (exp == 0)
            return 1;

        return base * power(base, exp - 1);
    }

    public static void main(String[] args) {
        System.out.println("3^4 = " + power(3, 4));
        System.out.println("2^10 = " + power(2, 10));
    }
}
//Output:
3^4 = 81
2^10 = 1024

  
//Q8 — Count Digits Recursively
public class CountDigitsRecursive {

    static int countDigits(int n) {
        if (n < 10)
            return 1;

        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 908172;

        System.out.println(n + " has " + countDigits(n) + " digits");
    }
}
//Output:
908172 has 6 digits

  
//Q9 — Palindrome String Using Recursion
public class PalindromeString {

    static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("madam → " + isPalindrome("madam"));
        System.out.println("java → " + isPalindrome("java"));
    }
}
//Output:
madam → true
java → false

  
//Q10 — Recursion Trace
(a) fib(4) recursion tree
fib(4)
├── fib(3)
│   ├── fib(2)
│   │   ├── fib(1)
│   │   └── fib(0)
│   └── fib(1)
└── fib(2)
    ├── fib(1)
    └── fib(0)
Total calls = 9
(b) factorial(3) call stack
factorial(3)
    ↓
factorial(2)
    ↓
factorial(1)
    ↓
factorial(0)
Pushing:
factorial(3)
factorial(2)
factorial(1)
factorial(0)
Popping:
factorial(0) → 1
factorial(1) → 1
factorial(2) → 2
factorial(3) → 6
Final output:
factorial(3) = 6
(c) Removing the base case
factorial(3)
   ↓
factorial(2)
   ↓
factorial(1)
   ↓
factorial(0)
   ↓
factorial(-1)
   ↓
...
