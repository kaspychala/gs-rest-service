package hello;

/**
 * Created by Kasper Spychała on 17.01.2017.
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    String command = "waiting for command";

    @RequestMapping("/greeting")
    public ResponseEntity<Greeting> get() {

        Greeting greeting = new Greeting();
        greeting.setCommand(command);

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public ResponseEntity<Greeting> update(@RequestBody Greeting greeting) {

        if (greeting != null) {
            greeting.setCommand(greeting.getCommand());
            System.out.println(greeting.getCommand());
            command = greeting.getCommand();
        }

        // TODO: call persistence layer to update
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}
