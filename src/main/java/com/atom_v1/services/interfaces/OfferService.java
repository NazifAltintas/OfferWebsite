package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface OfferService {

    List<Offer> getAllOffers();

    Offer getOfferById(Long id);

    List<Offer> getOffersByTaskId(Long id);

    List<Offer> getOffersByCompanyEmail(String email);

    String createOffer(Offer offer);

    String deleteOffer(Long id);
}
