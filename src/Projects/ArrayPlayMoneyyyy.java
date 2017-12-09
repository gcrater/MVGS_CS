package Projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Program prints out a professor or student copy of the scores sheet with 10
 * names input by the user, a calculated numerical ID, a score, and letter grade
 * corresponding to their score.
 * 
 * Gracie Crater 12/5/17
 */
public class ArrayPlayMoneyyyy {
    static Scanner scan = new Scanner(System.in);
    // public constant arrays of scores and corresponding letter grades
    static final int[] SCORES = { 79, 87, 94, 82, 67, 98, 87, 81, 74, 91 };
    static final Set<String> UNIQUE = new HashSet<String>(); // a set that only allows unique values
    static final List<Student> STUDENTS = new ArrayList<Student>();

    public static void main(String[] args) {

        // purpose/explanation
        System.out.println("This program allows user to enter 10 student names and will "
                + "\noutput student exam scores along with student's unique ID.");
        System.out.println();

        getNames(); // calls all methods from within

        System.out.println();
        System.out.println("Which copy of the score sheet would you like to print? [professor/student/both]");
        String copy = scan.nextLine();
        System.out.println();
        if (copy.equalsIgnoreCase("professor")) {
            printProfessorCopy();
        }
        if (copy.equalsIgnoreCase("both")) {
            printProfessorCopy();
            System.out.println();
            printStudentCopy();
        }
        if (copy.equalsIgnoreCase("student")) {
            printStudentCopy();
        }
        System.out.println();
    }

    private static String scoreToLetter(int score) {
        String grade = "";
        if (score >= 90) {
            grade = "A";
        }
        if (score >= 80 && score < 90) {
            grade = "B";
        }
        if (score >= 70 && score < 80) {
            grade = "C";
        }
        if (score >= 60 && score < 70) {
            grade = "D";
        }
        if (score < 60) {
            grade = "F";
        }
        return grade;
    }

    /**
     * Asks user for unique name then creates instance of Student for each name,
     * then computes ID, assigns grade and score. Populates static List of
     * {@link Student}s to sort by score later.
     */
    private static void getNames() {
        int namecounter = 0; // track names collected so far

        while (namecounter < SCORES.length) {
            System.out.print("Enter student name (first only):  "); // prompt user for a name
            String name = scan.nextLine().toLowerCase().trim(); // .trim() removes whitespace

            // set returns true if name is unique to set (is only added to set if unique)
            boolean unique = UNIQUE.add(name);
            if (unique) {
                // created new Student from class student
                Student student = new Student(name);
                // set student values
                student.score = SCORES[namecounter++];
                student.grade = scoreToLetter(student.score);
                student.id = calcID(name);
                STUDENTS.add(student);
            }
            else {
                // tell the user they can't reuse a name
                System.out.println("\n\"" + name + "\" has already been used. Please enter another name. \n");
            }
        }
    }

    private static int calcID(String name) {
        // @param = the array of names (namesArray) declared/initialized in getNames()
        // @return = array of unique ID's for each student in namesArray

        // “MAY” --> M*1 + A*2 + Y*3
        char[] characters = name.toCharArray();

        int id = 0;
        for (int j = 0; j < characters.length; j++) {
            int asciiVal = (int) characters[j];

            // number for THAT character at position in name
            int charVal = (asciiVal - 96) * (j + 1);
            id += charVal; // add up all individual values for ID
        }
        return id;
    }

    /**
     * Prints professor's copy of student scores sorted alphabetically by name.
     */
    private static void printProfessorCopy() {

        STUDENTS.sort(new NameComparator());

        System.out.println();
        System.out.println("FRESHMAN HONORS SEMINAR - EXAM 1 (PROFESSOR COPY)");
        System.out.println("Student ID\tStudent Name\tScore(%)\tLetter Grade  \n");

        for (Student student : STUDENTS) {
            System.out.println(
                    " " + student.name + "\t\t" + student.id + "\t\t " + student.score + "\t\t  " + student.grade);
        }
    }

    /**
     * Prints student copy sorted from highest to lowest by score. Excludes student
     * names.
     */
    private static void printStudentCopy() {
        System.out.println("FRESHMAN HONORS SEMINAR - EXAM 1");
        System.out.println("Student ID\tScore(%)\tLetter Grade  \n");

        STUDENTS.sort(new ScoreComparator());
        for (Student student : STUDENTS) {
            System.out.println(" " + student.id + "\t\t " + student.score + "\t\t  " + student.grade);
        }
    }
}

class Student {
    Integer score;
    String grade;
    String name;
    int id;

    /**
     * Create a student, set the instance variable name with provided parameter.
     * 
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student1.name.compareTo(student2.name); // alphabetical order
    }
}

class ScoreComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student2.score.compareTo(student1.score); // highest to lowest
    }
}