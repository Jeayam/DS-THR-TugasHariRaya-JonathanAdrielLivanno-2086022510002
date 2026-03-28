import java.util.*;
//Chatgpt
public class Question1 {
    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";

        String[] words = input.split(" ");

        // simpan pair ke list dulu
        List<String[]> pairs = new ArrayList<>();

        for (int i = 0; i < words.length; i += 2) {
            pairs.add(new String[]{words[i], words[i + 1]});
        }

        Stack<String> resultStack = new Stack<>();

        // sesuai urutan soal
        int[] order = {3, 1, 0, 2, 4};

        for (int i : order) {
            resultStack.push(pairs.get(i)[0]);
            resultStack.push(pairs.get(i)[1]);
        }

        // ke array
        String[] result = new String[resultStack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultStack.get(i);
        }

        System.out.println(Arrays.toString(result));
    }
}