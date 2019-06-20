package J1HomeWork6;

public class J1HomeWork6 {
    public static void main(String[] args) {
        Animals[] animals = {new Cat(100,50), new Dog(200,40,23)};
        for (Animals an : animals) {
            System.out.println(an.getClass().getSimpleName() + ":\nRun - " + an.run(100) + "\nSwim - " +
                    an.swim(10) + "\nJump - " + an.jump(45) + "\n");
        }
    }

}

class Dog extends Animals{

    Dog(int maxRun, int maxJump, int maxSwim) {
        super(maxRun, maxJump, maxSwim);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": MaxRun - " + maxRun + "; MaxJump - " + maxJump +
                "; MaxSwim - " + maxSwim;
    }
}

class Cat extends Animals {
    Cat(int maxRun, int maxJump, int maxSwim) {
        super(maxRun, maxJump, maxSwim);
    }
    Cat(int maxRun, int maxJump) {
        super(maxRun,maxJump,-1);
    }

    @Override
    public boolean swim(int path) {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": MaxRun - " + maxRun + "; MaxJump: - " + maxJump;
    }

}

abstract class Animals implements IAnimals {
    protected int maxRun;
    protected int maxSwim;
    protected int maxJump;

    Animals(int maxRun, int maxJump, int maxSwim) {
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    public boolean run(int path) {
        return true ? (path <= maxRun) : false;
    }

    public boolean jump(int height) {
        return true ? (height <= maxJump) : false;
    }

    public boolean swim(int path) {
        return false;
    }

}

interface IAnimals {
    boolean run(int path);
    boolean jump(int height);
}