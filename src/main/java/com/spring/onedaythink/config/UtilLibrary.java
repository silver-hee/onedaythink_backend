package com.spring.onedaythink.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class UtilLibrary {

    Logger log = LogManager.getLogger("case3");
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String convertCreateAt(String createAt) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < createAt.length(); i++) {
            sb.append(createAt.charAt(i));
            if (i == 3 || i == 5 ) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public String createDateFormat(String pattern) {
        Date date = new Date();
        // "yyyy-MM-dd" or "yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String formatDate = sdf.format(date);
        log.debug(formatDate);
        return formatDate;
    }

}
