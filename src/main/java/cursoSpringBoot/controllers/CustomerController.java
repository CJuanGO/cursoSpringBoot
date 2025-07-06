package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List <Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Customer(234, "Carlos Martinez", "carlosm", "password234")

    ));


    @GetMapping
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Encuentra un cliente dentro de uan lista usando el username
     * @param username atributo a buscar
     * @return retorna el cliente que coincide con la búsqueda
     */

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c : customers){
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return  customer;
    }


    /**
     * Actualiza informacion de clientes
     * @param customer objeto con la información actualizada
     * @return customer actualizado
     */
    @PutMapping
    public Customer putCliente(@RequestBody Customer customer){

        for (Customer c : customers){

            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    /**
     * Elimina un cliente por ID
     * @param id id a buscar
     * @return reotrna el cliente eliminado
     */
    @DeleteMapping("/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for(Customer c : customers){
            if (c.getID() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    /**
     * Realiza modificaciones parciales a un customer
     * @param customer customer a modificar
     * @return customer modificado
     */
    @PatchMapping
    public Customer patchCliente(@RequestBody Customer customer){

        for (Customer c : customers){
            if (c.getID() == customer.getID()){
                if (customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }

        return null;
    }
}
