package com.dgmf.controller;

import com.dgmf.dto.JobDto;
import com.dgmf.entity.Company;
import com.dgmf.entity.Job;
import com.dgmf.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    // Find All Jobs REST API
    @GetMapping
    //public ResponseEntity<List<JobDto>> findAllJobs() {
    public ResponseEntity<List<Job>> findAllJobs() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    // Create Job REST API
    @PostMapping
    // public ResponseEntity<String> createJob(@RequestBody JobDto jobDto) {
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);

        return new ResponseEntity<>(
                "Job Added Successfully",
                HttpStatus.CREATED
        );
    }

    // Get Job By Id REST API
    @GetMapping("/{id}")
    // public ResponseEntity<JobDto> getJobById(
    public ResponseEntity<Job> getJobById(
            @PathVariable("id") Long jobId
    ) {
        // JobDto jobDto = jobService.getJobById(jobDtoId);
        Job job = jobService.getJobById(jobId);
        if(job != null) return
                ResponseEntity.ok(jobService.getJobById(jobId));

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Job By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobId(
            @PathVariable("id") Long jobId
    ) {
        Boolean deleted = jobService.deleteJobById(jobId);

        if(deleted) {
            return new ResponseEntity<>(
                    "Job Deleted Successfully",
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update Job By Id REST API
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(
            // @PathVariable("id") Long jobDtoId, @RequestBody JobDto jobDto
            @PathVariable("id") Long jobId, @RequestBody Job job
    ) {
        Boolean updated = jobService.updateJobById(jobId, job);

        if(updated) return ResponseEntity.ok("Job Updated Successfully");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
