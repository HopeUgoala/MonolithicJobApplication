package com.application.FirstJobApplication.jobs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        return job;

    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();

    }

    @PostMapping("/jobs")
    public String CreateNewJobs(@RequestBody Job job){
        jobService.createJob(job);
        return "The job was added successfully";
    }

}
