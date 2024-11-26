public class WindChill {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide temperature (t) and wind speed (v) as command-line arguments.");
            return;
        }

        double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);

        if (Math.abs(t) > 50 || v > 120 || v < 3) {
            System.out.println("The formula is not valid for the given inputs.");
        } else {
            double windChill = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
            System.out.println("The wind chill is: " + windChill);
        }
    }
}
