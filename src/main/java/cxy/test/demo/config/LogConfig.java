package cxy.test.demo.config;

import cxy.test.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * Created by Caoxingyun on 2019/07/15
 */
@Configuration
public class LogConfig {

    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class); //class 参数用来判断日志是由哪个类输出的
    //如果设置了不同包下不同日志级别，不会根据你打印日志的类的包来判断，根据你传入的class来判断。

    @Bean
    public User user() {
        LOG.debug("what is your debug?");
        LOG.info("what is your info?");
        LOG.error("what is your error?");
        return new User();
    }
}
