package projects;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Program prints out a professor or student copy of the scores sheet 
 * with 10 names input by the user, a calculated numerical ID, a 
 * score, and letter grade corresponding to their score. 
 * 
 * Gracie Crater
 * 12/5/17
 */

public class ArrayPlay {
    static Scanner scan = new Scanner(System.in);
    // public constant arrays of scores and corresponding letter grades
    static final int[] SCORES = { 79, 87, 94, 82, 67, 98, 87, 81, 74, 91 };
    static final Set UNIQUE = new HashSet(); // a set that only allows unique values

    public static void main(String[] args) {

        // purpose/explanation
        System.out.println("This program allows user to enter 10 student names and will "
                + "\noutput student exam scores along with student's unique ID.");
        System.out.println();

        String[] grades = scoreToLetter(SCORES);

        String[] names = getNames();
        int[] ids = calcIDs(names);

        System.out.println();
        System.out.println("Which copy of the score sheet would you like to print? [professor/student/both]");
        String copy = scan.nextLine();
        System.out.println();
        if (copy.equalsIgnoreCase("professor")) {
            printProfessorCopy(names, ids, grades);
        }
        if (copy.equalsIgnoreCase("both")) {
            printProfessorCopy(names, ids, grades);
            System.out.println();
            printStudentCopy(names, ids, grades);
        }
        if (copy.equalsIgnoreCase("student")) {
            printStudentCopy(names, ids, grades);
        }
        System.out.println();
    }

    private static String[] scoreToLetter(int[] SCORES) {
        String[] grades = new String[10];
        for (int i = 0; i < SCORES.length; i++) {
            if (SCORES[i] >= 90) {
                grades[i] = "A";
            }
            if (SCORES[i] >= 80 && SCORES[i] < 90) {
                grades[i] = "B";
            }
            if (SCORES[i] >= 70 && SCORES[i] < 80) {
                grades[i] = "C";
            }
            if (SCORES[i] >= 60 && SCORES[i] < 70) {
                grades[i] = "D";
            }
            if (SCORES[i] < 60) {
                grades[i] = "F";
            }
        }
        return grades;
    }

    private static String[] getNames() {
        // @param = no parameter
        // @return = names (converted to lowercase) arranged in array
        String[] namesArray = new String[SCORES.length];
        int namecounter = 0; // track names collected so far

        while (namecounter < SCORES.length) {
            System.out.print("Enter student name (first names only):  "); // prompt user for a name
            String name = scan.nextLine().toLowerCase().trim(); // .trim() removes whitespace

            // set returns true if name is unique to set (is only added to set if unique)
            boolean unique = UNIQUE.add(name);
            if (unique) {
                namesArray[namecounter++] = name;
            }
            else {
                // tell the user they can't reuse a name
                System.out.println("\n\"" + name + "\" has already been used. Please enter another name. \n");
            }
        }
        return namesArray;
    }

    private static int[] calcIDs(String[] namesArray) {
        // @param = the array of names (namesArray) declared/initialized in getNames()
        // @return = array of unique ID's for each student in namesArray

        // “MAY” --> M*1 + A*2 + Y*3
        int[] ids = new int[SCORES.length];

        for (int i = 0; i < namesArray.length; i++) {
            String student = namesArray[i];
            // turn student name (which is a String) into a char array to calculate ID based
            // on formula with letter position and value
            char[] characters = student.toCharArray();

            int id = 0;

            for (int j = 0; j < characters.length; j++) {
                int asciiVal = (int) characters[j];

                // number for THAT character at position in name
                int charVal = (asciiVal - 96) * (j + 1);
                id += charVal; // add up all individual values for ID
            }
            ids[i] = id; // assign each ID to a slot in 'ids' array
        }
        return ids;
    }

    private static void printProfessorCopy(String[] names, int[] ids, String[] grades) {
        // @param = 2 arrays -- one of student names, one of corresponding IDs
        // @return = void

        System.out.println();
        System.out.println("FRESHMAN HONORS SEMINAR - EXAM 1 (PROFESSOR COPY)"); // includes students' names
        System.out.println("Student ID\tStudent Name\tScore(%)\tLetter Grade  \n");
        for (int i = 0; i < SCORES.length; i++) {
            System.out.println("  " + ids[i] + "\t\t" + names[i] + "\t\t  " + SCORES[i] + "\t\t  " + grades[i]);
        }
    }

    private static void printStudentCopy(String[] names, int[] ids, String[] grades) {
        // @param = 2 arrays -- one of student names, one of corresponding IDs
        // @return = void
        System.out.println("FRESHMAN HONORS SEMINAR - EXAM 1"); // exclude students' names
        System.out.println("Student ID\tScore(%)\tLetter Grade  \n");
        for (int i = 0; i < SCORES.length; i++) {
            System.out.println("  " + ids[i] + "\t\t  " + SCORES[i] + "\t\t  " + grades[i]);
        }
    }

}