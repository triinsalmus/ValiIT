package ee.bcs.valiit.tasks;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println(fibonacci(7));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) { //inputArray väärtus tuleb ülevalt siis
        int length = inputArray.length; //kogu pikkus ehk ilma esimese 0-kohata
        int[] returnArray = new int[length]; //teeme uue array, mille pikkus on sama, nagu main methodis antud
        //anname sellele väärtused sisse:
        for (int i = length - 1; i >= 0; i--) { // esimene i peab olema kogupikkus -1, sest meil on ka 0-koht
            returnArray[i] = inputArray[length - i - 1]; //kohal i olev returnArray saab väärtuseks inputArray
            //mille pikkusest on maha arvatud i ja -1
        }
        return returnArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] numbers = new int[n]; //array suurusega n (täpselt sama, mis numbers.length)-> vaja kogu array ära täita
//        for (int i = 0; i < n; i++) {
//            numbers[i] = (i + 1) * 2;
//        }
//        return numbers;
//        või:
        int index = 0; //määrame, et esimene väärtus arrays on paarisarv
        for (int i = 2; i <= 2 * n; i++) {
            if (i % 2 == 0) { //kui on paarisnumber, siis:
                numbers[index] = i;
                index++;
            }
        }
        return numbers;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] arrayNimi) { //4 2 6 1 9
        int minElement = arrayNimi[0]; //anname min väärtuse esimesele indexile arrayst, et võrrelda teistega
        for (int i = 1; i < arrayNimi.length; i++) { //alustab 1. indexist võrdlemist eelnevalt määratud min 0-indexiga
            if (arrayNimi[i] < minElement) { //kui i kohal array element on väiksem kui määratud minElement
                minElement = arrayNimi[i]; //siis jäta uueks minElementi väärtuseks saadud arrayNimi i kohal
            }
        }
        return minElement; //tulemuseks saame min väärtuse
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxElement) {
                maxElement = x[i];
            }
        }
        return maxElement;

    }

    // TODO, leia massiivi kõigi elementide summa - peab olema muutuja ja tsükkel ja liidame need
    public static int sum(int[] x) {
        int length = x.length;
        int total = 0; //määrame, et alguses on total nullis
        for (int i = 0; i < length; i++) { //i=0 ehk algame 0-kohalt kontrollima, i peab olema alati väiksem kui kogupikkus
            total += x[i]; //total võrdub igal kohal olev indexi väärtus juurde liidetuna ehk lõpuks on kõik kokku liidetud
        }
        return total; //saame lõpuks kogu totali
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        for (int i = 1; i <= y; i++) { //läheb 1 kord loopi ja keerutab seal sees x kordi kuniks jälle siia tuleb - kokku y korda
            for (int j = 1; j <= x; j++) { //loop loopi sees käib etteantud loopi kordi siin
                System.out.print(j * i + " "); //vt i ja j eraldi ning mis loogika neil on
            }
            System.out.println(); //tühi sout teeb vaherea
        }


    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        if (n==0) {
            return 0;
        }
        int üleEelmine = 0; //kui n==0
        int eelmine = 1; //n=1
        for (int i = 1; i < n; i++) {// kui i<=n, siis i=2
            int sum = eelmine + üleEelmine; //mida sissepoole muutuja saab panna, seda parem - ainult korraks vaja seda muutujat siin
            üleEelmine = eelmine;
            eelmine = sum;
        }
        return eelmine;


        //lihtne kiire lahendus
//        if (n==0) {
//            return 0;
//        } else if (n==1) { //pm võiks iga positsiooniga teha sama else if
//            return 1;
//        } else {
//            return fibonacci(n-1) + fibonacci(n-2); //arvutab positsioonide tulemust
//        }

        //saab ka kuidagi nii:
//        int a = 0; //jada esimene nr on 0
//        int b = 1; //jada teine nr on 1
//        System.out.println(a + " " + b);
//        int c = 1; //jada kolmas arv on esialgu 0, hakkame loopiga seda looma - siit algab valem jadas, kaks esimest kindlad
//        if (n == 0) { //et me ei saaks 0 sisestada
//            return 0;
//        }
//        for (int i = 1; i < n; i++) { //alusame esimesest kohast jada loomist - kui sisestame n koha 7, siis index on 6
//            //me ei tekita jada, vaid keskendume c-le korral 7
//            c = a + b; //c on koguaeg eelmiste väärtuste summa
//            a = b; //a saab omale jada järgmise väärtuse
//            b = c; //b saab omale jada järgmise väärtuse
//            System.out.println(" " + c);
//        }
//        //System.out.println(c);
//        return c; //tagastame c, mis asub kohal n
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    public static int sequence3n(int x, int y) {
        //tee uus method 2tk
        //tehke tsükkel x-st y-ni
        //kustu välja method getSeqLength
        //salvesta kõige suurem ja tagasta see funktsiooni lõpus



        return 0;
    }



}