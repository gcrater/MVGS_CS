package FactCalendar;

public class Fact {
    private String fact;
    private static String date;
    private static int count = 0;

    public Fact(String str) {
        fact = str;
        System.out.println();
        count++;
    }

    public String toString() {
        return fact;
    }

    public static String setDate(String weekday, String month, String day) {
        date = "Fact for " + weekday + ", " + month + " " + day + " = ";
        return date;
    }

    public static int getCount() {
        return count;
    }
}
