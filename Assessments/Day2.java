//Q1 — Skip with continue
public class SkipMultipleOf4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            if (i % 4 == 0)
                continue;

            System.out.print(i + " ");
        }
    }
}
//Output:
1 2 3 5 6 7 9 10 11 13 14 15 17 18 19 21 22 23 25 26 27 29 30

    
//Q2 — Sum of Even Numbers
public class SumEven {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;

        while (i <= 100) {
            if (i % 2 == 0)
                sum = sum + i;

            i++;
        }

        System.out.println("Sum of even numbers = " + sum);
    }
}
//Output:
Sum of even numbers = 2550

    
//Q3 — Multiplication Table
public class MultiplicationTable {
    public static void main(String[] args) {
        int n = 9;

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
//Output:
9 x 1 = 9
9 x 2 = 18
9 x 3 = 27
9 x 4 = 36
9 x 5 = 45
9 x 6 = 54
9 x 7 = 63
9 x 8 = 72
9 x 9 = 81
9 x 10 = 90

    
//Q4 — Count the Digits
public class CountDigits {
    public static void main(String[] args) {
        int n = 45823;
        int original = n;
        int count = 0;

        while (n != 0) {
            n = n / 10;
            count++;
        }

        System.out.println(original + " has " + count + " digits");
    }
}
//Output:
45823 has 5 digits

    
//Q5 — Palindrome Number
public class Palindrome {
    public static void main(String[] args) {
        int[] numbers = {121, 123};

        for (int n : numbers) {
            int original = n;
            int reverse = 0;

            while (n != 0) {
                int digit = n % 10;
                reverse = reverse * 10 + digit;
                n = n / 10;
            }

            if (original == reverse)
                System.out.println(original + " is a Palindrome");
            else
                System.out.println(original + " is Not a Palindrome");
        }
    }
}
//Output:
121 is a Palindrome
123 is Not a Palindrome

    
//Q6 — Fibonacci Series
public class Fibonacci {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        for (int i = 1; i <= 10; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
    }
}
//Output:
0 1 1 2 3 5 8 13 21 34

    
//Q7 — Star Triangle
public class StarTriangle {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
//Output:
* 
* * 
* * * 
* * * * 
* * * * *

    
//Q8 — Number Pattern
public class NumberPattern {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            for (int j = 5; j >= i; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
//Output:
5
5 4
5 4 3
5 4 3 2
5 4 3 2 1

    
//Q9 — Prime Numbers Using a Method
public class PrimeNumbers {

    static boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }
}
//Output:
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47

    
//Q10 — Overloaded Area Methods
public class Area {

    static int area(int side) {
        return side * side;
    }

    static int area(int l, int w) {
        return l * w;
    }

    static double area(double r) {
        return 3.14 * r * r;
    }

    public static void main(String[] args) {
        System.out.println("Square area = " + area(4));
        System.out.println("Rectangle area = " + area(4, 6));
        System.out.println("Circle area = " + area(2.0));
    }
}
//Output:
Square area = 16
Rectangle area = 24
Circle area = 12.56
