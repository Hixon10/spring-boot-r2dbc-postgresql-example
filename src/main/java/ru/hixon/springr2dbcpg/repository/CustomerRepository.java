package ru.hixon.springr2dbcpg.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.hixon.springr2dbcpg.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}