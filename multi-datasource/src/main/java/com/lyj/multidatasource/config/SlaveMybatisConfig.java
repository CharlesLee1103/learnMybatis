package com.lyj.multidatasource.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName slaveMybatisConfig
 * @Description slaveMybatisConfig
 * @Author liyongjie
 * @Date 2021/5/12 5:55 下午
 */
@Configuration
@MapperScan(basePackages = "com.lyj.multidatasource.mapper.slave",sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveMybatisConfig {
    @Bean("slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slave") DataSource dataSource) throws Exception {
        // 设置数据源
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件位置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String locationPattern = "classpath*:/mapper/slave/*.xml";
        mybatisSqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
        //对应数据库的entity位置
        String typeAliasesPackage = "com.lyj.multidatasource.entity.slave";
        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return mybatisSqlSessionFactoryBean.getObject();
    }
}
