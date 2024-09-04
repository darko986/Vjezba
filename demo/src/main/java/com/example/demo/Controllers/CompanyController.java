package com.example.demo.Controllers;

import com.example.demo.Company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private Map<Long, Company> CompanyRepository = new HashMap<>();

    // GET - Retrieve a company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = CompanyRepository.get(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST - Create a new company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        if (CompanyRepository.containsKey(company.getID())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);  // ID already exists
        }
        CompanyRepository.put(company.getID(), company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    // PUT - Update an existing company by ID
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company company = CompanyRepository.get(id);
        if (company != null) {
            company.setName(companyDetails.getName());
            company.setAddress(companyDetails.getAddress());
            company.setPhone(companyDetails.getPhone());
            CompanyRepository.put(id, company);
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Delete a company by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        if (CompanyRepository.containsKey(id)) {
            CompanyRepository.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
