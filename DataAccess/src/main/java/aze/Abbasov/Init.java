package aze.Abbasov;

import org.flywaydb.core.Flyway;

public class Init {
    public static void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:6432/postgres",
                        "postgres", "postgres")
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }
}
