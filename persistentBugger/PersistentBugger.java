package CodeWarriors.persistentBugger;

public class PersistentBugger {
    public static void main(String[] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(999));
        System.out.println(persistence(4));
    }
    public static int persistence(long n) {
        int counter = 0;
        while (Long.toString(n).length() > 1){
            long number = n;
            long product = 1;
            while (number != 0) {
                long digit = number % 10;
                product *= digit;
                number /= 10;
            }
            n = product;
            counter++;
        }
        return counter;
    }
}
