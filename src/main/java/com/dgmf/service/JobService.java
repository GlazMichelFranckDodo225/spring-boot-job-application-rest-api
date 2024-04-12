package com.dgmf.service;

import com.dgmf.dto.JobDto;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<JobDto> findAllJobs();
    void createJob(JobDto jobDto);
    JobDto getJobById(Long jobDtoId);
    Boolean deleteJobById(Long jobDtoId);
}
