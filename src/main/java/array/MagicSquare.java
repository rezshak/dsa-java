package main.java.array;

class MagicSquare {

    public static boolean isMagicSquare(int[][] square) {
        int hSum = 0, vSum = 0, d1Sum = 0, d2Sum = 0;
        for (int i = 0; i < square.length; i++) {
            hSum += square[0][i];
            vSum += square[i][0];
            d1Sum += square[i][i];
            d2Sum += square[i][square.length - i - 1];
        }
        return (vSum == hSum) && (hSum == d1Sum) && (d1Sum == d2Sum);
    }

    public static void main(String[] args) {
        int[][] arr2d = {
                {8, 1, 6},
                {3, 5, 9},
                {4, 9, 2}
        };
        System.out.println(isMagicSquare(arr2d));
    }

}
