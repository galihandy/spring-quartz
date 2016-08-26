package explr.spring.job;

import explr.spring.domain.user.repositories.ProfileRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@Component
public class ProfilesUpdaterJob implements Job{

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    public void updateProfileDesc() {
        //System.out.println("The time is now " + dateFormat.format(new Date()));
        profileRepository.findAll().stream()
                .map(p -> {
                    p.setDescription("desc " + dateFormat.format(new Date()));
                    return p;
                }).forEach(profile -> profileRepository.save(profile));
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        updateProfileDesc();
    }
}
