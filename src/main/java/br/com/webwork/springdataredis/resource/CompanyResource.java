package br.com.webwork.springdataredis.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

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
import br.com.webwork.springdataredis.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/companies")
@Api(value = "/companies", produces = APPLICATION_JSON_VALUE, tags = {"Companies"}, description = "Operations to companies.")
public class CompanyResource {
	
	@Autowired
	private CompanyService service;
	
	@PostMapping
	@ResponseStatus(CREATED)
	@ApiOperation(value = "Save a company", notes = "Method to save a company")
    @ApiResponses({
    		@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	public @ResponseBody ResponseEntity<Company> save(@RequestBody Company company){
		return this.service.saveCompany(company);
	}
	
	@GetMapping
	@ResponseStatus(OK)
	@RequestMapping("/{id}")
	@ApiOperation(value = "Find a company by id", notes = "Find a company by id company")
    @ApiResponses({
    		@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Company> findById(@PathVariable Long id) {
		return this.service.findByIdCompany(id);
	}
	
	@GetMapping
	@ResponseStatus(OK)
	@ApiOperation(value = "Find a company by id", notes = "Find a company by id company")
    @ApiResponses({
    		@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<List<Company>> list(){
		return this.service.findAllCompanies();
	}
}
