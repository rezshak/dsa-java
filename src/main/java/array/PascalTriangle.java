package main.java.array;

import java.util.*;

public class PascalTriangle {

    List<List<Integer>> generatePascalTriangleRecursive(int numRows) {
        var result = new ArrayList<List<Integer>>(numRows);
        return helper(numRows, result);
    }

    List<List<Integer>> helper(int n, List<List<Integer>> result) {
        if (n == 0) {
            return result;
        }
        var row = new ArrayList<Integer>();
        if (result.isEmpty()) {
            row.add(1);
        } else {
            var prevRow = result.get(result.size() - 1);
            row.add(1);
            for (var i = 1; i < prevRow.size(); i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }
            row.add(1);
        }
        result.add(row);
        return helper(n - 1, result);
    }

    List<List<Integer>> generatePascalTriangle(int n) {
        var result = new ArrayList<List<Integer>>();
        for (var i = 0; i < n; i++) {
            var row = new ArrayList<Integer>();
            for (var j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    var val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        var pt = new PascalTriangle();
        System.out.println(pt.generatePascalTriangle(5));
        System.out.println(pt.generatePascalTriangleRecursive(5));
    }

}
