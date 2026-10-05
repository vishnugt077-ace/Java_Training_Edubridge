//Q1. Array Statistics
public class Q1ArrayStatistics {
    public static void main(String[] args) {

        int[] marks = {78, 92, 65, 88, 71, 95, 59};

        int sum = 0;
        int max = marks[0];
        int min = marks[0];

        for (int mark : marks) {
            sum += mark;

            if (mark > max)
                max = mark;

            if (mark < min)
                min = mark;
        }

        double average = (double) sum / marks.length;

        System.out.printf("Sum = %d%n", sum);
        System.out.printf("Average = %.2f%n", average);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }
}
//Output:
Sum = 548
Average = 78.29
Max = 95
Min = 59

  
//Q2. Reverse an Array In Place
import java.util.Arrays;

public class Q2ReverseArray {

    static void reverse(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50};

        System.out.println("Before: " + Arrays.toString(a));

        reverse(a);

        System.out.println("After:  " + Arrays.toString(a));
    }
}
//Output:
Before: [10, 20, 30, 40, 50]
After:  [50, 40, 30, 20, 10]

  
//Q3. Linear Search
public class Q3LinearSearch {

    static int search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {4, 8, 15, 16, 23, 42};

        int key1 = 23;
        int key2 = 7;

        int result1 = search(a, key1);
        int result2 = search(a, key2);

        if (result1 != -1)
            System.out.println(key1 + " found at index " + result1);
        else
            System.out.println(key1 + " not found");

        if (result2 != -1)
            System.out.println(key2 + " found at index " + result2);
        else
            System.out.println(key2 + " not found");
    }
}
//Output:
23 found at index 4
7 not found

  
//Q4. Second Largest Element
public class Q4SecondLargest {

    public static void main(String[] args) {

        int[] a = {12, 35, 1, 10, 35, 34};

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int x : a) {

            if (x > first) {
                second = first;
                first = x;
            } 
            else if (x > second && x != first) {
                second = x;
            }
        }

        System.out.println("Second largest = " + second);
    }
}
//Output:
Second largest = 34

  
//Q5. Move Zeros to the End
import java.util.Arrays;

public class Q5MoveZeros {

    static void moveZeros(int[] a) {

        int index = 0;

        for (int x : a) {
            if (x != 0) {
                a[index] = x;
                index++;
            }
        }

        while (index < a.length) {
            a[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        int[] a = {0, 5, 0, 3, 12, 0, 7};

        System.out.println("Before: " + Arrays.toString(a));

        moveZeros(a);

        System.out.println("After:  " + Arrays.toString(a));
    }
}
//Output:
Before: [0, 5, 0, 3, 12, 0, 7]
After:  [5, 3, 12, 7, 0, 0, 0]

  
//Q6. 2D Array — Row and Column Totals
public class Q6MatrixTotals {

    public static void main(String[] args) {

        int[][] marks = {
            {80, 75, 90},
            {60, 85, 70},
            {95, 65, 88}
        };

        System.out.println("Matrix and Row Totals:");

        for (int i = 0; i < marks.length; i++) {

            int rowTotal = 0;

            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
                rowTotal += marks[i][j];
            }

            System.out.println(" | Total = " + rowTotal);
        }

        System.out.println("\nColumn Totals:");

        for (int j = 0; j < 3; j++) {

            int columnTotal = 0;

            for (int i = 0; i < 3; i++) {
                columnTotal += marks[i][j];
            }

            System.out.println("Subject " + (j + 1) + " = " + columnTotal);
        }
    }
}
//Output:
Matrix and Row Totals:
80 75 90  | Total = 245
60 85 70  | Total = 215
95 65 88  | Total = 248

Column Totals:
Subject 1 = 235
Subject 2 = 225
Subject 3 = 248

  
//Q7. Reverse String and Check Palindrome
public class Q7Palindrome {

    static void check(String word) {

        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        System.out.println("Original: " + word);
        System.out.println("Reverse: " + reverse);

        if (word.equalsIgnoreCase(reverse))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");

        System.out.println();
    }

    public static void main(String[] args) {

        check("Madam");
        check("Java");
    }
}
//Output:
Original: Madam
Reverse: madaM
Palindrome

Original: Java
Reverse: avaJ
Not a palindrome

  
//Q8. Count Vowels, Consonants, Digits and Spaces
public class Q8CharacterCount {

    public static void main(String[] args) {

        String str = "Java 21 is Awesome";

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            }
            else if (Character.isWhitespace(ch)) {
                spaces++;
            }
            else if (Character.isLetter(ch)) {

                char c = Character.toLowerCase(ch);

                if (c == 'a' || c == 'e' || c == 'i' ||
                    c == 'o' || c == 'u') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
        System.out.println("Digits = " + digits);
        System.out.println("Spaces = " + spaces);
    }
}
//Output:
Vowels = 7
Consonants = 6
Digits = 2
Spaces = 3

  
//Q9. Character Frequency
public class Q9CharacterFrequency {

    public static void main(String[] args) {

        String str = "programming";

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            count[ch - 'a']++;
        }

        System.out.println("Character Frequency:");

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                System.out.println((char)('a' + i) + " = " + count[i]);
            }
        }

        int max = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > max)
                max = count[i];
        }

        System.out.println("\nMost frequent letter(s):");

        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                System.out.println((char)('a' + i) + " = " + max);
            }
        }
    }
}
//Output:
Character Frequency:
a = 1
g = 2
i = 1
m = 2
n = 1
o = 1
p = 1
r = 2

Most frequent letter(s):
g = 2
m = 2
r = 2

  
//Q10. Anagram Check
import java.util.Arrays;

public class Q10Anagram {

    static boolean isAnagram(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {

        System.out.println("Listen / Silent: " +
                isAnagram("Listen", "Silent"));

        System.out.println("Hello / World: " +
                isAnagram("Hello", "World"));
    }
}
//Output:
Listen / Silent: true
Hello / World: false
