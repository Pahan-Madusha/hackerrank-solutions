import java.io.*;

class Result {

    public static int countingValleys(int steps, String path) {
        int level = 0;
        int valleyCount = 0;
        // If current position is inside a valley
        boolean inValley = false;
        for (char c : path.toCharArray()) {
            // Update the level
            if (c == 'D') {
                level--;
            } else {
                level++;
            }

            // Just stepping into a valley, Update valley count
            if (!inValley && level < 0) {
                inValley = true;
                valleyCount++;
            } else if (level == 0) {
                inValley = false;
            }
        }
        return valleyCount;
    }
}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
