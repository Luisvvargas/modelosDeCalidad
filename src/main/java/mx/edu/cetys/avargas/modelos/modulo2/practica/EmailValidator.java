package mx.edu.cetys.avargas.modelos.modulo2.practica;

// [true->valido , false->invalido] - para todas las validaciones

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {

    private String validSpecialCharacters = "._-+";

    public EmailValidator(){
        System.out.println("Constructor: Default specialChars");
    }
    public EmailValidator(String validSpecialCharacters){
        System.out.println("    Constructor Custom validSpecialCharacters: " + validSpecialCharacters);
        this.validSpecialCharacters = validSpecialCharacters;
    }

    //metodo valida si email cumple con requisitos
    public boolean isValid(String email) {
        System.out.println("        isValid "+ validSpecialCharacters);

        if (email == null || email.isEmpty()) {
            return false; //no se permite email nulo o vacio
        }

        //Dividir user y domain
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false; //solamente puede tener un '@'
        }
        String user = parts[0]; //parte del user antes de @
        String domain = parts[1]; //parte del domain despues de @

        //validaciones de usser
        if (!isValidUser(user)) {
            return false;
        }

        //validaciones de domain
        if (!isValidDomain(domain)) {
            return false;
        }

        return true; //si pasa todas las validaciones entonces email es valido
    }

    //validar user antes de @
    private boolean isValidUser(String user) {
        if (user.length() > 30) {
            return false; //no se pueden tener mas de 30 caracteres
        }
        if (!Character.isDigit(user.charAt(0))) {
            return false; //debe empezar con numero
        }
        if (!containsAllVowels(user)) {
            return false; //debe tener todas las vocales
        }
        if (!containsUpperCase(user)) {
            return false; //el menos una letra mayus
        }
        if (!user.matches("[A-Za-z0-9._+-]+")) {
            return false; //solo alfanumerico y caracteres mostrados
        }
        return true; //si cumple lo anterior entonces es user valido
    }

    //validar domain despues de @
    private boolean isValidDomain(String domain) {
        //dividir dominio en proveedor y extension
        String[] domainParts = domain.split("\\.");
        if (domainParts.length != 2) {
            return false; //solo puede contener un punto
        }

        String provider = domainParts[0]; //proveedor (cetys en este caso)
        String extension = domainParts[1]; //extension (en este caso mx)

        if (provider.length()>30){
            return false; //no puede contar con mas de 30 caracteres
        }

        if (!provider.matches("[A-Za-z]+")) {
            return false; //proveedor solo puede ocntener letras
        }

        if (extension.length() < 2 || extension.length() > 4 || !extension.matches("[a-zA-Z]+")) {
            return false; //extension debe tener de 2 a 4 letras
        }
        return true; //si cumple condiciones entonces es valido
    }

    //metodo para verificar si la cadena contiene todas las vocales
    //se usa en isValidUser
    private boolean containsAllVowels(String input) {
        String vowels = "aeiou";
        for (char vowel : vowels.toCharArray()) {
            if (!input.toLowerCase().contains(String.valueOf(vowel))) {
                return false; //false si falta alguna vocal
            }
        }
        return true; //verdadero si tiene todas las vocales
    }

    //metodo para verificar si la cadena contiene al menos una mayuscula
    //se usa en isValidUser
    private boolean containsUpperCase(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true; //retornar verdadero si encuentra mayuscula
            }
        }
        return false; //si no hay mayusculas retorna falso
    }
}
