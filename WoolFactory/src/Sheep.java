// Name: Louis Ribieras
// ID: 260631416

import java.util.Random;

public class Sheep {

    // Private Attributes
    private String name;
    private int age;
    private Boolean hasWool;
    private static Random r = new Random(123);

    // Constructor
    public Sheep(String n, int a) {
        name = n;
        age = a;
        hasWool = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double shear() {
        double x = 0;

        if (hasWool) {
            // random # between 6 (included) and 10 (excluded)
            x = 6 + (4 * (r.nextDouble()));
            hasWool = false;
        }

        return x;

    }

}
