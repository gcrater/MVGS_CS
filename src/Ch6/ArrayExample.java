package Ch6;

public class ArrayExample {

    public static void main(String[] args) {
        String[][] fullName = {

                { "Casey", "Byron", "Corcoran" }, { "Grace", "Emily", "Crater" }, { "Kathryn", "Evelle", "Costanzo" },
                { "Seungyeon", "", "Kim" }, { "Seth", "Gabriel", "Patterson" }, { "Taylor", "Elizabeth", "DeHaven" },
                { "Heather", "Dawn", "Wotton" }, { "Mark", "Douglas", "Zitzmann" }, { "Vineeta", "", "Ribeiro" } };

        for (int i = 0; i < args.length; i++) {
            System.out.println(fullName[i][0]);
        }

    }

}
