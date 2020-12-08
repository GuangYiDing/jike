package me.cocode.jike.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.BuilderDefaults;

/**
 * 2020/12/5 12:32
 *
 * @author xiaodingsiren
 */
@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_DIRECT_JIKE_MSG = "exchange_jike_msg";


    @Bean(EXCHANGE_DIRECT_JIKE_MSG)
    public Exchange jikeMsg() {
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT_JIKE_MSG).durable(true).build();
    }


}

