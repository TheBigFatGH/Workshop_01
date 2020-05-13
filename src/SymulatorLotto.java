import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.compare;

public class SymulatorLotto {
    public static void main(String[] args) {


        System.out.println("Podaj swoje skreslenia:");
        int[] playerChoose = playerChoose();
        System.out.println("Wybrane liczby przez gracza: ");
        System.out.println(Arrays.toString(playerChoose));

        int[] lottoTab = lotto();
        int[] drawnSixNum = winnerNum(lottoTab);
        System.out.println("Wylosowane liczby: ");
        System.out.println(Arrays.toString(drawnSixNum));

        didWin(playerChoose,drawnSixNum);



    }

    private static void didWin(int[] playerChoose, int[] drawnSixNum) {
        int score = 0;
        for(int i = 0; i < playerChoose.length; i++){
            for(int j = 0; j <drawnSixNum.length; j++){
                if(playerChoose[i] == drawnSixNum [j]){
                    score++;
                }
            }
        }
        if(score >= 3){
            System.out.println("Trafiles przynajmniej trojke");
        }

    }

    private static int[] winnerNum(int[] lottoTab) {
        int[] winnerNum = new int[6];

        for (int i = 0; i < winnerNum.length; i++) {
            int r = generateRandomNum(lottoTab.length - i);
            winnerNum[i] = lottoTab[r];
            lottoTab[r] = lottoTab[lottoTab.length - i - 1];
            lottoTab[lottoTab.length - i - 1] = r;
        }
        Arrays.sort(winnerNum);
        return winnerNum;
    }

    private static int generateRandomNum(int range) {
        Random r = new Random();

        return r.nextInt(range + 1) + 1;
    }

    private static int[] lotto() {
        int[] lotto = new int[49];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = i + 1;
        }
        return lotto;
    }


    private static int[] playerChoose() {
        int[] lottoNum = new int[6];
        for (int i = 0; i < lottoNum.length; i++) {
            System.out.println("Strzal " + (i + 1) + " : ");
            int num = numReader();
            while (!checkNum(num, lottoNum)) {
                num = numReader();
            }
            lottoNum[i] = num;
        }
        Arrays.sort(lottoNum);
        return lottoNum;
    }

    private static boolean checkNum(int num, int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == num) {
                System.out.println("Wartosc " + num + " juz byla");
                return false;
            }
            if (num < 1 || num > 49) {
                System.out.println("Wartosc " + num + " poza zasiegiem");
                return false;
            }
        }
        return true;
    }

    private static int numReader() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe:");
        while (!scanner.hasNextInt()) {
            System.out.println("Podana wartosc nie jest liczba calkowita");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
