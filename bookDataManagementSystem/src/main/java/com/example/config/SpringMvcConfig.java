package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.example.controller", "com.example.config", "com.example.interceptor"})
@EnableWebMvc
@Import(FileConfig.class)
public class SpringMvcConfig {
}
