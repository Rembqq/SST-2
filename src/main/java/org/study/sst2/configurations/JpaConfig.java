//package org.study.sst2.configurations;
//
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import javax.sql.DataSource;
//
//@Configuration
//public class JpaConfig {
//
//    private final DataSource dataSource;
//
//    // Конструктор для инжекции DataSource
//    public JpaConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
//        LocalContainerEntityManagerFactoryBean factoryBean = builder
//                .dataSource(dataSource)
//                .packages("org.study.sst2.models") // укажите ваш пакет с сущностями
//                .build();
//        // Устанавливаем правильный интерфейс EntityManagerFactory
//        factoryBean.setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
//        return factoryBean;
//    }
//}
