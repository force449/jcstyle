package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

/* 
db table 생성
 
create table members (
no int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
companyno int(20) NOT NULL
name varchar(30)  NOT NULL,
team varchar(30)  NOT NULL,
position varchar(30)  NOT NULL,
mrank varchar(30)  NOT NULL,


 메이븐 프로젝트 템플릿 생성 (CMD 창)
mvn -B archetype:generate -DgroupId=com.example -DartifactId=jcrest -Dversion=1.0.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-quickstart



);*/