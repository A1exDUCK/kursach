package org.example.config;



import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.session.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "org.example.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "tables"; // Укажите имя вашего keyspace
    }

    @Bean
    @Primary
    public CqlSessionFactoryBean session() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints("127.0.0.1"); // Укажите адрес вашего Cassandra сервера
        session.setPort(9042); // Укажите порт вашего Cassandra сервера
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter("datacenter1");
        return session;
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }

    @Bean
    public CassandraTemplate cassandraTemplate(Session session, CassandraConverter converter) {
        return new CassandraTemplate((CqlSession) session, converter);
    }
}