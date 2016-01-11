package com.fourdi.leadmaster;

import com.fourdi.leadmaster.model.domain.CompanyMapper;
import com.fourdi.leadmaster.model.domain.LeadMapper;
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
        bean.setMapperLocations(new Resource[]{new ClassPathResource("/mybatis/lead.xml"),
                                               new ClassPathResource("/mybatis/company.xml")});
        return bean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    public LeadMapper leadMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = sqlSessionTemplate();
        return sessionTemplate.getMapper(LeadMapper.class);
    }

    @Bean
    public CompanyMapper companyMapper() throws Exception {
        SqlSessionTemplate sessionTemplate = sqlSessionTemplate();
        return sessionTemplate.getMapper(CompanyMapper.class);
    }
}

