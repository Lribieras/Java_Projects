//Fill in your name and student number
//Name: Louis Ribieras
//Student Number: 260631416

// do NOT touch these import statements 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class CountdownDays {

    // the method returns a String representing the current date in the following format: dd/mm/yyyy
    // you can use it, but do NOT modify it!
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    //========================
    // Enter your code below


    public static void main(String [] args) {
        // Running method with first argument from command line
        displayCountdown(args[0]);

    }


    // 1a. A method to get a substring from a specified String
    public static String getSubstring(String s, int i, int j) {

        if (i > j) {
            // Exception with message
            throw new IllegalArgumentException("First int must be smaller than second int");
        } else {
            String substring = "";
            for (int x = i; x <= j; x++) {
                substring += s.charAt(x);
            }
            return substring;
        }

    }


    // 1b. Three different methods to extract day, month, and year from a String
    public static int getDay(String date) {

        date = getSubstring(date, 0, 1);
        return Integer.parseInt(date);
    }

    public static int getMonth(String date) {

        date = getSubstring(date, 3, 4);
        return Integer.parseInt(date);
    }

    public static int getYear(String date) {

        date = getSubstring(date, 6, 9);
        return Integer.parseInt(date);
    }


    // 1c. A method to check if a year is a leap year
    public static Boolean isLeapYear(int year) {

        if ((year % 4 == 00 && !(year % 100 == 0))) {
            return true;
        } else {
            return (year % 100 == 0 && year % 400 == 0);
        }

    }


    // 1d. A method that returns the number of days in a month
    public static int getDaysInAMonth(int month, int year) {

        int days = 0;
        if (isLeapYear(year)) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;

                default:
                    days = 29;
                    break;

            }
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;

                default:
                    days = 28;
                    break;

            }


        }


        return days;
    }


    // 1e. A method to check whether the due date has passed
    public static Boolean dueDateHasPassed(String c, String d) {

        //c = current, d = due
        return  ((getYear(c) > getYear(d)) ||
                ((getYear(c) == getYear(d)) && (getMonth(c) > getMonth(d))) ||
                ((getYear(c) == getYear(d)) && (getMonth(c) == getMonth(d)) && (getDay(c) >= getDay(d))));
    }


    // 1f. A method to count the number of days left before the due date
    public static int countDaysLeft(String current, String due) {

        // Initializing year and leapYears variables
        int years = 0;
        int leapYears = 0;

        // Return 0 if the due date has already passed
        if (dueDateHasPassed(current, due)) {
            return 0;

        // Rest of code for a valid set of dates
        }
        else {
            // ---------------YEARS---------------
            // Loop for how many years/leapYears left until due
            for (int i = getYear(due); i > getYear(current); i--) {

                if (isLeapYear(i)) {
                    leapYears++;
                }
                else {
                    years++;
                }
            }
            // Formula for days left from the years left (not including current year)
            int daysFromYears = (years * 365) + (leapYears * 366);
            // ---------------YEARS---------------


            // ---------------MONTHS--------------
            // Months left to count from current year
            int daysFromMonths = 0;

            // Add months from current to due
            if (getMonth(current) < (getMonth(due) - 1)) {
                for (int j = getMonth(current); j < getMonth(due); j++) {
                    daysFromMonths += getDaysInAMonth(j, getYear(current));
                }
            }
            // Subtract the extra months (due year is current + 1)
            else if (getMonth(current) > getMonth(due) && getYear(current) == (getYear(due) - 1)) {

                for (int i = getMonth(due); i < getMonth(current); i++) {
                    daysFromMonths -= getDaysInAMonth(i, getYear(current));
                }
            }
            // Subtract the extra months (otherwise)
            else if (getMonth(current) > getMonth(due) && !(getYear(current) == (getYear(due) - 1))) {
                for (int i = getMonth(due); i <= getMonth(current); i++) {
                    daysFromMonths -= getDaysInAMonth(i, getYear(current));
                }
            }
            // ---------------MONTHS--------------


            // ---------------DAYS----------------

            // Days left to count from current month
            int days = 0;
            // Count due - current days
            if (getDay(current) < getDay(due)) {
                days = getDay(due) - getDay(current);
            }
            // Total in month - current day + due day
            else if (getDay(current) > getDay(due)){
                days = (getDaysInAMonth(getMonth(current), getYear(current)) - getDay(current) + getDay(due));
            }
            // ---------------DAYS----------------


            // ---------------TOTAL---------------
            // Adding up all the days calculated before
            return days + daysFromMonths + daysFromYears;
        }


    }


    // 1g. A method to diplay the countdown required
    public static void displayCountdown(String dueDate) {
        System.out.println("Today is: " + getCurrentDate());
        System.out.println("Due date: " + dueDate);
        if (dueDateHasPassed(getCurrentDate(),dueDate)){
            System.out.println("The due date has passed! :( Better luck next time!");
        }
        else {
            System.out.println("You have " + countDaysLeft(getCurrentDate(),dueDate) + " days left. You can do it!");
        }


    }


}