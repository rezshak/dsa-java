package main.java.recursion;

public class RecurrenceRelations {

    // T(n) = T(n - 1) + 1 => O(n)
    void Test1(int n) {
        if (n > 0) {
            System.out.printf("%d\n", n);
            Test1(n - 1);
        }
    }

    // T(n) = T(n - 1) + n => O(n^2)
    void TestN(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d\n", n);
            }
            TestN(n - 1);
        }
    }

    // T(n) = T(n - 1) + log n => O(nlog n)
    void TestLogN(int n) {
        if (n > 0) {
            for (int i = 1; i < n; i *= 2) {
                System.out.printf("%d\n", n);
            }
            TestLogN(n - 1);
        }
    }

    // T(n) = T(n - 1) + n^2 => O(n^3)
    // T(n) = T(n - 2) + 1  => n/2 O(n) => O(n)
    // T(n) = T(n - 100) + n => O(n^2)

    // T(n) = 2T(n - 1) + 1 => O(2^n)
    void Test2T(int n) {
        if (n > 0) {
            System.out.printf("%d\n", n);
            Test2T(n - 1);
            Test2T(n - 1);
        }
    }

    // T(n) = 3T(n - 1) + 1 	=> O(3^n)
    // T(n) = 2T(n - 1) + n 	=> O(n2^n)





    public static void main(String[] args) {

        RecurrenceRelations rr = new RecurrenceRelations();
        rr.Test2T(3);

    }

}
