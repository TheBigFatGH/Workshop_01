import java.util.Scanner;
import java.util.Random;

public class ZgadywanieLiczby {
    public static void main(String[] args) {

        System.out.println("Twoje zadanie polega na zgadanieciu liczby");
        int seeking = generateRandomNum();
        System.out.println(seeking);
        int guess = numReader();
        checkWinCon(guess, seeking);


    }

    private static void checkWinCon(int guess, int seeking) {
        while (seeking != guess) {
            if (seeking > guess) {
                System.out.println("Za mało!");
                guess = numReader();
            } else if (seeking < guess) {
                System.out.println("Za dużo!");
                guess = numReader();
            }
        }
        System.out.println("Zgadłeś!");
    }

    private static int generateRandomNum() {
        Random r = new Random();

        return r.nextInt(101) + 1;
    }

    private static int numReader() {

        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe:");
        while (!scanner.hasNextInt()) {
            System.out.println("Podana wartosc nie jest liczba calkowita");
            scanner.nextLine();
        }

        num = scanner.nextInt();
        return num;
    }
}
