package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import cursoSpringBoot.service.CustomerService;
import cursoSpringBoot.service.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    @Autowired
    private CustomerService customersService;


    @GetMapping
    public ResponseEntity <List<Customer>> getCustomers (){
        List<Customer> customers = customersService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    /**
     * Encuentra un cliente dentro de uan lista usando el username
     * @param username atributo a buscar
     * @return retorna el cliente que coincide con la búsqueda
     */

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username){
        List<Customer> customers = customersService.getCustomers();
        for(Customer c : customers){
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: "+ username);
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        List<Customer> customers = customersService.getCustomers();
        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();
        // return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }


    /**
     * Actualiza información de clientes
     * @param customer objeto con la información actualizada
     * @return customer actualizado
     */
    @PutMapping
    public  ResponseEntity<?> putCliente(@RequestBody Customer customer){
        List<Customer> customers = customersService.getCustomers();
        for (Customer c : customers){

            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Elimina un cliente por ID
     * @param id id a buscar
     * @return reotrna el cliente eliminado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        List<Customer> customers = customersService.getCustomers();
        for(Customer c : customers){
            if (c.getID() == id) {
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return  ResponseEntity.notFound().build();
    }

    /**
     * Realiza modificaciones parciales a un customer
     * @param customer customer a modificar
     * @return customer modificado
     */
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
        List<Customer> customers = customersService.getCustomers();
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
                return ResponseEntity.ok("Cliente " + customer.getName() +" Actualizado ");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + customer.getID() +" No encontrado ");
    }
}
