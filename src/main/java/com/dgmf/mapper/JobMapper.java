package com.dgmf.mapper;

import com.dgmf.dto.JobDto;
import com.dgmf.entity.Job;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobMapper {
    private final ModelMapper modelMapper;

    public Job mapToJob(JobDto jobDto) {
        return modelMapper.map(jobDto, Job.class);
    }

    public JobDto mapToDto(Job job) {
        return modelMapper.map(job, JobDto.class);
    }
}
