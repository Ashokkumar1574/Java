import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5}; 
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        System.out.println("Repeating numbers in the array:");
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) > 1) {
                System.out.println(num + " - Frequency: " + frequencyMap.get(num));
            }
        }
    }
}
