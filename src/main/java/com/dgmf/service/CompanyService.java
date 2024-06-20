package com.dgmf.service;

import com.dgmf.entity.Company;

import java.util.List;

public interface CompanyService {
    // List<CompanyDto> getAllCompanies();
    List<Company> getAllCompanies();
    // Boolean updateCompanyById(Long companyDtoId, CompanyDto companyDto);
    Boolean updateCompanyById(Long companyId, Company company);
    // void createCompany(CompanyDto companyDto);
    void createCompany(Company company);
    // Boolean deleteCompanyById(Long companyDtoId);
    Boolean deleteCompanyById(Long companyId);
    // CompanyDto getCompanyById(Long companyDtoId);
    Company getCompanyById(Long companyId);
}
