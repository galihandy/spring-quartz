package explr.spring.configs;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@Configuration
public class FlywayConfigs {

    @Autowired
    DataSource dataSource;

    @Bean(name = "flyway")
    public Flyway flywayInitializerDefault(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db/seeds");
        flyway.setBaselineOnMigrate(true);
        flyway.clean();
        flyway.migrate();
        return flyway;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
