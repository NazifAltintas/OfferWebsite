package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.OfferRepository;
import com.atom_v1.services.interfaces.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(Long id) {
        if (offerRepository.findById(id).isPresent()) {

            return offerRepository.findById(id).get();
        }
        return new Offer();
    }

    @Override
    public List<Offer> getOffersByTaskId(Long id) {
        List<Offer> offers, offerList;
        offerList = new ArrayList<>();
        offers = offerRepository.findAll();
        Task task;
        for (Offer offer : offers) {
            task = offer.getTask();
            if (task.getTaskId() == id) {
                offerList.add(offer);
            }
        }
        return offerList;
    }

    @Override
    public List<Offer> getOffersByCompanyEmail(String email) {
        List<Offer> offers, offerList;
        offerList = new ArrayList<>();
        offers = offerRepository.findAll();
        Company company;
        for (Offer offer : offers) {
            company = offer.getCompany();
            if (company.getCompanyEmail().equalsIgnoreCase(email)) {
                offerList.add(offer);
            }
        }
        return offerList;
    }

    @Override
    public String createOffer(Offer offer) {
        offerRepository.save(offer);
        if (offerRepository.existsById(offer.getOfferId())) return "offer is created successfully";
        return "offer couldn't  be created";
    }

    @Override
    public String deleteOffer(Long id) {
        if (!offerRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            offerRepository.deleteById(id);
            return "Offer with id is " + id + " is successfully deleted";
        }

    }
}