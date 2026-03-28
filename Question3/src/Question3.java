//chatgpt & gemnini

class Food {
    protected String name;
    protected int basePrice;

    public Food(String name, int basePrice) {
        if (basePrice >= 1000000) {
            throw new IllegalArgumentException("Base price must be below 1000000");
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    public int calcPrice() {
        return basePrice + 5000;
    }

    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
    }
}

// Subclass Regular
class RegularMenu extends Food {

    public RegularMenu(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 10000;
    }
}

// Subclass Special
class SpecialMenu extends Food {

    public SpecialMenu(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public int calcPrice() {
        return super.calcPrice() + 20000;
    }
}

// Main
public class Question3 {
    public static void main(String[] args) {

        Food food1 = new Food("Beef Rendang", 15000);
        Food food2 = new RegularMenu("Chicken Ramen", 20000);
        Food food3 = new SpecialMenu("Fiery Fried Rice", 80000);

        food1.getInfo();
        food2.getInfo();
        food3.getInfo();
    }
}