package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    List<Address> getAddressesByUserEmail(String email);

    List<Address> getAddressesByCompanyEmail(String email);

    String createAddress(Address address);

    String deleteAddressById(Long id);

    Address fullyUpdateAddress(Long id, Address newAddress);

}
