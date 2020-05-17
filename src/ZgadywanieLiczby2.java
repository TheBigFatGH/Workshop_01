import java.util.Scanner;

public class ZgadywanieLiczby2 {
    public static void main(String[] args) {

        System.out.println("Pomysl liczne od 0 do 1000, a ja ją zgadnę w max. 10 próbach");
        int min = 0;
        int max = 1000;
        boolean playagian = true;
        int count = 1;
        int guess;


        while (playagian) {
            if (count == 11) {
                System.out.println("Pewnie oszukiwales");
                break;

            }
            guess = ((max - min) / 2) + min;
            System.out.println("Proba " + count);
            System.out.println("Zgaduje: " + guess);


            String answer = answer();


            if ("zgadles".equals(answer)) {
                System.out.println("Wygrałem");
                playagian = false;
            } else if ("za duzo".equals(answer)) {
                max = guess;
                count++;
            } else if ("za malo".equals(answer)) {
                min = guess;
                count++;
            } else {
                System.out.println("Nie oszukuj!");
            }

        }


    }

    private static String answer() {
        Scanner scanner = new Scanner(System.in);
        String check = null;
        while(true){
            check = scanner.nextLine();
            if("za duzo".equals(check)){
                return check;
            } else if ("za malo".equals(check)){
                return check;
            } else if ("zgadles".equals(check)){
                return check;
            }
            System.out.println("Mozesz odpowiedz: za malo, za duzo, zgadles");
        }
    }
}


