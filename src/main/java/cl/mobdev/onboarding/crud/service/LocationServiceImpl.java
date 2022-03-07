package cl.mobdev.onboarding.crud.service;

import cl.mobdev.onboarding.crud.entity.Character;
import cl.mobdev.onboarding.crud.entity.Location;
import cl.mobdev.onboarding.crud.repository.CharacterRepository;
import cl.mobdev.onboarding.crud.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl {

   @Autowired
   private LocationRepository locationRepository;

    public String createLocation(Location location) {
        try {
            if (!locationRepository.existsByName(location.getName())) {
                locationRepository.save(location);
                return "Location record created successfully!!!";
            } else {
                return "Location already exists in the database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Location> readLocation() {
        return locationRepository.findAll();
    }

    @Transactional
    public String updateLocation(Location location) {
        if (locationRepository.existsById(location.getId())) {
            try {
                Optional<Location> locations = locationRepository.findById(location.getId());
                locations.stream().forEach(c -> {
                    Location locationToBeUpdate = locationRepository.findById(c.getId()).get();
                    locationToBeUpdate.setId(location.getId());
                    locationToBeUpdate.setName(location.getName());
                    locationToBeUpdate.setType(location.getType());
                    locationToBeUpdate.setDimension(location.getDimension());
                    locationToBeUpdate.setUrl(location.getUrl());
                    locationToBeUpdate.setCreated(location.getCreated());
                    locationRepository.save(locationToBeUpdate);
                });
                return "Location record update";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Location does not exists in the database";
        }
    }

    @Transactional
    public String deleteLocation(Location location) {
        if (locationRepository.existsById(location.getId())) {
            try {
                Optional<Location> locations = locationRepository.findById(location.getId());
                locations.stream().forEach(l -> {
                    System.out.println(l.toString());
                    locationRepository.delete(l);
                });
                return "Location record deleted successfully";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Location Id does Not exist";
        }
    }


}
