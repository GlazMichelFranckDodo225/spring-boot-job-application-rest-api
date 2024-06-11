package com.dgmf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Component
public class CompanyDto {
    private Long id;
    private String name;
    private String description;
    private List<JobDto> jobDtos = new ArrayList<>();
    // private List<JobDto> jobDtos;
}
