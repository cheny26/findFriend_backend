package com.cheny.findFriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class findFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(findFriendApplication.class, args);
    }

}
