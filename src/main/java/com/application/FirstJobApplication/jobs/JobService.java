package com.application.FirstJobApplication.jobs;

import java.util.List;

public interface JobService {


    boolean deleteJobById(Long id);

    List<Job> findAll();
    void createJob(Job job); /* The creating of job are done in the controller layer, so that is why we return nothing on the method of Service layer*/

    Job getJobById(Long id);

    boolean updateJobs(Long id, Job updatedJob);
}

