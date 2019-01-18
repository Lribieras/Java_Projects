// Louis Ribieras
// 260631416

public class RightTriangle {

    public static void main(String args[])
    {
        // Display error message if value of argument is less than 0
        if (Integer.valueOf(args[0]) < 0)
        {
            System.out.println("Error: input value must be >= 0");
            return;
        }

        // Looping values from 1 to argument value
        for(int i = 1; i <= Integer.valueOf(args[0]); i++)
        {
            for(int j = Integer.valueOf(args[0]); j > 0; j--)
                // Using conditional operator ?:
                System.out.print(i < j ? " " : "*");

            // New line
            System.out.println("");
        }
    }
}
