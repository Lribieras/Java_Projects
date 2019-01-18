// Louis Ribieras
// 260631416

public class LeftTriangle {
    public static void main(String args[]){
        // Checking if the argument passed is greater than or equal to 0
        if (Integer.valueOf(args[0]) < 0) {
            System.out.println("Error: input value must be >= 0");
            return;
        }
        // For loop for rows, then
        for(int i = 0; i < Integer.valueOf(args[0]); i++) {
            for(int j = 0; j < Integer.valueOf(args[0]); j++)
                // Conditional operator ?:
                System.out.print(i < j ? " " : "*");
            // New Line
            System.out.println("");
        }
    }
}
