package com.atom_v1.services.implementations;

import com.atom_v1.data.Address;
import com.atom_v1.data.MasterCompany;
import com.atom_v1.data.User;
import com.atom_v1.repository.AddressRepository;
import com.atom_v1.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }

    @Override
    public Address getAddressById(Long id) {
        if (addressRepository.findById(id).isPresent()) {
            Address address = addressRepository.findById(id).get();

            return address;
        }
        return new Address();
    }

    @Override
    public List<Address> getAddressesByUser(User user) {
        List<Address> addresses, userAddresses;
        addresses = addressRepository.findAll();
        userAddresses = new ArrayList<>();
        User userOfAddress;
        for (Address address : addresses) {
            userOfAddress = address.getUser();
            if (userOfAddress == user) {
                userAddresses.add(address);
            }
        }
        return userAddresses;
    }

    @Override
    public List<Address> getAddressesByCompany(MasterCompany company) {
        List<Address> addresses, companyAddresses;
        addresses = addressRepository.findAll();
        companyAddresses = new ArrayList<>();
        MasterCompany companyOfAddress;
        for (Address address : addresses) {
            companyOfAddress = address.getCompany();
            if (companyOfAddress == company) {
                companyAddresses.add(address);
            }
        }
        return companyAddresses;
    }

    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }
}
