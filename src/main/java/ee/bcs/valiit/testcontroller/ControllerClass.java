package ee.bcs.valiit.testcontroller;


import ee.bcs.valiit.tasks.*;
import lahendused.Book;
import lahendused.Employees;
import lahendused.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //defineerib, kuidas Spring töötab
public class ControllerClass {
    List<Employees> employees = new ArrayList<Employees>();

    @GetMapping("muu/hello-world/{nameInUrl}") //veebis localhost:8080 + see link siit
    //täiendatud {nameInUrl} + methodis lisatud sama sulgudes ja loodud String, mis lisatud returni
    //reruni demoApplicationit ja peale seda töötab veebis
    public String helloWorld(@PathVariable("nameInUrl") String name,
                             @RequestParam("action") String tegevus,
                             @RequestParam("action2") String teineTegevus) {
        //lisasime siia RequestParam(asi, mis trükime veebilehel tegevusena) ja loome uue samanimelise variable
        //mis ilmub veebilehele, kui trükkida urli järel veel ?action=sõna
        return tegevus + " " + name + " " + teineTegevus + "!";
        //http://localhost:8080/muu/hello-world/Triin?action=tore&action2=naerata
    }


    @GetMapping("fibonacci")
    public int fibonacci(@RequestParam("number") int sisend) {
        return Lesson2.fibonacci(sisend); //sisendi anname urlis
        //http://localhost:8080/fibonacci?number=10
    }

    @GetMapping("reversearray/{reverse}")
    public int[] array(@PathVariable("reverse") int[] reverseArray) {
        return Lesson2.reverseArray(reverseArray);
        //http://localhost:8080/reversearray/1,2,3,4,5
    }

    @GetMapping("even")
    public int[] evenNumbers(@RequestParam("array") int number) {
        return Lesson2.evenNumbers(number);
        //http://localhost:8080/even?array=5
    }

    @GetMapping("min")
    public int min(@RequestParam("minArray") int[] array) {
        return Lesson2.min(array);
        //http://localhost:8080/min?minArray=5,4,3,2,1
    }

    @GetMapping("max/{maxNumber}")
    public int max(@PathVariable("maxNumber") int[] array) {
        return Lesson2.max(array);
        //http://localhost:8080/max/1,2,3,4,5
    }

    @GetMapping("sum/{array}")
    public int sum(@PathVariable("array") int[] array) {
        return Lesson2.sum(array);
        //http://localhost:8080/sum/1,2,3,4,5
    }

    @GetMapping("minNumber/{number1}/{number2}")
    public int minOfTwo(@PathVariable("number1") int number1, @PathVariable("number2") int number2) {
        return Lesson1.min(number1, number2);
        //http://localhost:8080/minNumber/67/35
    }

    @GetMapping("maxLesson1")
    public int maxOfTwo(@RequestParam("maxNumber1") int number1, @RequestParam("maxNumber2") int number2) {
        return Lesson1.max(number1, number2);
        //http://localhost:8080/maxLesson1?maxNumber1=3&maxNumber2=45
    }

    @GetMapping("absolut")
    public int abs(@RequestParam("number") int a) {
        return Lesson1.abs(a);
        //http://localhost:8080/absolut?number=-67
    }

    @GetMapping("isEven/{number}")
    public boolean isEven(@PathVariable("number") int a) {
        return Lesson1.isEven(a);
        //http://localhost:8080/isEven/68
    }

    @GetMapping("min3")
    public int min3(@RequestParam("nr1") int a,
                    @RequestParam("nr2") int b,
                    @RequestParam("nr3") int c) {
        return Lesson1.min3(a, b, c);
        //http://localhost:8080/min3?nr1=3&nr2=4&nr3=6
    }

    @GetMapping("max3/{nr1}/{nr2}/{nr3}")
    public int max3(@PathVariable("nr1") int nr1,
                    @PathVariable("nr2") int nr2,
                    @PathVariable("nr3") int nr3) {
        return Lesson1.max3(nr1, nr2, nr3);
        //http://localhost:8080/max3/3/7/9
    }

    @GetMapping("sample")
    public int[] sampleArray() {
        return Lesson2b.sampleArray();
        //http://localhost:8080/sample?
    }

    @GetMapping("generate")
    public int[] array(@RequestParam("length") int nr) {
        return Lesson2b.generateArray(nr);
        //http://localhost:8080/generate?length=9
    }

    @GetMapping("decrease")
    public int[] decrArray(@RequestParam("length") int a) {
        return Lesson2b.decreasingArray(a);
        //http://localhost:8080/decrease?length=8
    }

