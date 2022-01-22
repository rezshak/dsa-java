package dp;

final class Factorial {

    int factorialIterative(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        for (int i = num - 1; i >= 1; i--) {
            num *= i;
        }
        return num;
    }

    int factorialRecursive(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return (num * factorialRecursive(num - 1));
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.factorialIterative(5));
        System.out.println(f.factorialRecursive(5));
    }

}
