package com.dgmf.service;

import com.dgmf.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();
    Boolean updateCompanyById(Long companyDtoId, CompanyDto companyDto);
    void createCompany(CompanyDto companyDto);
    CompanyDto getCompanyById(Long companyDtoId);
    Boolean deleteCompanyById(Long companyDtoId);

}