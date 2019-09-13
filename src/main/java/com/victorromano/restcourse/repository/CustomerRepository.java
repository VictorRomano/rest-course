package com.victorromano.restcourse.repository;

import com.victorromano.restcourse.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    List<Customer> findByCpf(@Param("cpf") String cpf);

    List<Customer> findCustomersByNameAndCpf(@Param("name") String name, @Param("cpf") String cpf);

    @Query(value = "select c from Customer c where id = 2")
    List<Customer> meuMetodo();

    Integer countAllByCpf(@Param("cpf") String cpf);

}
