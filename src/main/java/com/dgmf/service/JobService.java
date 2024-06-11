package com.dgmf.service;

import com.dgmf.entity.Job;

import java.util.List;

public interface JobService {
    // List<JobDto> findAllJobs();
    List<Job> findAllJobs();
    // void createJob(JobDto jobDto);
    void createJob(Job job);
    // JobDto getJobById(Long jobDtoId);
    Job getJobById(Long jobId);
    // Boolean deleteJobById(Long jobDtoId);
    Boolean deleteJobById(Long jobId);
    // Boolean updateJobById(Long jobDtoId, JobDto jobDto);
    Boolean updateJobById(Long jobId, Job job);
}
