package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface OfferService {

    List<Offer> getAllOffers();

    Offer getOfferById(Long id);

    List<Offer> getOffersByTask(Task task);

    List<Offer> getOffersByCompany(MasterCompany company);

    void createOffer(Offer offer);

    void deleteOffer(Offer offer);
}
