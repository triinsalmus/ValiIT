package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //System.out.println(reverseString("TERE olen Triin"));
        //System.out.println(isPrime(217));
        //System.out.println(Arrays.toString(sort(new int[]{5, 2, 4, 3, 1})));
        //System.out.println(evenFibonacci(40));
        //System.out.println(morseCode("sos"));
        //System.out.println(morseCode("hello"));

    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int total = x; //total on x, sest pärast korrutan seda (x-1)-ga
        for (int i = x; i > 1; i--) { //määran, et loopin x-ist allapoole kuni 1-ni
            int n = x - 1; //iga kord x väheneb ühe võrra
            total = total * n;//iga kord korrutan x vähendatud x-ga
            x--;//ja iga kord x väheneb
        }
        return total;

        //teine variant:
//        int total = x;
//        for (int i = 1; i < x; i++) {
//            total = total * i;
//        }
//        return total;

    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String reverse = ""; //tagurpidi Stringi tarbeks uus tühi String, mida saab loopiga täitma hakata
        for (int i = a.length() - 1; i >= 0; i--) { //alustame kohalt i, mis on TERE puhul 4-1=3 ja tuleme nullini välja
            reverse += a.charAt(i);
        }
        return reverse;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x == 0 || x == 1) { //0 ja 1 välistame - pole primaarid
            return false;
        } else {
            int i = 2; //alustame loopimist 2-st, sest 1-ga jagunevad kõik
            while (i < x) { //iseendaga jagunevad kõik, seetõttu i peab olema väiksem kui x kontrollimiseks
                if (x % i == 0) { //kui x/i jätab 0 komakohta, siis ei ole primaararv ehk false
                    return false;
                } else {
                    i++; //vastasel juhul mine edasi ja suurenda i testiks
                }
            }
            return true; //kui ei leia i-d, millega jaguneb, siis on true ehk primaararv
        }
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        System.out.println("Original array: " + Arrays.toString(a));
        for (int j = 1; j < a.length; j++) {
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i]) {
                    int temporary = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = temporary;
                }
            }
        }
/**
 * minu lahendus õpetaja abiga:
 */
//        for (int i = 0; i < a.length; i++) { //alustame 1. loopiga, kus võrdleme a pikkust määratud 0-kohaga (pikkus!=index)
//            int minValue = a[i]; //ütleme, et min väärtus on asukohas 0
//            int index = i;
//
//            for (int j = i + 1; j < a.length; j++) {
//                if (minValue > a[j]) {
//                    minValue = a[j];
//                    index = j;
//                }
//            }
//            int temp = a[i]; //vahetab väiksema ja suurema kohad
//            a[i] = a[index];
//            a[index] = temp;
//        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x //va x (1-10, aga va 10)
        if (x == 0) {
            return 0;
        }
        int üleEelmine = 0; //kui n==0
        int eelmine = 1; //n=1
        int paarisSum = 0;
        for (int i = 1; i < x; i++) {// kui i<=n, siis i=2
            int sum = eelmine + üleEelmine; //mida sissepoole muutuja saab panna, seda parem - ainult korraks vaja seda muutujat siin
            üleEelmine = eelmine;
            eelmine = sum;
            if (eelmine > x) {
                break;
            }
            if (eelmine % 2 == 0) {
                paarisSum += eelmine;
            }

        }
        return paarisSum;

    }

    public static String morseCode(String text) { //lahendamata
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map<Character, String> morse = new HashMap<>();

        morse.put('e', ".");
        morse.put('h', "....");
        morse.put('l', ".-..");
        morse.put('o', "---");
        morse.put('s', "...");

//        for (int i = 0; i < text.length(); i++) {
//            char charText = text.charAt(i);
//            System.out.print(morse.get(charText));
//            System.out.print(" ");
//        }
//        return "";
        String result = "";
        for (char a : text.toCharArray()) {
            result += morse.get(a) + " ";
        }
        return result.trim();
    }
}
