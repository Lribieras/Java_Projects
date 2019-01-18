// name: Louis Ribieras
// ID : 260631416

import java.util.Arrays;

public class ExamGrading {


    public static void main(String args[]) {

        char[][] responses =    {{'C', 'A', 'B', 'B', 'C', 'A'}, {'A', 'A', 'B', 'B', 'B', 'B'},
                                {'C', 'B', 'A', 'B', 'C', 'A'}, {'A', 'B', 'A', 'B', 'B', 'B'}};
        char[] solutions =      {'C', 'A', 'B', 'B', 'C', 'C'};
        System.out.println(Arrays.toString(gradeAllStudents(responses, solutions)));

        char[] response1 =  {'A', 'B', 'C', 'D', 'C', 'A'};
        char[] response2 =  {'A', 'B', 'D', 'B', 'B', 'A'};
        char[] solution =   {'C', 'B', 'C', 'D', 'A', 'A'};
        System.out.println(numWrongSimilar(response1,response2,solution));

        System.out.println(numMatches(responses, solutions, 0, 1));

        System.out.println(Arrays.deepToString(findSimilarAnswers(responses, solutions,1)));

    }

    // Question 1.
    public static double[] gradeAllStudents(char[][] responses, char[] solution) {

        // Checking to see if all students answered all the questions, throw error
        for (int i = 0; i < responses.length; i++) {

            if (responses[i].length != solution.length){
                throw new IllegalArgumentException("Student " + i + " answered " + responses.length + " questions instead of " + solution.length);
            }
        }

        double[] finalGrades = new double[responses.length];
        double[][] grades = new double[responses.length][solution.length];

        // loop through each response array
        for (int i = 0; i < responses.length; i++) {


            // loop through each answer in ith response array
            // and give 1 if correct and 0 if incorrect
            for (int j = 0; j < responses[i].length; j++) {

                // correct
                if (responses[i][j] == solution[j]) {
                    grades[i][j] = 1;
                }
                // incorrect
                else if (responses[i][j] != solution[j]) {
                    grades[i][j] = 0;
                }

            }

            // calculate each student's grade and put in finalGrades

            double score = 0;
            for (int k = 0; k < responses[i].length; k++) {
                score += grades[i][k];
            }

            finalGrades[i] = 100 * (score / responses[i].length);
        }

        return finalGrades;

    }

    // Question 2.

    // (a) Number of similar incorrect answers
    public static int numWrongSimilar(char[] response1, char[] response2, char[] solutions) {

        // throw an error if lengths do not match
        if (!(response1.length == response2.length && response2.length == solutions.length)){
            throw new IllegalArgumentException("Lengths of responses and solutions do not match");
        }

        int numWrong = 0;

        for (int i = 0; i < solutions.length; i++) {
            if (response1[i] == response2[i] && response2[i] != solutions[i]){
                numWrong++;
            }
        }

        return numWrong;

    }

    // (b) Number of matches that student has with other students
    public static int numMatches(char[][] responses, char[] solution, int studentIndex, int threshold) {


        int numMatched = -1;


        // loop through each students' response array
        for (int i = 0; i < responses.length; i++) {

            if (numWrongSimilar(responses[studentIndex], responses[i], solution) >= threshold) {
                numMatched++;
            }

        }
        // in the case where student get 100% and therefore shares no wrong answers
        if (numMatched < 0) {
            numMatched = 0;
        }

        return numMatched;
    }

    // (c)
    public static int[][] findSimilarAnswers(char[][] responses, char[] solution, int threshold) {

        // initializing the final output multidimensional array
        int[][] similarStudents = new int[responses.length][0];

        // loop through each student response array
        for (int i = 0; i < responses.length; i++) {
            // setting the length of each subArray to numMatches
            similarStudents[i] = new int[numMatches(responses, solution, i, threshold)];
        }

        // loop through all the students
        for (int i = 0; i < responses.length; i++) {

            // loop through each i's possible number of matches
            for (int j = 0; j < similarStudents[i].length; j++) {

                // loop through all the students that could have matched
                for (int k = 0; k < responses.length; k++) {

                    // if it's not the same student and numWrongSimilar is >= threshold
                    if (k != i && numWrongSimilar(responses[i], responses[k], solution) >= threshold) {
                        similarStudents[i][j] = k;
                        j++;
                    }


                }


            }

        }




        return similarStudents;

    }

}
