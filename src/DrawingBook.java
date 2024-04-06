import java.io.*;

/** <a href="https://www.hackerrank.com/challenges/drawing-book/problem">...</a> */
public class DrawingBook {
    static class Result {

        public static int pageCount(int n, int p) {
            int fromEnd = ((n % 2 == 0 ? (n + 1) : n) - p) / 2;
            int fromFront = p / 2;
            return Math.min(fromFront, fromEnd);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
