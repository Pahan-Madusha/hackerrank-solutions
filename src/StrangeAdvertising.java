import java.io.*;

/**
 * <a href="https://www.hackerrank.com/challenges/strange-advertising/problem">...</a>
 */
public class StrangeAdvertising {

    static class Result {

        public static int viralAdvertising(int n) {
            int likeSum = 0;
            int receipients = 5;
            for (int day = 1; day <= n; day++) {
                int todayLikes = receipients / 2;
                likeSum += todayLikes;
                receipients = todayLikes * 3;
            }
            return likeSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
