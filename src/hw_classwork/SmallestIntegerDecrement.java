package tbkHW;

public class SmallestIntegerDecrement {

    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int count = 0;

        for (int i = min; i <= 0; i++) {
            System.out.println("Count:  " + count + "\tmin: " + (i) + "\tmax: " + (-i));
            count++;
        }
    }
}
