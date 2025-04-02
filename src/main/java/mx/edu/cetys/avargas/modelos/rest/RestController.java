package mx.edu.cetys.avargas.modelos.rest;

import mx.edu.cetys.avargas.modelos.modulo2.practica.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/modelos")
public class RestController {

    final private EmailValidator emailValidator;

    public RestController(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }


    public record Response(String message, String error){}

    @GetMapping("/hello")
    Response getMessage(){
        return new Response("Hello world", null);
    }

    @PostMapping("isValid/{email}")
    Response isValid(@PathVariable("email")String email){
        if(emailValidator.isValid(email)){
            return new Response(email + "is a Valid email","");
        }
        return new Response("", email + "is not a Valid email");
    }
}
