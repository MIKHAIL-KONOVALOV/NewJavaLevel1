package HomeWork7;

public class HomeWork7 {
    public static void main(String[] args) {
        Animals[] animals = {new Cat("Barsik",15), new Cat("Murzik", 25)};
        for (Animals an : animals) {
            Plate plate = new Plate(20);
            System.out.println(an);
            System.out.println(plate);
            an.eat(plate);
            System.out.println(an);
            System.out.println(plate);

        }
    }

}

/*class Dog extends Animals {

    Dog(int maxRun, int maxJump, int maxSwim) {
        super(maxRun, maxJump, maxSwim);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": MaxRun - " + maxRun + "; MaxJump - " + maxJump +
                "; MaxSwim - " + maxSwim;
    }
}*/

class Plate {
    protected int currentFood;

    Plate(int currentFood) {
        this.currentFood = currentFood;
    }

    public void decreaseFood(int value) {
        currentFood -= value;
    }

    public void fillPlate(int value) {
        currentFood = value;
    }

    @Override
    public String toString() {
        return Integer.toString(currentFood);
    }
}

class Cat extends Animals {
    Cat(String name, int appetit) {
        super(name, appetit);
    }

    public void eat(Plate plate) {
        if (appetit <= plate.currentFood) {
            isFull = true;
            plate.decreaseFood(appetit);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": Name - " + name +
                "; Appetit: - " + appetit + "; Is full - " + isFull;
    }

}

abstract class Animals {
    protected String name;
    protected int appetit;
    protected boolean isFull = false;

    public Animals(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void eat(Plate plate) {

    }


}
