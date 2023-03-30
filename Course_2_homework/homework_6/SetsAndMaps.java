package homework_6;

import java.util.*;
import java.util.stream.Collectors;

public class SetsAndMaps {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        System.out.println(sortOddNumbers(nums));
        System.out.println(sortEvenNumbers(nums));

        String text = "bac bac fdfag fdfag fdsafhg gfdha afds fsa e fgdas e dafasd bac bac"; // Текст, который рассмастривается
        List<String> arr = new ArrayList<>(List.of(text.split(" ")));

        Map<String, Integer> map = findFrequentWordMap(arr);
        System.out.println("Уникальные слова - " + uniqueWords(map));
        System.out.println("Повторяющиеся слова - " + frequencyOfWords(map));
    }

    public static List<Integer> sortOddNumbers(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
    }

    public static Set<Integer> sortEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Map<String, Integer> findFrequentWordMap(List<String> arr) {
        Map<String, Integer> map = new HashMap<>();
        arr.forEach(x -> {
            if (map.containsKey(x)) {
                map.replace(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });
        return map;
    }

    public static List<String> uniqueWords(Map<String, Integer> map) {
        List<String> result = new ArrayList<>();
        for (String x : map.keySet()) {
            if (map.get(x) == 1) {
                result.add(x);
            }
        }
        return result;
    }

    public static Map<String, Integer> frequencyOfWords(Map<String, Integer> map) {
        Map<String, Integer> result = new HashMap<>();
        for (String x : map.keySet()) {
            if (map.get(x) > 1) {
                result.put(x, map.get(x));
            }
        }
        return result;
    }
}
