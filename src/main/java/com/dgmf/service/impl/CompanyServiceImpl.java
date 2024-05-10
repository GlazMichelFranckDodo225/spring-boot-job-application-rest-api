package com.dgmf.service.impl;

import com.dgmf.dto.CompanyDto;
import com.dgmf.entity.Company;
import com.dgmf.mapper.CompanyMapper;
import com.dgmf.mapper.JobMapper;
import com.dgmf.repository.CompanyRepository;
import com.dgmf.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final JobMapper jobMapper;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDto> companyDtos = companies.stream()
                .map(companyMapper::mapToCompanyDto)
                .collect(Collectors.toList());

        return companyDtos;
    }

    @Override
    public Boolean updateCompanyById(Long companyDtoId, CompanyDto companyDto) {
        Optional<Company> optionalCompany = companyRepository.findById(companyDtoId);

        if(optionalCompany.isPresent()) {
            Company company = optionalCompany.get();

            company.setName(companyDto.getName());
            company.setDescription(companyDto.getDescription());
            /*company.setJobs(
                    companyDto.getJobDtos().stream()
                            .map(jobMapper::mapToJob)
                            .collect(Collectors.toList())
            );*/

            companyRepository.save(company);

            return true;
        }

        return false;
    }

    @Override
    public void createCompany(CompanyDto companyDto) {
        Company company = companyMapper.mapToCompany(companyDto);
        companyRepository.save(company);
    }

    @Override
    public CompanyDto getCompanyById(Long companyDtoId) {
        return null;
    }

    @Override
    public Boolean deleteCompanyById(Long companyDtoId) {
        return null;
    }
}
