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
                .map(jobMapper::mapToDto)
                .collect(Collectors.toList());

        return jobDtos;
    }

    @Override
    public void createJob(JobDto jobDto) {
        Job job = jobMapper.mapToJob(jobDto);
        jobRepository.save(job);
    }

    @Override
    public JobDto getJobById(Long jobDtoId) {
        List<Job> jobs = jobRepository.findAll();

        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                JobDto jobDto = jobMapper.mapToDto(job);

                return jobDto;
            }
        }

        return null;
    }

    @Override
    public Boolean deleteJobById(Long jobDtoId) {
        List<Job> jobs = jobRepository.findAll();
        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                jobRepository.deleteById(job.getId());

                return true;
            }
        }

        return false;
    }
}
