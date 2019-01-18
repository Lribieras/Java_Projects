// Name: Louis Ribieras
// ID: 260631416

public class Dog {

    // Attributes
    private String name;
    private String breed;


    // Constructor
    public Dog(String n, String b) {
        name = n;
        breed = b;
    }

    public String getName() {
        return name;
    }

    public int herd() {

        int numHerd = 10;
        String b = breed.toLowerCase();

        if (b.contains("collie")) {
            numHerd = 20;
        }
        else if (b.contains("shepherd")) {
            numHerd = 25;
        }
        else if (b.contains("kelpie") || b.contains("teruven")) {
            numHerd = 30;
        }

        return numHerd;

    }


}
