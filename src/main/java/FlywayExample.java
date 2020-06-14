import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class FlywayExample {

    private final static String JDBC_URL = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;DatabaseName=Examples";
    private final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String USERNAME = "client";
    private final static String PASSWORD = "client";

    public static void main(String[] args) {

        // Create our DataSource
        try (HikariDataSource dataSource = new HikariDataSource()) {
            dataSource.setJdbcUrl(JDBC_URL);
            dataSource.setUsername(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setDriverClassName(DRIVER);

            // Create a Flyway configuration
            FluentConfiguration configure = org.flywaydb.core.Flyway.configure();
            configure.dataSource(dataSource);
            configure.baselineOnMigrate(true);  // Used when applying Flyway to an existing database
            configure.table("schema_version");  // Name of schema version tracking table

            // Run migration
            Flyway flyway = new Flyway(configure);
            System.out.println("Running database migrations ...");
            flyway.repair();            // Repair checksums, history, failed migrations, etc.
            flyway.migrate();           // Apply any scripts not in the schema version table
            System.out.println("Done");
        } catch (FlywayException e) {
            e.printStackTrace();
        }
    }
}
