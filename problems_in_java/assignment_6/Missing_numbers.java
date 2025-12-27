import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        // Find minimum and maximum values in brr
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : brr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Frequency array (range <= 100)
        int[] freq = new int[max - min + 1];

        // Count frequencies of brr
        for (int num : brr) {
            freq[num - min]++;
        }

        // Subtract frequencies using arr
        for (int num : arr) {
            freq[num - min]--;
        }

        // Collect missing numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result.add(i + min);
            }
        }

        return result;
    }
}

public class Missing_numbers{
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arrTemp = bufferedReader.readLine().trim().split(" ");
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(arrTemp[i]));
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());
        String[] brrTemp = bufferedReader.readLine().trim().split(" ");
        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            brr.add(Integer.parseInt(brrTemp[i]));
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
