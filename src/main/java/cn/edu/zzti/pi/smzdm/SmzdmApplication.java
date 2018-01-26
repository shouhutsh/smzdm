package cn.edu.zzti.pi.smzdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmzdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmzdmApplication.class, args);
    }
}
