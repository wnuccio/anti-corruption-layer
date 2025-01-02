package zupit;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyTest {


    public static String firstUniqueProduct(String[] products) {

        if (products.length == 0)
            return null;

        if (products.length == 1)
            return products[0];


        String candidate = null;
        Map<String, Integer> occurrences = new HashMap<>();

        for (int i = 1; i < products.length; i++) {
            String p = products[i];

            occurrences.put(p, occurrences(p, occurrences));

            if (candidate == null && occurrences(p, occurrences) == 1) {
                candidate = p;
            } else if (candidate != null && occurrences(candidate, occurrences) > 1) {
                candidate = null;
            }
        }

        return candidate;
    }

    private static int occurrences(String p, Map<String, Integer> occurrences) {
        return occurrences.get(p) != null ? occurrences.get(p) : 0;
    }


    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
    }

    @Test
    void test() {
        analyze("this tring");
        assertTrue(true);
    }

    private void analyze(String thisTring) {
        System.out.println(thisTring);
    }
}
