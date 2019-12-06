package com.example.JPATest;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaTestApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

	@A
	pri

	@Bean
	public CommandLineRunner demo(PersonRepository personrepository) {

		return (args) -> {


			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			Date date = dateFormat.parse("2018-10-09");

			log.info(date.toString());
			Vehicule audi = new Vehicule();


			Date date1 = dateFormat.parse("2018-10-10");
			Date date2 = dateFormat.parse("2019-10-09");
			Date date3 = dateFormat.parse("2016-05-10");
			Date date4 = dateFormat.parse("2018-11-09");
			rent record1 = new rent( date1, date2);
			rent record2 = new rent(date3,date4);

			Person member = new Person("HAMZA");
			Person member2 = new Person("NISSRINE");
			Person member3 = new Person("Nis");


			personrepository.save(member);
			personrepository.save(member2);
			personrepository.save(member3);
			audi.getRents().add(record1);
		    audi.getRents().add(record2);

			record1.setVehicule(audi);
			record2.setVehicule(audi);



			member.getRents().add(record1);
			member.getRents().add(record2);

			record1.setPerson(member);
			record2.setPerson(member);

			personrepository.save(member);

			log.info("Vehicules found with findAll():");

			log.info("-------------------------------");

			for (Person person : personrepository.findAll()) {

				log.info(person.toString());

			}

			log.info("");






			log.info("Persons found with findAll():");

			log.info("-------------------------------");

			for ( Person person : personrepository.findAll()) {

				log.info(person.toString());

			}

			log.info("");



		};
	}
}