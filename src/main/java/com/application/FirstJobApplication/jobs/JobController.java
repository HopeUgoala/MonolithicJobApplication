package com.application.FirstJobApplication.jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;


    public JobController(JobService jobService) {

        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> CreateNewJobs(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("The job was added successfully", HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobs(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobs(id, updatedJob);
        if(updated) {
            return new ResponseEntity<>("The update was successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("The update was not successful",HttpStatus.NOT_FOUND);

    }

}
