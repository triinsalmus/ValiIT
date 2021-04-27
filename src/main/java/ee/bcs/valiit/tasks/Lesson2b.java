package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {
        exercise1(6);
        System.out.println(Arrays.toString(sampleArray()));
        System.out.println(Arrays.toString(generateArray(7)));
        System.out.println(Arrays.toString(decreasingArray(-3)));
        System.out.println(Arrays.toString(yl3(4)));


    }

    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static void exercise1(int n) { //tahame kuskil anda sisendi, mis tähistab n-i pikkust ja vastavalt sellele
        //numbrid trükkida
        for (int i = 1; i <= n; i++) { //alustame 1-st, me ei taha 0 alustada jada, ja kui määrame n-i kuskil
            //siis peab pikkus olema alati max sama suur kui n
            //määra n main methodis
            System.out.println(i); //peab trükkima, sest see on void method
        }
    }


    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() { //siin pole antud nõutavat sisendit
        //lihtlabane versioon:
        int[] numbers = {1, 2, 3, 4, 5};
        return numbers;
        //kõige lihtsam lahendus:
        //return new int []{1,2,3,4,5};
        //saab ka nii nagu järgmise ülesande:
//        int[] numbers = new int[5]; //sellega määrame ära, mitu väärtust asub arrays?
//        for (int i = 0; i < numbers.length; i++) { //alustame nullist lugemist
//            numbers[i] = i + 1; //kuna alustasime nullist lugemist, siis paneme +1 juurde
//        }
//        return numbers;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) { //n ongi juba pikkus, array käest saame .length võtta
        int[] numbers = new int[n]; //sellega määrame ära, mitu väärtust asub arrays?
        for (int i = 0; i < numbers.length; i++) { //alustame nullist lugemist
            numbers[i] = i + 1; //kuna alustasime nullist lugemist, siis paneme +1 juurde
        }
        return numbers;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        int size = n;
        if (n > 0) {
            int[] array = new int[size + 1];
            for (int i = size; i >= 0; i--) {
                array[i] = n - i; //array kohal i asub number n miinus i
            }
            //või luua ka int indeks=0; - seame esimeseks asukohaks 0
            // ja fori sees array[index]=i; - saame esimesel asukohal 0 oleva väärtuse i
            //index++; - suurendame asukohta 0 järgmiseks (1), millele uue loopi ringiga saame väärtuse
            return array;
        } else {
            int[] array = new int[-size + 1];
            for (int i = size; i <= 0; i++) {
                array[-i] = n - i;
            }
            return array;
        }
        //või:
//        int[] array = new int[Math.abs(n) + 1]; //teed absoluutväärtuse n-ist
//        int index = 0; //ütleme, et esimene asukoht arrays on 0
//        while (n != 0) { //kontrollime, kui n on antud kõik muu peale 0
//        array[index] = n; //määrame, et selle loopi sees on index asukohas n number
//            if (n > 0) {
//                n = n - 1; //siin ütleme, et n väärtus on -1
//            } else {
//                n = n +1; //kuna n on negatiivne, siis peame tagurpidi minema
//            }
//            index++; //suurendame iga kord indexi väärtust ja lähme uuesti loopi suurema indexiga
//        }
//        return array;


    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int[n]; //uus array, milles on n kohta (indexit)
        for (int i = 0; i < n; i++) { //ei saa panna "<=" sest me ei taha tulemust, kui pannakse n=0
            array[i] = 3; //igal kohal on 3
        }
        return array;
    }
}
