package explr.spring.configs.quartz;

import explr.spring.job.ProfilesUpdaterJob;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by galih.a.pradana on 8/3/2016.
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory() {
        return new AutowiringSpringBeanJobFactory();
    }

    @Bean
    public JobDetail jobDetail() {
        return newJob(ProfilesUpdaterJob.class)
                .storeDurably()
                .withIdentity("Qrtz_Job_Detail")
                .withDescription("Invoke Profile Updater Job service...")
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        return newTrigger()
                .forJob(jobDetail)
                .withIdentity("Qrtz_Trigger")
                .withDescription("Sample trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInMilliseconds(5000))
                .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(
            final DataSource dataSource,
            final PlatformTransactionManager transactionManager,
            JobDetail jobDetail,
            Trigger trigger) {
        final SchedulerFactoryBean scheduler = new SchedulerFactoryBean();

        scheduler.setWaitForJobsToCompleteOnShutdown(true);
        scheduler.setConfigLocation(new ClassPathResource("quartz.properties"));
        scheduler.setDataSource(dataSource);
        scheduler.setTransactionManager(transactionManager);
        //scheduler.setAutoStartup(false); // default is true
        //scheduler.setOverwriteExistingJobs(true);
        //scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        scheduler.setJobFactory(autowiringSpringBeanJobFactory());
        scheduler.setJobDetails(jobDetail);
        scheduler.setTriggers(trigger);

        return scheduler;
    }
}
