import java.util.*;

public class Question3 {

    static class Person {
        String name, key;
        int priority, order, groupOrder;

        Person(String n, String k, int p, int o, int g) {
            name = n; key = k; priority = p; order = o; groupOrder = g;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();

        // skip daftar key awal
        for (int i = 0; i < n; i++) sc.next();

        String[] names = new String[n];
        String[] keys = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            keys[i] = sc.next();
        }

        int[] prio = new int[n];
        for (int i = 0; i < n; i++) {
            prio[i] = sc.nextInt();
        }

        Map<String, Integer> first = new HashMap<>();
        for (int i = 0; i < n; i++) {
            first.putIfAbsent(keys[i], i);
        }

        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(names[i], keys[i], prio[i], i, first.get(keys[i])));
        }

        List<Person> list = new ArrayList<>(q);

        list.sort((a, b) -> {
            if (a.groupOrder != b.groupOrder)
                return a.groupOrder - b.groupOrder;
            if (a.priority != b.priority)
                return a.priority - b.priority;
            return a.order - b.order;
        });

        for (Person p : list) {
            System.out.println(p.name + " | " + p.key);
        }

        sc.close();
    }
}