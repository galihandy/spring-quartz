package explr.spring.domain.user;

import explr.spring.core.model.Profile;
import explr.spring.domain.user.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping
    public List<Profile> getProfiles() {
        System.out.println("SIZE PROFILES " + profileRepository.findAll().size());
        return profileRepository.findAll();
    }

    //@RequestMapping
    public Profile getProfile(@RequestParam int userId) {
         return profileRepository.findByUserId(userId);
    }
}
