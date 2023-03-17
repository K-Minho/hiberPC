package shop.mtcoding.hiberpc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.mtcoding.hiberpc.config.filter.MyBlackListFilter;

@Configuration
public class FilterRegisterConfig {

    @Bean
    public FilterRegistrationBean<?> blackListFilter() {
        FilterRegistrationBean<MyBlackListFilter> regist = new FilterRegistrationBean<>();
        regist.setFilter(new MyBlackListFilter());
        regist.addUrlPatterns("/filter");
        regist.setOrder(1); // 필터의 순서
        return regist;
    }
}
