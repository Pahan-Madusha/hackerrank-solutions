import java.io.*;

/**
 * <a href="https://www.hackerrank.com/challenges/append-and-delete/problem">...</a>
 */
public class AppendAndDelete {

    static class Result {

        public static String appendAndDelete(String s, String t, int k) {
            int setCount = 0;
            // Find char count from beginning with exact match
            for (int i = 0; i < s.length(); i++) {
                if (i < t.length()) {
                    if (s.charAt(i) == t.charAt(i)) {
                        setCount++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            // char count to delete
            int deleteCount = s.length() - setCount;
            // char count to add
            int addCount = t.length() - setCount;

            // If full delete and add is possible
            if (s.length() + t.length() <= k) {
                return "Yes";
            }

            // If not possible to damp extra steps
            if ((k - deleteCount - addCount) % 2 != 0) {
                return "No";
            }
            // If possible within k steps
            return deleteCount + addCount <= k ? "Yes" : "No";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
