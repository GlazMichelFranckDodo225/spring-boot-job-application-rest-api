package com.dgmf.controller;

import com.dgmf.dto.JobDto;
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
    public ResponseEntity<List<JobDto>> findAllJobs() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    // Create Job REST API
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto) {
        jobService.createJob(jobDto);

        return new ResponseEntity<>(
                "Job Added Successfully",
                HttpStatus.CREATED
        );
    }

    // Get Job By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(
            @PathVariable("id") Long jobDtoId
    ) {
        JobDto jobDto = jobService.getJobById(jobDtoId);
        if(jobDto != null) return
                ResponseEntity.ok(jobService.getJobById(jobDtoId));

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Job By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobId(
            @PathVariable("id") Long jobDtoId
    ) {
        Boolean deleted = jobService.deleteJobById(jobDtoId);

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
            @PathVariable("id") Long jobDtoId, @RequestBody JobDto jobDto
    ) {
        Boolean updated = jobService.updateJobById(jobDtoId, jobDto);

        if(updated) return ResponseEntity.ok("Job Updated Successfully");

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
