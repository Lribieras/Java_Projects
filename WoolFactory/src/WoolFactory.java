import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
  //The provided code generates random ages for sheep, and picks random names from the below array
  //You can modify this list of names as you wish (add/remove/replace elements).
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
    "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
    "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
    "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
    "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
    "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
    "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
    "George VI","Elizabeth II"};
  private static Random r = new Random(123);
  
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  
  public static void main(String[] args){
    //Student Name: Louis Ribieras
    //Student Number: 260631416
    //Your code goes here.

    // New Scanner object for users' input
    Scanner scanner = new Scanner(System.in);

    // get the name of the farm
    System.out.println("What is the name of your farm? " );
    String farmName = scanner.nextLine();

    // get the name of the dog
    System.out.println("What is the name of your dog? ");
    String dogName = scanner.nextLine();

    // get the type of dog
    System.out.println("What kind of dog is " + dogName + "?");
    String dogBreed = scanner.nextLine();

    // get the number of sheep
    System.out.println("And how many sheep do you have?");
    int numSheep = scanner.nextInt();

    // Setup the dog with inputs
    Dog dog = new Dog(dogName, dogBreed);

    // Setup the sheep array with inputs and random names/ages
    Sheep[] sheep = new Sheep[numSheep];
    double woolAmount = 0;
    for (int i = 0; i < sheep.length; i++) {

      sheep[i] = new Sheep(getRandomName(), getRandomAge());
      woolAmount += sheep[i].shear();

    }

    // Setup the farm
    Farm farm = new Farm(farmName, dog, sheep);


    // Display number of sheep on farm
    System.out.println("The farm has " + numSheep + " sheep.");

    // Use the printFarm method to display info about farm
    farm.printFarm();

    // Display final result
    System.out.println("We just sheared " + woolAmount +
            "lbs of wool for a value of $" + woolAmount * 1.45);

  }
}
