package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vali, mida soovid arvutada:");
        System.out.println(" 1 - min a-st ja b-st");
        System.out.println(" 2 - max a-st ja b-st");
        System.out.println(" 3 - arvu absoluutväärtus");
        System.out.println(" 4 - paaris- ja paaritu arv");
        System.out.println(" 5 - min a-st, b-st ja c-st");
        System.out.println(" 6 - max a-st, b-st ja c-st");

        int valem = scanner.nextInt(); //loeme sisse ühe numbri
/**
 * siin switch valemiga:
 */
        switch (valem) {
            case 1:
                System.out.println("Sisesta a:");
                int a = scanner.nextInt();
                System.out.println("Sisesta b:");
                int b = scanner.nextInt();
                System.out.println("a-st ja b-st väikseim on: " + min(a, b));
                break;
            case 2:
                System.out.println("Sisesta a ja b:");
                int a2 = scanner.nextInt();
                int b2 = scanner.nextInt();
                System.out.println("a-st ja b-st suurim on: " + max(a2, b2));
                break;
            case 3:
                System.out.println("Sisesta number:");
                int a3 = scanner.nextInt();
                System.out.println("Arvu " + a3 + " absoluutväärtus on " + (abs(a3)));
                break;
            case 4:
                System.out.println("Sisesta number:");
                int a4 = scanner.nextInt();
                if (isEven(a4)) {
                    System.out.println("Arv on paarisarv.");
                } else {
                    System.out.println("Arv on paaritu arv.");
                }
                break;
            case 5:
                System.out.println("Sisesta a, b ja c:");
                int a5 = scanner.nextInt();
                int b5 = scanner.nextInt();
                int c5 = scanner.nextInt();
                System.out.println("Arvudest suurim on " + (max3(a5, b5, c5)));
                break;
            case 6:
                System.out.println("Sisesta a, b ja c:");
                int a6 = scanner.nextInt();
                int b6 = scanner.nextInt();
                int c6 = scanner.nextInt();
                System.out.println("Arvudest väikseim on " + (min3(a6, b6, c6)));
                break;
            default:
                System.out.println("Sisestatud on vigane number");
                break;
        }


/**
 * siin arvutab ifidega ja vaid ühte valemit korraga:
 */
//        if (valem == 1) {
//            System.out.println("Sisesta a:");
//            int a = scanner.nextInt();
//            System.out.println("Sisesta b:");
//            int b = scanner.nextInt();
//            System.out.println("a-st ja b-st väikseim on: " + min(a, b));
//        } else if (valem == 2) {
//            System.out.println("Sisesta a ja b:");
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            System.out.println("a-st ja b-st suurim on: " + max(a, b));
//        } else if (valem == 3) {
//            System.out.println("Sisesta number:");
//            int a = scanner.nextInt();
//            System.out.println("Arvu " + a + " absoluutväärtus on " + (abs(a)));
//        } else if (valem == 4) {
//            System.out.println("Sisesta number:");
//            int a = scanner.nextInt();
//            if (isEven(a)) {
//                System.out.println("Arv on paarisarv.");
//            } else {
//                System.out.println("Arv on paaritu arv.");
//            }
//        } else if (valem == 5) {
//            System.out.println("Sisesta a, b ja c:");
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int c = scanner.nextInt();
//            System.out.println("Arvudest suurim on " + (max3(a, b, c)));
//        } else {
//            System.out.println("Sisesta a, b ja c:");
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int c = scanner.nextInt();
//            System.out.println("Arvudest väikseim on " + (min3(a, b, c)));
//        }


        /**
         * siin jookseb järjest ülesanne:
         */
//        System.out.println("Sisesta min a:");
//        int a = scanner.nextInt();
//        System.out.println("Sisesta min b:");
//        int b = scanner.nextInt();
//        System.out.println("a-st ja b-st väikseim on: " + min(a, b));
//
//
//        System.out.println("Sisesta max a:");
//        int maxa = scanner.nextInt();
//        System.out.println("Sisesta max b:");
//        int maxb = scanner.nextInt();
//        System.out.println("a-st ja b-st suurim on: " + max(maxa, maxb));
//
//
//        System.out.println("Sisesta arv absoluutväärtuse leidmiseks:");
//        int absa = scanner.nextInt();
//        System.out.println("Arvu absoluutväärtus on: " + abs(absa));
//
//
//        System.out.println("Sisesta arv paarisarvu tuvastamiseks:");
//        int isEven = scanner.nextInt();
//        if (isEven(isEven)) {
//            System.out.println("Arv on paarisarv.");
//        } else {
//            System.out.println("Arv on paaritu arv.");
//        }
//
//
//        System.out.println("Sisesta min3 a:");
//        int min3a = scanner.nextInt();
//        System.out.println("Sisesta min3 b:");
//        int min3b = scanner.nextInt();
//        System.out.println("Sisesta min3 c:");
//        int min3c = scanner.nextInt();
//        System.out.println("a-st, b-st ja c-st väikseim on: " + min3(min3a, min3b, min3c));
//
//
//        System.out.println("Sisesta max3 a:");
//        int max3a = scanner.nextInt();
//        System.out.println("Sisesta max3 b:");
//        int max3b = scanner.nextInt();
//        System.out.println("Sisesta max3 c:");
//        int max3c = scanner.nextInt();
//        System.out.println("a-st, b-st ja c-st suurim on: " + max3(max3a, max3b, max3c));

    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= c && b <= a) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
//        if(a>=b && a>=c) {
//            return a;
//        } else if(b>=c && b>=a) {
//            return b;
//        } else {
//            return c;
//        }
        return max(max(a, b), c);
    }
}
