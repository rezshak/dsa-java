package recursion;

final class Factorial {

    int factorialIterative(int num) {
        int fact = 1;
        for (int i = num; i > 1; i--) {
            fact *= i;
        }
        return fact;
    }

    int factorial(int num) {
        if (num == 0 || num == 1) return 1;
        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.factorialIterative(5));
        System.out.println(f.factorial(5));
    }

}
