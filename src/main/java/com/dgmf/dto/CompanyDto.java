package com.dgmf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompanyDto {
    private Long id;
    private String name;
    private String description;
    // private List<JobDto> jobDtos = new ArrayList<>();
    private List<JobDto> jobDtos;
}
