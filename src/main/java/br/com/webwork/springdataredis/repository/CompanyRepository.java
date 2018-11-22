package br.com.webwork.springdataredis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.webwork.springdataredis.domain.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{

}
