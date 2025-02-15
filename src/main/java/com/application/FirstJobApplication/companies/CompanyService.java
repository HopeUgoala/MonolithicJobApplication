package com.application.FirstJobApplication.companies;

import java.util.List;

public interface CompanyService {

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompanies(Long id, Company updatedCompany);

    List<Company> getAllCompanies();
}