    @GetMapping("yl3/{nr}")
    public int[] yl3(@PathVariable("nr") int nr) {
        return Lesson2b.yl3(nr);
        //http://localhost:8080/yl3/5
    }

    @GetMapping("longest/{nr1}/{nr2}")
    public int longestNr(@PathVariable("nr1") int a, @PathVariable("nr2") int b) {
        return Lesson2c.sequence3n(a, b);
        //http://localhost:8080/longest/10/20
    }

    @GetMapping("seqlength")
    public int seqLength(@RequestParam("nr") int nr) {
        return Lesson2c.getSeqLength(nr);
        //http://localhost:8080/seqlength?nr=5
    }

    @GetMapping("next")
    public int nextElem(@RequestParam("nr") int nr) {
        return Lesson2c.nextElement(nr);
        //http://localhost:8080/next?nr=5
    }

    @GetMapping("factorial")
    public int factorial(@RequestParam("nr") int x) {
        return Lesson3.factorial(x);
        //http://localhost:8080/factorial?nr=5
    }

    @GetMapping("reverseString/{string}")
    public String reverseString(@PathVariable("string") String name) {
        return Lesson3.reverseString(name);
        //http://localhost:8080/reverseString/triin
    }

    @GetMapping("isprime/{nr}")
    public boolean isPrime(@PathVariable("nr") int number) {
        return Lesson3.isPrime(number);
        //http://localhost:8080/isprime/17
    }

    @GetMapping("sort")
    public int[] sortArray(@RequestParam("array") int[] unSorted) {
        return Lesson3.sort(unSorted);
        //http://localhost:8080/sort?array=5,2,4,1,3
    }

    @GetMapping("evenfibo")
    public int evenFibonacci(@RequestParam("number") int x) {
        return Lesson3.evenFibonacci(x);
        //http://localhost:8080/evenfibo?number=40
    }

    @GetMapping("morse")
    public String morse(@RequestParam("hello") String text) {
        return Lesson3.morseCode(text);
        //http://localhost:8080/morse?hello=sos
    }

    @GetMapping("book")
    public Book test() {
        Book book = new Book();
        book.setName("Triin");
        book.setHeadLine("Hea raamat");
        book.setPublishYear(2021);
        book.setLength(198);
        return book;
        //http://localhost:8080/book
    }

    @GetMapping("person")
    public Person personTest() {
        Person person = new Person();
        person.setName("Triin");
        person.setAge(31);
        person.setAddress("Kuuse tn");
        person.setJob(false);
        person.setSpeciality("software developer");
        return person;
        //http://localhost:8080/person
    }

    @GetMapping("testarray")
    public List<Person> personTest2() {
        Person person = new Person();
        person.setName("Triin");
        person.setAge(31);
        person.setAddress("Kuuse tn");
        person.setJob(false);
        person.setSpeciality("software developer");

        Person person2 = new Person();
        person2.setName("Edward");
        person2.setAge(32);
        person2.setAddress("Kuuse tn");
        person2.setJob(true);
        person2.setSpeciality("IT support manager");

        Person person3 = new Person();
        person3.setName("emps");
        person3.setAge(56);
        person3.setAddress("Tammsaare tee");
        person3.setJob(true);
        person3.setSpeciality("head accountant");

        List<Person> personList = new ArrayList<Person>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        return personList;
        //http://localhost:8080/testArray
    }

    @GetMapping("employees")
    public List<Employees> employeeList() { //list on selle classi all kohe loodud, class on eraldi olemas
        return employees; //võtame kogu listi, esialgu tühi
        //Postmanis searchis näitab kogu listi
        //http://localhost:8080/employees
    }

    @GetMapping("employees/{index}")
    public Employees search(@PathVariable("index") int index) {
        return employees.get(index); //tahame näha konkreetsel indexil isikut listist
        //Postmanis searchis näitab, kui märkida index
        //http://localhost:8080/employees/
    }

    @PutMapping("employees/{index}")
    public Employees replace(@PathVariable("index") int index,
                             @RequestBody Employees replace) {//võtame Employee classist sisu, aga paneme siia uue sisendi nime
        return employees.set(index,replace); //tahame asendada indexi kohal oleva teisega
        //Postmanis replace indexi kohal ja sisesta uus bodysse - vajalik sisestada body
    }

    @PostMapping("employees")
    public void postEmployee(@RequestBody Employees things) {
        employees.add(things); //lisa uus employee
        //lisa uus new alt ja vajalik on body, mille järgi andmestik sisestada
    }

    @DeleteMapping("employees/{index}")
    public Employees delete(@PathVariable("index") int index) {
        return employees.remove(index); //kustuta indexi kohal olev
        //kustuta indexi kohal olev
    }




}
