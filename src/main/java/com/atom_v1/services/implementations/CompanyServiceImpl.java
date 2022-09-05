package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.services.interfaces.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<MasterCompany> getAllCompanies() {
        return null;
    }

    @Override
    public MasterCompany getCompanyById(Long id) {
        return null;
    }

    @Override
    public MasterCompany getCompanyByOffer(Offer offer) {
        return null;
    }

    @Override
    public List<MasterCompany> getCompaniesByUser(User user) {
        return null;
    }

    @Override
    public List<MasterCompany> getCompaniesByCategory(Category category) {
        return null;
    }

    @Override
    public List<MasterCompany> getCompaniesByLocation(Location location) {
        return null;
    }

    @Override
    public void createCompany(MasterCompany company) {

    }

    @Override
    public void deleteCompany(MasterCompany company) {

    }
}
