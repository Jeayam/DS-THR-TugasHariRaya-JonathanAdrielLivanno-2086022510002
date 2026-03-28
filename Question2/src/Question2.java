import java.util.*;
//Cgpt
// Superclass
abstract class Stand {
    abstract boolean expose(String name);
}

// Subclasses
class Josuke extends Stand {
    @Override
    boolean expose(String name) {
        return name.toUpperCase().startsWith("K");
    }
}

class Jotaro extends Stand {
    @Override
    boolean expose(String name) {
        return name.length() <= 3;
    }
}

class Okuyasu extends Stand {
    @Override
    boolean expose(String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            if (Character.toLowerCase(name.charAt(i)) ==
                Character.toLowerCase(name.charAt(i + 1))) {
                return true;
            }
        }
        return false;
    }
}

class Koichi extends Stand {
    @Override
    boolean expose(String name) {
        int count = 0;
        for (char c : name.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count >= 3;
    }
}

class Rohan extends Stand {
    @Override
    boolean expose(String name) {
        String lower = name.toLowerCase();
        String reversed = new StringBuilder(lower).reverse().toString();
        return lower.equals(reversed);
    }
}

// Main class
public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== INPUT DARI USER =====
        String standUser = sc.nextLine();
        String input = sc.nextLine();

        // ===== QUEUE =====
        Queue<String> queue = new LinkedList<>();
        for (String name : input.split(" ")) {
            queue.offer(name);
        }

        // ===== POLYMORPHISM =====
        Stand stand;

        switch (standUser) {
            case "Josuke": stand = new Josuke(); break;
            case "Jotaro": stand = new Jotaro(); break;
            case "Okuyasu": stand = new Okuyasu(); break;
            case "Koichi": stand = new Koichi(); break;
            case "Rohan": stand = new Rohan(); break;
            default: throw new IllegalArgumentException("Invalid Stand User");
        }

        // ===== STACK RESULT =====
        Stack<String> arrested = new Stack<>();

        while (!queue.isEmpty()) {
            String name = queue.poll();

            if (stand.expose(name)) {
                arrested.push(name);
            }
        }

        // ===== OUTPUT =====
        if (arrested.isEmpty()) {
            System.out.println(standUser + " exposed no one.");
        } else {
            System.out.println(standUser + " exposed someone!");
        }

        List<String> result = new ArrayList<>();
        while (!arrested.isEmpty()) {
            result.add(0, arrested.pop());
        }

        System.out.println("Arrested: " + result);
    }
}