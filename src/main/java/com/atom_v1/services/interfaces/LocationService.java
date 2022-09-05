package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    Location getLocationById(Long id);

    Location getLocationByTask(Task task);

    List<Location> getLocationsByCategory(Category category);

    List<Location> getLocationsByCompany(MasterCompany company);

    void createLocation(Location location);

    void deleteLocation(Location location);
}
