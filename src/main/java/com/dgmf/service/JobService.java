package com.dgmf.service;

import com.dgmf.dto.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> findAllJobs();
    JobDto createJob(JobDto jobDto);
}
