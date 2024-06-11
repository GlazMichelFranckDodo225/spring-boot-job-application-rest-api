package com.dgmf.service.impl;

import com.dgmf.entity.Job;
import com.dgmf.repository.JobRepository;
import com.dgmf.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Override
    public List<Job> findAllJobs() {

        /*return jobs.stream()
                .map(JobMapper::mapToDto)
                .collect(Collectors.toList());*/

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        // Job job = JobMapper.mapToJob(jobDto);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        /*List<Job> jobs = jobRepository.findAll();
        for(Job job: jobs) {
            if(job.getId().equals(jobDtoId)) {
                JobDto jobDto = jobMapper.mapToDto(job);
                return jobDto;
            }
        }
        return null;*/

        /*return JobMapper.mapToDto(
                jobRepository.findById(jobDtoId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Job Not Found with Given Id : " + jobDtoId
                                )
                        )
        );*/

        return jobRepository.findById(jobId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Job Not Found with Given Id : " + jobId
                        )
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
    public Boolean updateJobById(Long jobId, Job job) {
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
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if(optionalJob.isPresent()) {
            // Job job = optionalJob.get();

            job.setTitle(job.getTitle());
            job.setDescription(job.getDescription());
            job.setMinSalary(job.getMinSalary());
            job.setMaxSalary(job.getMaxSalary());
            job.setLocation(job.getLocation());

            jobRepository.save(job);

            return true;
        }

        return false;
    }
}
