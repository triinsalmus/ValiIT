package ee.bcs.valiit.tasks;

import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
//        Random random = new Random(); //kui seda kasutada, see on Javal algsena olemas ja impordib üles ka
//        int i = random.nextInt(100);
//        System.out.println(i);

        int random = (int) (Math.random() * 100 - 1);
        //System.out.println(random);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a number between 0-99: ");
        int enteredNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i <= enteredNumber; i++) {
            if (enteredNumber < random) {
                System.out.print("Your number was smaller, guess again: ");
            } else if (enteredNumber > random) {
                System.out.print("Your number was greater, guess again: ");
            } else {
                System.out.println("Correct, you won!");
                System.out.println("It took you " + i + " attempts!");
                break;
            }
            enteredNumber = scanner.nextInt();
        }
    }
}
