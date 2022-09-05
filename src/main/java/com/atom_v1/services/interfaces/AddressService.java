package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    List<Address> getAddressesByUser(User user);

    List<Address> getAddressesByCompany(MasterCompany company);

    void createAddress(Address address);

    void deleteAddress(Address address);

}
