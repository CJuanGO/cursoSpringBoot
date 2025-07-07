package cursoSpringBoot.service;

import cursoSpringBoot.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomerService{

    private List<Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Customer(234, "Carlos Martinez", "carlosm", "password234")

    ));

    @Override
    public  List<Customer> getCustomers(){
        return customers;
    }
}
