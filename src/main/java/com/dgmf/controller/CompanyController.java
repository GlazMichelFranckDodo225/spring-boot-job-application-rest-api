package com.dgmf.controller;

import com.dgmf.dto.CompanyDto;
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
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    // Update Company By Id REST API
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(
            @PathVariable("id") Long companyDtoId, @RequestBody CompanyDto companyDto
    ) {
        Boolean updated = companyService.updateCompanyById(companyDtoId, companyDto);

        if(updated) return ResponseEntity.ok("Company Updated Successfully");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add Company REST API
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody CompanyDto companyDto) {
        companyService.createCompany(companyDto);

        return new ResponseEntity<>("Company Added Successfully !", HttpStatus.CREATED);
    }
}
