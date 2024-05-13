package com.dgmf.service.impl;

import com.dgmf.dto.JobDto;
import com.dgmf.entity.Job;
import com.dgmf.mapper.JobMapper;
import com.dgmf.repository.JobRepository;
import com.dgmf.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public List<JobDto> findAllJobs() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream()
                .map(jobMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createJob(JobDto jobDto) {
        Job job = jobMapper.mapToJob(jobDto);
        jobRepository.save(job);
    }

    @Override
    public JobDto getJobById(Long jobDtoId) {
        /*List<Job> jobs = jobRepository.findAll();
        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                JobDto jobDto = jobMapper.mapToDto(job);
                return jobDto;
            }
        }
        return null;*/

        return jobMapper.mapToDto(
                jobRepository.findById(jobDtoId).orElse(null)
        );
    }

    @Override
    public Boolean deleteJobById(Long jobDtoId) {
        /*List<Job> jobs = jobRepository.findAll();
        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                jobRepository.deleteById(job.getId());
                return true;
            }
        }
        return false;*/

        try {
            jobRepository.deleteById(jobDtoId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateJobById(Long jobDtoId, JobDto jobDto) {
        /*List<Job> jobs = jobRepository.findAll();
        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                job.setTitle(jobDto.getTitle());
                job.setDescription(jobDto.getDescription());
                job.setMinSalary(jobDto.getMinSalary());
                job.setMaxSalary(jobDto.getMaxSalary());
                job.setLocation(jobDto.getLocation());
                jobRepository.save(job);
                return true;
            }*/
        Optional<Job> optionalJob = jobRepository.findById(jobDtoId);

        if(optionalJob.isPresent()) {
            Job job = optionalJob.get();

            job.setTitle(jobDto.getTitle());
            job.setDescription(jobDto.getDescription());
            job.setMinSalary(jobDto.getMinSalary());
            job.setMaxSalary(jobDto.getMaxSalary());
            job.setLocation(jobDto.getLocation());

            jobRepository.save(job);

            return true;
        }

        return false;
    }
}
