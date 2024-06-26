package com.dgmf.controller;

import com.dgmf.dto.CompanyDto;
import com.dgmf.entity.Company;
import com.dgmf.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    // public ResponseEntity<List<CompanyDto>> getAllCompanies() {
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    // Update Company By Id REST API
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(
            // @PathVariable("id") Long companyDtoId, @RequestBody CompanyDto companyDto
            @PathVariable("id") Long companyId, @RequestBody Company company
    ) {
        Boolean updated = companyService.updateCompanyById(companyId, company);

        if(updated) return ResponseEntity.ok("Company Updated Successfully");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add Company REST API
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);

        return new ResponseEntity<>(
                "Company Added Successfully !", HttpStatus.CREATED
        );
    }

    // Delete Company By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(
            @PathVariable("id") Long companyId
    ) {
        Boolean isDeleted = companyService.deleteCompanyById(companyId);

        if(isDeleted) {
            return ResponseEntity.ok("Company Deleted Successfully");
        }

        return new ResponseEntity<>(
                "Company Not Found with Given Id : " + companyId,
                HttpStatus.NOT_FOUND
        );
    }

    // Get Company By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long companyId) {
        Company company = companyService.getCompanyById(companyId);

        if(company != null) {
            return ResponseEntity.ok(company);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
