package ee.bcs.valiit.testcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HController {

    private static Random random = new Random();
    int randomNr = random.nextInt(100);
    private static int count = 0;

    @GetMapping("lesson3hard/{nr}")
    public String numberGame(@PathVariable("nr") int guess) {
        count++;
        if (guess < randomNr) {
            return "Your number was smaller, guess again";
        } else if (guess > randomNr) {
            return "Your number was greater, guess again";
        } else {
            return "Correct, you won! It took you " + count + " attempts!";
        }
    }
/**
 * siin pole seost esialgse lahendiga, vaid see lahend ise on siin sees
 */
}