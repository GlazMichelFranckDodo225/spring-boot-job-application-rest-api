package com.dgmf.service.impl;

import com.dgmf.dto.JobDto;
import com.dgmf.entity.Job;
import com.dgmf.mapper.JobMapper;
import com.dgmf.repository.JobRepository;
import com.dgmf.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public List<JobDto> findAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDto> jobDtos = jobs.stream()
                .map(job -> jobMapper.mapToDto(job))
                .collect(Collectors.toList());

        return jobDtos;
    }

    @Override
    public JobDto createJob(JobDto jobDto) {
        Job job = jobMapper.mapToJob(jobDto);
        Job savedJob = jobRepository.save(job);
        JobDto returnedJobDto = jobMapper.mapToDto(savedJob);

        return returnedJobDto;
    }
}
