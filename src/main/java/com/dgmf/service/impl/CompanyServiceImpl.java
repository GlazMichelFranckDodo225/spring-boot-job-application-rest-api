package com.dgmf.service.impl;

import com.dgmf.entity.Company;
import com.dgmf.repository.CompanyRepository;
import com.dgmf.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {

        /*return companies.stream()
                .map(CompanyMapper::mapToCompanyDto)
                .collect(Collectors.toList());*/

        return companyRepository.findAll();
    }

    @Override
    public Boolean updateCompanyById(Long companyId, Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);

        if(optionalCompany.isPresent()) {
            // Company company = optionalCompany.get();

            company.setName(company.getName());
            company.setDescription(company.getDescription());
            /*company.setJobs(
                    company.getJobDtos().stream()
                            .map(JobMapper::mapToJob)
                            .collect(Collectors.toList())
            );*/
            company.setJobs(company.getJobs());

            companyRepository.save(company);

            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        // Company company = CompanyMapper.mapToCompany(companyDto);
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return null;
    }

    @Override
    public Boolean deleteCompanyById(Long companyId) {
        return null;
    }
}
