package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List <Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Customer(234, "Carlos Martinez", "carlosm", "password234")

    ));


    @GetMapping("clientes")
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Encuentra uliente dentro de uan lista usando el username
     * @param username atributo a buscar
     * @return retorna el cliente que coinside con la busqueda
     */
    @GetMapping("clientes/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c : customers){
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }
}
