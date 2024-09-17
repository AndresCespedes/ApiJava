package apiExample.controllers;

import apiExample.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController()
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Andrés", "Andres", "prueba1"),
            new Customer(456, "Mateo", "Mateo", "prueba2"),
            new Customer(789, "Camilo", "Camilo", "prueba3"),
            new Customer(112, "Giovanni", "Giovanni", "prueba4")));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomer() {
        return customers;
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public Customer putCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getPassword());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }

}
