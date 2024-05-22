package mx.com.liverpool.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import mx.com.liverpool.application.generic.ServiceApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mx.liverpool"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
    ServiceApplication.class})})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
