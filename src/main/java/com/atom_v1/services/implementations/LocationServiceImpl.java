package com.atom_v1.services.implementations;

import com.atom_v1.data.Category;
import com.atom_v1.data.Location;
import com.atom_v1.data.MasterCompany;
import com.atom_v1.data.Task;
import com.atom_v1.services.interfaces.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
    @Override
    public List<Location> getAllLocations() {
        return null;
    }

    @Override
    public Location getLocationById(Long id) {
        return null;
    }

    @Override
    public Location getLocationByTask(Task task) {
        return null;
    }

    @Override
    public List<Location> getLocationsByCategory(Category category) {
        return null;
    }

    @Override
    public List<Location> getLocationsByCompany(MasterCompany company) {
        return null;
    }

    @Override
    public void createLocation(Location location) {

    }

    @Override
    public void deleteLocation(Location location) {

    }
}
