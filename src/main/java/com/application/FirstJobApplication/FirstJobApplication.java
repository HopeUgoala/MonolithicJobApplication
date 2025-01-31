package com.application.FirstJobApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJobApplication.class, args);

	}

}


/*
* GET/job: Get all jobs
* GET/job/{id}: Get a specific job by ID
* POST/job: Create a new job (request body should contain the job details)
* DELETE/job/{id}: Delete a specific job by ID
* PUT/job/{id}: Update a specific job by ID (request body should contain the updated job)
*
*
* Example API URLs:
* GET{base_url}/job
* GET{base_url}/job/1
* POST{base_url}/job
* DELETE{base_url}/job/1
* PUT{base_url}/job/1
*

*
*
* */
