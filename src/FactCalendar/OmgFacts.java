
package FactCalendar;

/**
 * Use another class to print put facts to the user.
 * 
 * @author (Gracie Crater)
 * @version (2/9/2018)
 */
public class OmgFacts {
    public static void main(String[] args) {

        Fact fact;

        fact = new Fact(
                "McDonald's daily customer traffic is 62 million -- greater than the population of Great Britain.");
        System.out.println(Fact.setDate("Wednesday", "January", "17"));
        System.out.println(fact);

        fact = new Fact("You burn more calories sleeping than watching television.");
        System.out.println(Fact.setDate("Thursday", "January", "18"));
        System.out.println(fact);

        fact = new Fact("In Alaska, it is illegal to whisper in someone's ear while they're moose hunting.");
        System.out.println(Fact.setDate("Friday", "January", "19"));
        System.out.println(fact);

        fact = new Fact("One pound of peanut butter can contain up to 150 bug fragments and five rodent hairs.");
        System.out.println(Fact.setDate("Saturday/Sunday", "January", "20/21"));
        System.out.println(fact);

        fact = new Fact(
                "King Charles I would place his 18 inch tall court dwarf between two halves of bread & pretend to eat him.");
        System.out.println(Fact.setDate("Monday", "January", "22"));
        System.out.println(fact);

        System.out.println();
        System.out.println("Facts delivered: " + Fact.getCount());
    }
}
