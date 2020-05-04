package ru.hixon.springr2dbcpg.controller;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.hixon.springr2dbcpg.entity.Customer;
import ru.hixon.springr2dbcpg.repository.CustomerRepository;

@RestController
@RequestMapping("/")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customer")
    Mono<Void> create(@RequestBody Publisher<Customer> customerFlux) {
        return customerRepository.saveAll(customerFlux).then();
    }

    @GetMapping("/customer")
    public Flux<Customer> list() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> findById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }
}
