// Louis Ribieras
// 260631416


public class Classifier{

    public static void main(String args[]) {

        // Error message for if less than 3 arguments are passed
        if(args.length < 3) {
            System.out.println("You need to enter three arguments to this program: BEAK_MM, CLAW_MM, COLOR");
            return;
        }

        // Parsing doubles and string from the arguments passed
        double BEAK_MM = Double.parseDouble(args[0]);
        double CLAW_MM = Double.parseDouble(args[1]);
        String COLOR = args[2];

        // All possible combinations of bird types
        if (isTypeA(BEAK_MM, CLAW_MM, COLOR) && !isTypeB(BEAK_MM, CLAW_MM, COLOR) && !isTypeC(BEAK_MM, CLAW_MM, COLOR)){
            System.out.println("The type of bird is A.");
        } else if (isTypeA(BEAK_MM, CLAW_MM, COLOR) && isTypeB(BEAK_MM, CLAW_MM, COLOR) && !isTypeC(BEAK_MM, CLAW_MM, COLOR)) {
            System.out.println("The type of bird is A B.");
        } else if (!isTypeA(BEAK_MM, CLAW_MM, COLOR) && isTypeB(BEAK_MM, CLAW_MM, COLOR) && !isTypeC(BEAK_MM, CLAW_MM, COLOR)) {
            System.out.println("The type of bird is B.");
        } else if (!isTypeA(BEAK_MM, CLAW_MM, COLOR) && isTypeB(BEAK_MM, CLAW_MM, COLOR) && isTypeC(BEAK_MM, CLAW_MM, COLOR)) {
            System.out.println("The type of bird is B C.");
        } else if (!isTypeA(BEAK_MM, CLAW_MM, COLOR) && !isTypeB(BEAK_MM, CLAW_MM, COLOR) && isTypeC(BEAK_MM, CLAW_MM, COLOR)) {
            System.out.println("The type of bird is C.");
        } else if (!isTypeA(BEAK_MM, CLAW_MM, COLOR) && !isTypeB(BEAK_MM, CLAW_MM, COLOR) && !isTypeC(BEAK_MM, CLAW_MM, COLOR)) {
            System.out.println("This bird is not part of the study.");
        }


    }

    public static Boolean isTypeA(double BEAK_MM, double CLAW_MM, String COLOR) {

        // Birds of type A (Boolean)
        if ((BEAK_MM == 1 && CLAW_MM == 0 && COLOR.equals("Grey")) ||
                (BEAK_MM == 2 && CLAW_MM == 1 && COLOR.equals("Grey")) ||
                (BEAK_MM == 3 && CLAW_MM == 2 && COLOR.equals("Grey")) ||
                (BEAK_MM == 4 && CLAW_MM == 3 && COLOR.equals("Grey")) ||
                (BEAK_MM == 4 && CLAW_MM == 4 && COLOR.equals("Grey")) ||
                (BEAK_MM == 5 && CLAW_MM == 4 && COLOR.equals("Grey"))) {
        return true;} else {return false;}
    }

    public static Boolean isTypeB(double BEAK_MM, double CLAW_MM, String COLOR) {

        // Birds of type B (Boolean)
        if ((BEAK_MM == 4 && CLAW_MM == 4 && COLOR.equals("Grey")) ||
                (BEAK_MM == 4 && CLAW_MM == 5 && COLOR.equals("Grey")) ||
                (BEAK_MM == 5 && CLAW_MM == 6 && COLOR.equals("Grey")) ||
                (BEAK_MM == 5 && CLAW_MM == 6 && COLOR.equals("Blue")) ||
                (BEAK_MM == 5 && CLAW_MM == 7 && COLOR.equals("Grey")) ||
                (BEAK_MM == 5 && CLAW_MM == 7 && COLOR.equals("Blue")) ||
                (BEAK_MM == 6 && CLAW_MM == 8 && COLOR.equals("Blue")) ||
                (BEAK_MM == 6 && CLAW_MM == 9 && COLOR.equals("Blue")) ||
                (BEAK_MM == 7 && CLAW_MM == 10 && COLOR.equals("Blue")) ||
                (BEAK_MM == 8 && CLAW_MM == 11 && COLOR.equals("Blue"))) {
        return true;} else {return false;}
    }

    public static Boolean isTypeC(double BEAK_MM, double CLAW_MM, String COLOR) {

        // Birds of type C (Boolean)
        if ((BEAK_MM == 5 && CLAW_MM == 6 && COLOR.equals("Blue")) ||
                (BEAK_MM == 5 && CLAW_MM == 6 && COLOR.equals("Green")) ||
                (BEAK_MM == 5 && CLAW_MM == 7 && COLOR.equals("Blue")) ||
                (BEAK_MM == 5 && CLAW_MM == 7 && COLOR.equals("Green")) ||
                (BEAK_MM == 6 && CLAW_MM == 8 && COLOR.equals("Green")) ||
                (BEAK_MM == 6 && CLAW_MM == 9 && COLOR.equals("Green")) ||
                (BEAK_MM == 7 && CLAW_MM == 10 && COLOR.equals("Green")) ||
                (BEAK_MM == 8 && CLAW_MM == 11 && COLOR.equals("Green")) ||
                (BEAK_MM == 9 && CLAW_MM == 12 && COLOR.equals("Green"))) {
        return true;} else {return false;}
    }

}
