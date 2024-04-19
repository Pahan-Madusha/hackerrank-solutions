import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * <a href="https://www.hackerrank.com/challenges/new-year-chaos/problem">...</a>
 */
public class NewYearChaos {

    static class Result {

        public static void minimumBribes(List<Integer> q) {
            Map<Integer, Integer> bribeCountMap = new HashMap<>();
            Integer[] array = q.toArray(new Integer[0]);
            int totalSwaps = 0;
            while (true) {
                boolean noSwaps = true;
                // Iterate and do bribes if valid
                for (int i = 0; i < array.length - 1; i++) {
                    // If a bribe is needed for position i
                    if (array[i] > i + 1 && array[i + 1] < array[i]) {
                        // Update bribe count map
                        bribeCountMap.putIfAbsent(array[i], 0);
                        bribeCountMap.put(array[i], bribeCountMap.get(array[i]) + 1);
                        // too many bribes
                        if (bribeCountMap.get(array[i]) > 2) {
                            System.out.println("Too chaotic");
                            return;
                        }
                        // Do the real bribe
                        swap(array, i, i + 1);
                        totalSwaps++;
                        noSwaps = false;
                    }
                }
                // Break out if no bribes were done in the iteration
                if (noSwaps) {
                    break;
                }
            }

            // Check if final positions are correct
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 1 + i) {
                    System.out.println("Too chaotic");
                    return;
                }
            }
            System.out.println(totalSwaps);
        }

        /**
         * Swap elements in the given two positions
         * @param arr array
         * @param pos1 position 1
         * @param pos2 position 2
         */
        private static void swap(Integer[] arr, int pos1, int pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t)
                .forEach(
                        tItr -> {
                            try {
                                int ignored = Integer.parseInt(bufferedReader.readLine().trim());

                                List<Integer> q =
                                        Stream.of(
                                                        bufferedReader
                                                                .readLine()
                                                                .replaceAll("\\s+$", "")
                                                                .split(" "))
                                                .map(Integer::parseInt)
                                                .collect(toList());

                                Result.minimumBribes(q);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });

        bufferedReader.close();
    }
}
