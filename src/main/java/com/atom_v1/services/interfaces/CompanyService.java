package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    Company getCompanyByOfferId(Long id);

    List<Company> getCompaniesByUserId(Long id);

    List<Company> getCompaniesByCategoryId(Long id);

    List<Company> getCompaniesByLocationId(Long id);

    String createCompany(Company company);

    String deleteCompany(Long id);

     List<Company> findCompaniesByName(String name);
}
