package agus.ramdan.cdt.core.trx.config;

import agus.ramdan.base.interceptor.AuthorizationRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new AuthorizationRequestInterceptor();
    }
}
