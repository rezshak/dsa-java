package recursion;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SubSequences {

    static void findAllSubSets(int[] S, Deque<Integer> dq, int len) {
        if (len == 0) {
            System.out.println(dq);
            return;
        }
        dq.addLast(S[len - 1]);
        findAllSubSets(S, dq, len - 1);
        dq.removeLast();
        findAllSubSets(S, dq, len - 1);
    }

    static void printAllSubStrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String subStr = str.substring(i, j + 1);
                System.out.println(subStr);
            }
        }
    }

    static void printAllSubArrays(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                var subList = input.subList(i, j + 1);
                System.out.println(subList);
            }
        }
    }

    public static void main(String[] args) {

//        List<Integer> list = List.of(1, 2, 3);
//        printAllSubArrays(list);
//        String str = "abc";
//        printAllSubStrings(str);

        int[] S = {1, 2, 3};
        Deque<Integer> dq = new ArrayDeque<>();
        findAllSubSets(S, dq, S.length);
    }

}
