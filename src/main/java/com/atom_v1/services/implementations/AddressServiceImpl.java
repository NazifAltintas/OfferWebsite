package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.*;
import com.atom_v1.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }


    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
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
    public List<Address> getAddressesByUserEmail(String email) {
        List<Address> addresses, userAddresses;
        addresses = addressRepository.findAll();
        userAddresses = new ArrayList<>();
        User userOfAddress;
        for (Address address : addresses) {
            userOfAddress = address.getUser();
            if (userOfAddress.getEmail() == email) {
                userAddresses.add(address);
            }
        }
        return userAddresses;
    }

    @Override
    public List<Address> getAddressesByCompanyEmail(String email) {
        List<Address> addresses, companyAddresses;
        addresses = addressRepository.findAll();
        companyAddresses = new ArrayList<>();
        Company companyOfAddress;
        for (Address address : addresses) {
            companyOfAddress = address.getCompany();
            if (companyOfAddress.getCompanyEmail() == email) {
                companyAddresses.add(address);
            }
        }
        return companyAddresses;
    }

    @Override
    public String createAddress(Address address) {
        addressRepository.save(address);
        if (addressRepository.existsById(address.getId())) return "address is created successfully";
        return "address couldn't  be created";
    }


    //for DELETE Request Method

    @Override
    public String deleteAddressById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            addressRepository.deleteById(id);
            return "Address whose id is " + id + " is successfully deleted";
        }
    }

    @Override
    public Address fullyUpdateAddress(Long id, Address newAddress) {

        Address existingAddressById = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " does not exist"));

        //To update street

        if (newAddress.getStreet() == null) {
            throw new IllegalArgumentException("Street is mandatory to update data...");
        } else if (!existingAddressById.getStreet().equals(newAddress.getStreet())) {
            existingAddressById.setStreet(newAddress.getStreet());
        }

        //To update house number

        if (newAddress.getHouseNr() == null) {
            throw new IllegalArgumentException("Number is mandatory to update data...");
        } else if (newAddress.getHouseNr() <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0 to update data...");
        } else if (!(Objects.equals(existingAddressById.getHouseNr(), newAddress.getHouseNr()))) {
            existingAddressById.setHouseNr(newAddress.getHouseNr());
        }

        //To update house box number

        if (newAddress.getBox() == null) {
            existingAddressById.setBox(null);
        } else if (newAddress.getBox() <= 0) {
            throw new IllegalArgumentException("Box Number must be greater than 0 to update data...");
        } else if (!(Objects.equals(existingAddressById.getBox(), newAddress.getBox()))) {
            existingAddressById.setBox(newAddress.getBox());
        }

        //To update Postcode

        if (newAddress.getZIP() == null) {
            throw new IllegalArgumentException("Postcode is mandatory to update data...");
        } else if (newAddress.getZIP() < 1000 || newAddress.getZIP() > 9999) {
            throw new IllegalArgumentException("Number must be between 1000 and 9999 to update data...");
        } else if (!(Objects.equals(existingAddressById.getZIP(), newAddress.getZIP()))) {
            existingAddressById.setZIP(newAddress.getZIP());
        }

        //To update City

        if (newAddress.getCity() == null) {
            throw new IllegalArgumentException("City is mandatory to update data...");
        } else if (!existingAddressById.getCity().equals(newAddress.getCity())) {
            existingAddressById.setCity(newAddress.getCity());
        }

        return addressRepository.save(existingAddressById);
    }
}


