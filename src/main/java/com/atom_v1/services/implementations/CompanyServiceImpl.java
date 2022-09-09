package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.CompanyRepository;
import com.atom_v1.repository.OfferRepository;
import com.atom_v1.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private OfferRepository offerRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, OfferRepository offerRepository) {
        this.companyRepository = companyRepository;
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        if (companyRepository.findById(id).isPresent()) {

            return companyRepository.findById(id).get();
        }
        return new Company();
    }

    @Override
    public Company getCompanyByOfferId(Long id) {
        if (offerRepository.findById(id).isPresent()) {
            Offer offer = offerRepository.findById(id).get();
            return offer.getCompany();
        }
        return new Company();
    }

    @Override
    public List<Company> getCompaniesByUserId(Long id) {
        List<Company> companies, companyList;
        companies = companyRepository.findAll();
        companyList = new ArrayList<>();
        User userOfId;
        for (Company company : companies) {
            userOfId = company.getUser();
            if (userOfId.getUserId() == id) {
                companyList.add(company);
            }
        }
        return companyList;
    }

    @Override
    public List<Company> getCompaniesByCategoryId(Long id) {
        List<Company> companies, companyList;
        companyList = new ArrayList<>();
        companies = companyRepository.findAll();
        List<Category> categories;
        for (Company company : companies) {
            categories = company.getCategories();
            for (Category category : categories)
                if (category.getCategoryId() == id) {
                    companyList.add(company);
                }
        }
        return companyList;
    }

    @Override
    public List<Company> getCompaniesByLocationId(Long id) {
        List<Company> companies, companyList;
        companyList = new ArrayList<>();
        companies = companyRepository.findAll();
        List<Location> locations;
        for (Company company : companies) {
            locations = company.getLocations();
            for (Location location : locations)
                if (location.getLocationId() == id) {
                    companyList.add(company);
                }
        }
        return companyList;
    }

    @Override
    public String createCompany(Company company) {
        companyRepository.save(company);
        if (companyRepository.existsById(company.getCompanyId())) return "comment is created successfully";
        return "comment couldn't  be created";
    }

    @Override
    public String deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            companyRepository.deleteById(id);
            return "Company with id is " + id + " is successfully deleted";
        }
    }


    @Override
    public List<Company> findCompaniesByName(String name) {
        List<Company> companyList, companies;
        companyList = new ArrayList<>();
        companies = companyRepository.findAll();
        for (Company company : companies) {
            String companyName =company.getCompanyName();
            if (!companyName.isBlank() && companyName.toLowerCase().contains(name.toLowerCase())) {
                companyList.add(company);

            }

        }
        return companyList;
    }


}
