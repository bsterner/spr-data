package com.spr.init;

/**
 * Created by bsterner on 12/21/16.
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"com.test.repositories.*"})
public class PersistenceJpaConfig {
/*
    @Autowired
    JpaVendorAdapter jpaVendorAdapter;

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("testdb")
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

    @Bean
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.test.domain.*");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

    @Bean
    public JpaVendorAdapter getJpaVendor() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }*/
}
