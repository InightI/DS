import java.io.IOException;
import java.util.Scanner;

public class CheckOrUncheck {
    public static void methodA() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void methodB() throws IOException {
        throw new IOException();
    }

    public static void methodC() throws IOException {
        methodB();
    }

    public static void tryResource() {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextInt();
        }
    }

    public static void methodUncheck() throws RuntimeException {
        throw new RuntimeException();
    }
}
