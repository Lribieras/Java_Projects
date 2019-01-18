import java.util.Arrays;
public class TesterA4 {
    
    
    public static void main(String[] args) { 
        System.out.println("*************Test ExamMarking*************");
        System.out.println();
        
        testExamMarking();
        
        System.out.println();
        System.out.println("*************Test Dog*************");
        System.out.println();
        
        testDog();
        
        System.out.println();
        System.out.println("*************Test Sheep*************");
        System.out.println();
        
        testSheep();
        
        System.out.println();
        System.out.println("*************Test Farm*************");
        System.out.println();
        
        testFarm();
        
        System.out.println();
        System.out.println("*************Test WoolFactory*************");
        System.out.println();
        
        testWoolFactory();
    }
    
    public static void testExamMarking() {
        char[][] responses = {{'C', 'A', 'B', 'B', 'C', 'A'}, {'A', 'A', 'B', 'B', 'B', 'B'},
            {'C', 'B', 'A', 'B', 'C', 'A'}, {'A', 'B', 'A', 'B', 'B', 'B'}};
        char[] solutions = {'C', 'A', 'B', 'B', 'C', 'C'};
        double[] grades = ExamGrading.gradeAllStudents(responses, solutions);
        System.out.println("gradeAllStudents() compiles. Output: " + Arrays.toString(grades));
        System.out.println();
        
        char[] responseOne = {'A', 'B', 'C', 'D', 'C', 'A'};
        char[] responseTwo = {'A', 'B', 'D', 'B', 'B', 'A'};
        char[] sol = {'C', 'B', 'C', 'D', 'A', 'A'};
        int similar = ExamGrading.numWrongSimilar(responseOne, responseTwo, sol);
        System.out.println("numWrongSimilar() compiles. Output: " + similar);
        System.out.println();
        
        char[][] resp = {{'A', 'B', 'C', 'D', 'B', 'A'}, {'C', 'B', 'D', 'D', 'B', 'B'}, {'C', 'B', 'D', 'D', 'C', 'B'}};
        int matches = ExamGrading.numMatches(resp,sol,1,2);
        System.out.println("numMatches() compiles. Output: " + matches);
        System.out.println();
        
        int[][] cheaters = ExamGrading.findSimilarAnswers(responses, solutions, 1);
        System.out.println("findSimilarAnswers() compiles. Output: " + Arrays.deepToString(cheaters));
        System.out.println();
    }
    
    public static void testDog() {
        Dog myDog = new Dog("Lessie", "border collie");
        System.out.println("creating a border collie named \"Lessie\"");
        System.out.println();
        
        String name = myDog.getName(); 
        System.out.println("getName() compiles. The dog name is: " + name);
        System.out.println();
        
        int numOfSheep = myDog.herd(); 
        System.out.println("herd() compiles. The dog can herd " + numOfSheep + " sheep");
        System.out.println();
    }
    public static void testSheep() {
        Sheep dolly = new Sheep("Dolly", 3);
        System.out.println("Creating a 3 years old sheep named \"Dolly\"");
        System.out.println();
        
        String name = dolly.getName(); 
        System.out.println("getName() compiles. The sheep name is: " + name);
        System.out.println();
        
        int age = dolly.getAge(); 
        System.out.println("getAge() compiles. The sheep age is " + age);
        System.out.println();
        
        double wool = dolly.shear(); 
        System.out.println("shear() compiles. The sheep has " + wool + " pounds of wool");
        System.out.println();
    }
    public static void testFarm() {
        Dog myDog = new Dog("Lessie", "border collie");
        Sheep[] herd = new Sheep[0];
        Farm f = new Farm("Woolsome Farm", myDog, herd);
        System.out.println("creating a farm named \"Woolsome Farm\" with 0 sheep");
        System.out.println();
        
        String name = f.getName(); 
        System.out.println("getName() compiles. The farm name is: " + name);
        System.out.println();
        
        
        int numSheep = f.getNumSheep(); 
        System.out.println("getNumSheep() compiles. The farm has " + numSheep + " sheep");
        System.out.println();
        
        
        double wool = f.getWool(); 
        System.out.println("getWool() compiles. The farm has " + wool + " pounds of wool");
        System.out.println();
        
        System.out.println("printFarm() compiles and displays the following: ");
        f.printFarm();
    }
    public static void testWoolFactory() {
        WoolFactory wf = null;
        System.out.println("The file WoolFactory.java is in this folder as expected.");
    }
    
}