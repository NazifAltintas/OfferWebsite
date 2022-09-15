package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    Location getLocationById(Long id);

    Location getLocationByTaskId(Long id);

    List<Location> getLocationsByCategoryId(Long id);

    List<Location> getLocationsByCompanyId(Long id);

   String createLocation(Location location);

    String deleteLocation(Long id);
}
