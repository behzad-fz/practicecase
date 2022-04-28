package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)
            throws IOException
    {
        System.out.println("What number you're looking for?");

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        Integer needle = Integer.valueOf(reader.readLine());

        int[] haystack = IntStream.range(0, 100).toArray();

        int index = 0;

        int low = 0;

        int high = haystack.length;

        while (true) {
            int mid = (low + high) / 2;
            int guess = haystack[mid];

            System.out.println(String.format("Step: %s", index));
            System.out.println(String.format("Is it %s ?", guess));

            if (guess == needle) {
                System.out.println("YESS!! Hooray!");
                break;
            } else if (guess < needle) {
                low = mid + 1;
                System.out.println(String.format("it is higher than %s", guess));
            } else {
                high = mid - 1;
                System.out.println(String.format("it is lower than %s", guess));
            }

            index = index + 1;
        }

        System.out.println(String.format("We found it in %s steps!", index + 1));
        System.out.println(Arrays.toString(haystack));
    }
}
