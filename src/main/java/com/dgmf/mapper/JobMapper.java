package com.dgmf.mapper;

import com.dgmf.dto.JobDto;
import com.dgmf.entity.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public static JobDto mapToDto(Job job) {
        return JobDto.builder()
                .id(job.getId())
                .title(job.getTitle())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .location(job.getLocation())
                .companyDto(CompanyMapper.mapToCompanyDto(job.getCompany()))
                .build();
    }

    public static Job mapToJob(JobDto jobDto) {
        return Job.builder()
                .id(jobDto.getId())
                .title(jobDto.getTitle())
                .description(jobDto.getDescription())
                .minSalary(jobDto.getMinSalary())
                .maxSalary(jobDto.getMaxSalary())
                .location(jobDto.getLocation())
                .company(CompanyMapper.mapToCompany(jobDto.getCompanyDto()))
                .build();
    }
}
