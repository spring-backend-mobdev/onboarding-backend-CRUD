package cl.mobdev.onboarding.crud.controller;

import cl.mobdev.onboarding.crud.entity.Character;
import cl.mobdev.onboarding.crud.entity.Location;
import cl.mobdev.onboarding.crud.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private LocationServiceImpl locationService;

    @RequestMapping(value = "/infolocation", method = RequestMethod.GET)
    public String info() {
        return "Application is up...";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<Location> readLocation() {
        return locationService.readLocation();
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteLocation(@RequestBody Location location) {
        return locationService.deleteLocation(location);
    }
}
