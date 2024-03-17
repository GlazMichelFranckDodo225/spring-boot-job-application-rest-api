package com.dgmf.controller;

import com.dgmf.entity.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping
    public List<Job> findAllJobs() {
        return jobs;
    }
}
