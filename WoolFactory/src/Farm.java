import java.util.Arrays;

public class Farm {

    // Private Attributes
    private Sheep[] sheepArray;
    private Dog Dog;
    private String name;

    // Constructor
    public Farm(String farmName, Dog dog, Sheep[] sheepArr) {
        name = farmName;
        Dog = dog;
        sheepArray = sheepArr;

        // Throw exception if dog cannot herd that many sheep
        if (sheepArray.length > Dog.herd()) {
            throw new IllegalArgumentException("Maximum number of " +
                    "sheep for this dog is " + Dog.herd() +
                    ". Received " + sheepArray.length + " sheep.");
        }

    }

    public String getName() {
        return name;
    }

    public int getNumSheep() {
        return sheepArray.length;
    }

    public void printFarm() {

        System.out.println("Farm: " + name);
        System.out.println("Dog: " + Dog.getName());

        for (int i = 0; i < sheepArray.length; i++) {
            // print the sheep name and age
            System.out.println(sheepArray[i].getName() + " " + sheepArray[i].getAge());
        }

    }

    public int getWool() {

        int wool = 0;

        for (int i = 0; i < sheepArray.length; i++) {
            wool += sheepArray[i].shear();
        }

        return wool;

    }

}
