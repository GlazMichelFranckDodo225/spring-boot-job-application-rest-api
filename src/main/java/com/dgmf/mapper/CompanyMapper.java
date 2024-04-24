package com.dgmf.mapper;

import com.dgmf.dto.CompanyDto;
import com.dgmf.entity.Company;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyMapper {
    private final ModelMapper modelMapper;

    public Company mapToCompany(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    public CompanyDto mapToCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }
}
