package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CompanyService {

    List<MasterCompany> getAllCompanies();

    MasterCompany getCompanyById(Long id);

    MasterCompany getCompanyByOffer(Offer offer);

    List<MasterCompany> getCompaniesByUser(User user);

    List<MasterCompany> getCompaniesByCategory(Category category);

    List<MasterCompany> getCompaniesByLocation(Location location);

    void createCompany(MasterCompany company);

    void deleteCompany(MasterCompany company);
}
