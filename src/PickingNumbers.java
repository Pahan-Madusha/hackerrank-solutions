import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * <a href="https://www.hackerrank.com/challenges/picking-numbers/problem">...</a>
 */
public class PickingNumbers {

    static class Result {

        public static int pickingNumbers(List<Integer> arr) {
            Collections.sort(arr);
            int curr = arr.get(0);
            int maxLength = 1;
            int start = 0;
            List<Integer> lengthList = new ArrayList<>();
            List<Integer> valueList = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (curr != arr.get(i)) {
                    lengthList.add(i - start);
                    valueList.add(curr);
                    start = i;
                    curr = arr.get(i);
                }
            }

            // If same value for all elements
            if (lengthList.isEmpty()) {
                lengthList.add(arr.size());
            }
            // Find largest combinations if any
            for (int j = 0; j < valueList.size() - 1; j++) {
                if (valueList.get(j + 1) - valueList.get(j) > 1) {
                    maxLength = Math.max(maxLength, lengthList.get(j));
                } else {
                    maxLength = Math.max(maxLength, lengthList.get(j) + lengthList.get(j + 1));
                }
            }
            // Max out of Max individual or combination
            return Math.max(Collections.max(lengthList), maxLength);
        }
    }

    /** Recursive solution */
    static class ResultRec {

        public static int pickingNumbers(List<Integer> arr) {
            int maxLength = 1;
            for (int i = 0; i < arr.size(); i++) {
                int min = arr.get(i);
                int max = arr.get(i);
                maxLength = Math.max(findMaxLengthRec(arr, i, min, max, 0), maxLength);
            }
            return maxLength;
        }

        private static int findMaxLengthRec(
                List<Integer> arr, int index, int min, int max, int maxLength) {

            if (index > arr.size() - 1) {
                return maxLength;
            }

            // If number doesn't qualify for current sequence
            if (Math.abs(arr.get(index) - min) > 1 || Math.abs(arr.get(index) - max) > 1) {
                return findMaxLengthRec(arr, index + 1, min, max, maxLength);
            }
            // Max length including current number
            int maxLenExcluding = findMaxLengthRec(arr, index + 1, min, max, maxLength);
            min = Math.min(min, arr.get(index));
            max = Math.max(max, arr.get(index));
            // Max length excluding current number
            int maxLenIncluding = findMaxLengthRec(arr, index + 1, min, max, ++maxLength);
            return Math.max(maxLenExcluding, maxLenIncluding);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a =
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

        int recursiveSolution = ResultRec.pickingNumbers(a);
        int nonRecursiveSolution = Result.pickingNumbers(a);

        System.out.println("Recursive solution : " + recursiveSolution);
        System.out.println("Non recursive solution : " + nonRecursiveSolution);

        bufferedWriter.write(String.valueOf(nonRecursiveSolution));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
