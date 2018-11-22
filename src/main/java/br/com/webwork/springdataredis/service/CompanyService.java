package br.com.webwork.springdataredis.service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.webwork.springdataredis.domain.Company;
import br.com.webwork.springdataredis.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public ResponseEntity<Company> saveCompany(Company company) {
		
		Company savedCompany = this.repository.save(company);
		
		if(savedCompany == null) {
			return new ResponseEntity<>(BAD_REQUEST);
		}
		return new ResponseEntity<>(savedCompany, OK); 
	}
	
	public ResponseEntity<Company> findByIdCompany(Long id) {
		
		Optional<Company> company = this.repository.findById(id);
		
		if(company.isPresent()) {
			return new ResponseEntity<>(company.get(), OK);
		}
		return new ResponseEntity<>(NOT_FOUND); 
	}
	
	public ResponseEntity<List<Company>> findAllCompanies() {
		
		Iterable<Company> companies = this.repository.findAll();
		
		List<Company> companyList = new ArrayList<>();
		
		if(companies.iterator().hasNext()) {
			
			companies.forEach(c -> {
				
				companyList.add(c);

			});
		}
		return new ResponseEntity<>(companyList, OK);
	}
}
