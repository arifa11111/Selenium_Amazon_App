import java.util.ArrayList;
import java.util.Arrays;

public class sample {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("arifa", "asha"));

        arr.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}

