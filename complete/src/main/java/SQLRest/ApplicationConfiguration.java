package SQLRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    public Map<String, String> appJdbcProp(){
        Map<String, String> envdMap = new HashMap<String, String>();
        envdMap.put("url", environment.getProperty("spring.datasource.url"));
        envdMap.put("username", environment.getProperty("spring.datasource.username"));
        envdMap.put("password", environment.getProperty("spring.datasource.password"));
        return envdMap;
    }
}
