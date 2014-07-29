package converter;

/**
 * @author Jiri
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            printHelp();
            System.exit(1);
        }
        String[] input = args[0].split(" ");
        if (input.length != 4) {
            printHelp();
            System.exit(1);
        }

        Units fromUnit = null;
        Double fromValue = null;
        Units toUnit = null;
        try {
            fromValue = Double.valueOf(input[0]);
            fromUnit = Units.translate(input[1]);
            toUnit = Units.translate(input[3]);
        } catch (RuntimeException e) {
            printHelp();
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.format("%s %s equals %f %s\n", input[0], input[1], fromUnit.convert(fromValue, toUnit), input[3]);
    }

    private static void printHelp() {
        System.out.println("The program accepts only 1 string parameter of the form \"10 cm in m\"");
        System.out.println("The following units are allowed: m, cm, in, ft, yd");
    }
}
