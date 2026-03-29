import java.util.*;

public class Question5 {

    static class Card {
        int val, cat;

        Card(int v, int c) {
            val = v;
            cat = c;
        }

        public String toString() {
            return val + "," + cat;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Card>> players = new ArrayList<>();
        for (int i = 0; i < 4; i++) players.add(new ArrayList<>());

        // ✅ BACA TEPAT 4 BARIS (tidak pakai while)
        for (int i = 0; i < 4; i++) {
            String line = sc.nextLine().trim();
            String[] arr = line.split(" ");

            for (String s : arr) {
                String[] p = s.split(",");
                players.get(i).add(new Card(
                        Integer.parseInt(p[0]),
                        Integer.parseInt(p[1])
                ));
            }

            // sort
            players.get(i).sort((a, b) -> {
                if (a.cat != b.cat) return a.cat - b.cat;
                return a.val - b.val;
            });
        }

        // ✅ langsung baca player awal
        int turn = sc.nextInt() - 1;

        Deque<Card> stack = new ArrayDeque<>();

        int curCat = -1, curVal = -1;
        int pass = 0, winner = -1;

        while (true) {

            if (pass == 3) {
                curCat = -1;
                curVal = -1;
                pass = 0;
            }

            List<Card> hand = players.get(turn);

            if (curCat == -1) {
                Card c = hand.remove(0);
                stack.push(c);

                curCat = c.cat;
                curVal = c.val;
                pass = 0;

                if (hand.isEmpty()) {
                    winner = turn + 1;
                    break;
                }
            } else {
                int idx = -1;

                for (int i = 0; i < hand.size(); i++) {
                    Card c = hand.get(i);
                    if (c.cat == curCat && c.val > curVal) {
                        idx = i;
                        break;
                    }
                }

                if (idx != -1) {
                    Card c = hand.remove(idx);
                    stack.push(c);
                    curVal = c.val;
                    pass = 0;

                    if (hand.isEmpty()) {
                        winner = turn + 1;
                        break;
                    }
                } else {
                    pass++;
                }
            }

            turn = (turn + 1) % 4;
        }

        System.out.println(winner);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        sc.close();
    }
}