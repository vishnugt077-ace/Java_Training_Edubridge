//Q1. Array Statistics
public class Q01 {
    public static void main(String[] args) {

        int[] marks = {78, 92, 65, 88, 71, 95, 59};

        int sum = 0;
        int max = marks[0];
        int min = marks[0];

        for (int m : marks) {
            sum += m;

            if (m > max)
                max = m;

            if (m < min)
                min = m;
        }

        double average = (double) sum / marks.length;

        System.out.println("Sum = " + sum);
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

  
//Q2. Reverse an Array
import java.util.Arrays;

public class Q02 {

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

        System.out.println("After : " + Arrays.toString(a));
    }
}
//Output:
Before: [10, 20, 30, 40, 50]
After : [50, 40, 30, 20, 10]

  
//Q3. Linear Search
public class Q03 {

    static int search(int[] a, int key) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] == key)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {4, 8, 15, 16, 23, 42};

        int[] keys = {23, 7};

        for (int k : keys) {

            int index = search(a, k);

            if (index != -1)
                System.out.println(k + " found at index " + index);
            else
                System.out.println(k + " not found");
        }
    }
}
//Output:
23 found at index 4
7 not found

  
//Q4. Second Largest Element
public class Q04 {

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

        System.out.println("Largest = " + first);
        System.out.println("Second largest = " + second);
    }
}
//Output:
Largest = 35
Second largest = 34

  
//Q5. Move Zeros to the End
import java.util.Arrays;

public class Q05 {

    public static void main(String[] args) {

        int[] a = {0, 5, 0, 3, 12, 0, 7};

        int pos = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] != 0) {
                a[pos] = a[i];
                pos++;
            }
        }

        while (pos < a.length) {
            a[pos] = 0;
            pos++;
        }

        System.out.println(Arrays.toString(a));
    }
}
//Output:
[5, 3, 12, 7, 0, 0, 0]

  
//Q6. 2D Array — Row and Column Totals
public class Q06 {

    public static void main(String[] args) {

        int[][] m = {
            {80, 75, 90},
            {60, 85, 70},
            {95, 65, 88}
        };

        int[] colSum = new int[3];

        for (int r = 0; r < m.length; r++) {

            int rowSum = 0;

            for (int c = 0; c < m[r].length; c++) {

                System.out.print(m[r][c] + "\t");

                rowSum += m[r][c];
                colSum[c] += m[r][c];
            }

            System.out.println("| " + rowSum);
        }

        System.out.println("-------------------------");

        for (int x : colSum)
            System.out.print(x + "\t");
    }
}
//Output:
80    75    90    | 245
60    85    70    | 215
95    65    88    | 248
-------------------------
235   225   248
  
//Q7. Reverse String and Check Palindrome
public class Q07 {

    static String reverse(String s) {

        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        return rev;
    }

    public static void main(String[] args) {

        String[] words = {"Madam", "Java"};

        for (String w : words) {

            String r = reverse(w);

            if (w.equalsIgnoreCase(r))
                System.out.println(w + " -> " + r + " : Palindrome");
            else
                System.out.println(w + " -> " + r + " : Not a palindrome");
        }
    }
}
//Output:
Madam -> madaM : Palindrome
Java -> avaJ : Not a palindrome

  
//Q8. Count Vowels, Consonants, Digits and Spaces
public class Q08 {

    public static void main(String[] args) {

        String s = "Java 21 is Awesome";

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetter(ch)) {

                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;

            } else if (Character.isDigit(ch)) {
                digits++;

            } else if (ch == ' ') {
                spaces++;
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
public class Q09 {

    public static void main(String[] args) {

        String s = "programming";

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int best = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] > 0) {

                System.out.println(
                    (char)('a' + i) + " = " + freq[i]
                );

                if (freq[i] > best)
                    best = freq[i];
            }
        }

        System.out.print("Most frequent: ");

        for (int i = 0; i < 26; i++) {

            if (freq[i] == best)
                System.out.print((char)('a' + i) + " ");
        }

        System.out.println("(" + best + " times)");
    }
}
//Output:
a = 1
g = 2
i = 1
m = 2
n = 1
o = 1
p = 1
r = 2
Most frequent: g m r (2 times)

  
//Q10. Anagram Check
import java.util.Arrays;

public class Q10 {

    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length())
            return false;

        char[] x = a.toLowerCase().toCharArray();
        char[] y = b.toLowerCase().toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {

        System.out.println(
            "Listen & Silent: " +
            isAnagram("Listen", "Silent")
        );

        System.out.println(
            "Hello & World : " +
            isAnagram("Hello", "World")
        );
    }
}
//Output:
Listen & Silent: true
Hello & World : false
