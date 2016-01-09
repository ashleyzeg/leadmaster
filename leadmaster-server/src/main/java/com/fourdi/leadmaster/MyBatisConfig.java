package com.fourdi.leadmaster;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
class MyBatisConfig {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataSource dataSource;

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new Resource[] {new ClassPathResource("/mybatis/merchant.xml"),
//                                                new ClassPathResource("/mybatis/geo.xml")});
        return bean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

//    @Bean
//    public GeoMapper geoMapper() throws Exception {
//        SqlSessionTemplate sessionTemplate = sqlSessionTemplate();
//        return sessionTemplate.getMapper(GeoMapper.class);
//    }
//
//    @Bean
//    public MerchantMapper merchantMapper() throws Exception {
//        SqlSessionTemplate sessionTemplate = sqlSessionTemplate();
//        return sessionTemplate.getMapper(MerchantMapper.class);
//    }
}