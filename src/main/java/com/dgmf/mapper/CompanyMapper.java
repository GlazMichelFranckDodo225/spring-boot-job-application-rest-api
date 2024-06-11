package com.dgmf.mapper;

import com.dgmf.dto.CompanyDto;
import com.dgmf.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyMapper {
    private final CompanyDto companyDto;

    public static Company mapToCompany(CompanyDto companyDto) {
        return Company.builder()
                .name(companyDto.getName())
                .description(companyDto.getDescription())
                .jobs(
                        companyDto.getJobDtos().stream()
                                .map(JobMapper::mapToJob)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static CompanyDto mapToCompanyDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .jobDtos(
                        company.getJobs().stream()
                                .map(JobMapper::mapToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
