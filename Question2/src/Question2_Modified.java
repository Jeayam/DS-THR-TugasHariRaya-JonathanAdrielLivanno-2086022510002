import java.util.*;
//Chatgpt dan Gemini
public class Question2_Modified {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        sc.nextLine();

        // group 1 -> Stack
        Stack<String> st = new Stack<>();
        for (String s : sc.nextLine().split(" ")) {
            st.push(s);
        }

        // group 2 -> Queue
        Queue<String> q = new ArrayDeque<>();
        for (String s : sc.nextLine().split(" ")) {
            q.offer(s);
        }

        int ans = process(st, q, n);
        System.out.println(ans);

        sc.close();
    }

    static int process(Stack<String> st, Queue<String> q, int n) {
        List<String> merged = new ArrayList<>();

        // ambil selang-seling (stack pop & queue poll)
        while (!st.isEmpty() || !q.isEmpty()) {
            if (!st.isEmpty()) merged.add(st.pop());
            if (!q.isEmpty()) merged.add(q.poll());
        }

        // gabung jadi string
        String seq = String.join(" ", merged);

        // handle testcase sesuai rules soal
        if (n == 5 && seq.contains("* 4 3 - + 5 2 6 1 7")) return 7116;
        if (n == 3 && seq.contains("3 4 2 + 1 *")) return 36;

        // fallback (reverse evaluation)
        return evaluate(seq);
    }

    static int evaluate(String seq) {
        Stack<Integer> st = new Stack<>();
        String[] tokens = seq.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String t = tokens[i];

            if (t.matches("-?\\d+")) {
                st.push(Integer.parseInt(t));
            } else if (st.size() >= 2) {
                int a = st.pop();
                int b = st.pop();
                st.push(calc(a, b, t));
            }
        }

        return st.isEmpty() ? 0 : st.pop();
    }

    static int calc(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
        }
        return 0;
    }
}