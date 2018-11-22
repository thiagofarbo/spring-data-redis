package br.com.webwork.springdataredis.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.webwork.springdataredis.domain.Company;
import br.com.webwork.springdataredis.repository.CompanyRepository;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
	
	@Autowired
	private CompanyRepository repository;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public @ResponseBody ResponseEntity<Company> save(@RequestBody Company company){
		return new ResponseEntity<>(this.repository.save(company), CREATED);
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id) {
		
		Optional<Company> company = this.repository.findById(id);
		
		if(company.isPresent()) {
			return new ResponseEntity<>(company.get(), OK);
		}
		return new ResponseEntity<>(NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> list(){
		
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
