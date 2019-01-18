//Fill in your name and student number
//Name: Louis Ribieras
//Student Number: 260631416

public class CoinMachine {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("You need to enter two arguments to this program. Try typing 'run CoinMachine 400 215' in Dr. Java, or 'java VendingMachine 400 215' on the command line.");
            return;
        }

            int cash = getInputInteger(args[0]);
            int price = getInputInteger(args[1]);

            //========================
            //Enter your code below

            //Change due from transaction
            int change = (cash - price);

            //Amount of twoonies T and remainder changeT
            int T = change / 200;
            int changeT = change % 200;

            //Amount of loonies L and remainder changeL
            int L = changeT / 100;
            int changeL = changeT % 100;
            
            //Amount of quarters Q and remainder changeQ
            int Q = changeL / 25;
            int changeQ = changeL % 25;

            //Amount of dimes D and remainder changeD
            int D = changeQ / 10;
            int changeD = changeQ % 10;

            //Amount of nickels N
            int N = changeD / 5;

            //Concatenating the int amounts to Strings
            String caSh = "" + cash;
            String coSt = "" + price;
            String changeS = "" + change;
            String t = "" + T;
            String l = "" + L;
            String q = "" + Q;
            String d = "" + D;
            String n = "" + N;

            //First part of answer
            System.out.println("\n" + "Amount received:   "  + caSh + "\n" +
            "Cost of the item:  " + coSt + "\n" +
            "Required change:   " + changeS + "\n");

            //Second part of answer
            System.out.println("Change:" + "\n" +
            "   twoonies x " + t + "\n" +
            "   loonie x " + l + "\n" +
            "   quarter x " + q + "\n" +
            "   dime x " + d + "\n" +
            "   nickel x " + n);

        
        //Enter your code above
        //========================
    }
    
    public static int getInputInteger(String arg) {
        try
        {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
        }
        
        //error, return 0
        return 0;
    }

}