package com.atom_v1.services.implementations;

import com.atom_v1.data.MasterCompany;
import com.atom_v1.data.Offer;
import com.atom_v1.data.Task;
import com.atom_v1.services.interfaces.OfferService;

import java.util.List;

public class OfferServiceImpl implements OfferService {
    @Override
    public List<Offer> getAllOffers() {
        return null;
    }

    @Override
    public Offer getOfferById(Long id) {
        return null;
    }

    @Override
    public List<Offer> getOffersByTask(Task task) {
        return null;
    }

    @Override
    public List<Offer> getOffersByCompany(MasterCompany company) {
        return null;
    }

    @Override
    public void createOffer(Offer offer) {

    }

    @Override
    public void deleteOffer(Offer offer) {

    }
}
