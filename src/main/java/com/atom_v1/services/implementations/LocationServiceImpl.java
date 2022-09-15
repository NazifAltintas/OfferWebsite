package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.LocationRepository;
import com.atom_v1.repository.TaskRepository;
import com.atom_v1.services.interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    private TaskRepository taskRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, TaskRepository taskRepository) {
        this.locationRepository = locationRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id) {
        if (locationRepository.findById(id).isPresent()) {

            return locationRepository.findById(id).get();
        }
        return new Location();
    }

    @Override
    public Location getLocationByTaskId(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            return task.getLocation();
        }
        return new Location();
    }

    @Override
    public List<Location> getLocationsByCategoryId(Long id) {
        List<Location> locationList, locations;
        locationList = new ArrayList<>();
        locations = locationRepository.findAll();
        List<Category> categories;
        for (Location location : locations) {
            categories = location.getCategories();
            for (Category category : categories)
                if (category.getCategoryId()==id) {
                    locationList.add(location);
                }
        }
        return locationList;
    }

    @Override
    public List<Location> getLocationsByCompanyId(Long id) {
        List<Location> locationList, locations;
        locationList = new ArrayList<>();
        locations = locationRepository.findAll();
        List<Company> companies;
        for (Location location : locations) {
            companies = location.getCompanies();
            for (Company company : companies)
                if (company.getCompanyId()==id) {
                    locationList.add(location);
                }
        }
        return locationList;
    }

    @Override
    public String createLocation(Location location) {
        locationRepository.save(location);
        if (locationRepository.existsById(location.getLocationId())) return "location is created successfully";
        return "location couldn't  be created";
    }

    @Override
    public String deleteLocation(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            locationRepository.deleteById(id);
            return "Location with id is " + id + " is successfully deleted";
        }
    }


}
