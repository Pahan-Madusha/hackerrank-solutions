import java.io.*;
import java.util.stream.*;

/**
 * <a href="https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem">...</a>
 */
public class BeautifulDays {

    static class Result {

        public static int beautifulDays(int i, int j, int k) {
            return (int)
                    IntStream.range(i, j + 1)
                            .boxed()
                            .map(number -> Math.abs(number - reverse(number)))
                            .filter(diff -> diff % k == 0)
                            .count();
        }

        private static int reverse(int value) {
            return Integer.parseInt(new StringBuilder(String.valueOf(value)).reverse().toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
