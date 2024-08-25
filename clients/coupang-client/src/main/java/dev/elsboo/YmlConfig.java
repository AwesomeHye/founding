package dev.elsboo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:application-client.yml", "classpath:config/auth.yml"}, factory = YamlPropertySourceFactory.class)
public class YmlConfig {

}
