package cl.mobdev.onboarding.crud.controller;

import cl.mobdev.onboarding.crud.entity.Character;
import cl.mobdev.onboarding.crud.service.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharactersController {

    @Autowired
    private CharacterServiceImpl characterService;

    @RequestMapping(value = "/infocharacter", method = RequestMethod.GET)
    public String info() {
        return "Application is up...";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<Character> readCharacter() {
        return characterService.readCharacter();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCharacter(@RequestBody Character character) {
        return characterService.updateCharacter(character);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteCharacter(@RequestBody Character character) {
        return characterService.deleteCharacter(character);
    }
}
