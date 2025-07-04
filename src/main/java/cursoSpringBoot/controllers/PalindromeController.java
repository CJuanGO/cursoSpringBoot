package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador para verificar palindromas
 */
@RestController
public class PalindromeController {

    /**
     * Endpoint para verificar si la palabra es palindromo
     * @param pal   palabra a verificar
     * @return respuesta con el resultado
     */
    @GetMapping( "/palindromo/{pal}")
    public String palindromo(@PathVariable String pal){

        if(isPalindromo(pal)){
            return pal + " es palindromo";
        }else{
            return pal + " no es palindromo";
        }
    }


    /**
     * Metodo que verifica si una palabra es palindroma
     * @param pal  Palabra a verificar
     * @return resultado en boolean
     */
    public Boolean isPalindromo(@PathVariable String pal){
        int length = pal.length();

        for (int i = 0; i < length ; i++) {
            if(pal.charAt(i) != pal.charAt(length -1-i)){
                return false ;
            }
        }
        return true;
    }
}
