import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            while (!(line = scanner.nextLine()).equals("exit")) {
                System.out.println(calc(line));
            }
        }
    }

    public static String calc(String input) {

        return null;
    }


}
