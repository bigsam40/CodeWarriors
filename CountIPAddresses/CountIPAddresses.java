package CodeWarriors.CountIPAddresses;

public class CountIPAddresses {
    // for tests
    public static void main(String[] args) {
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("192.168.1.1", "255.255.255.0"));
    }

    // target method
    public static long ipsBetween(String start, String end) {
        return Math.abs(getNumericIpView(start) - getNumericIpView(end));
    }

    public static long getNumericIpView(String ipAddress) {
        long numericIpView = 0;
        try {
            String[] octets = ipAddress.split("\\.");
            for (int i = 0; i < 4; i++) {
                numericIpView += (Math.pow(256, 3 - i) * Integer.parseInt(octets[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return numericIpView;
    }
}
