package ru.liga.intership.badcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.liga.intership.badcode.service.ConnectionService;
import ru.liga.intership.badcode.service.PersonService;

import java.sql.ResultSet;

@SpringBootApplication
public class BadcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadcodeApplication.class, args);
		PersonService personService = new PersonService();
		ConnectionService connection = new ConnectionService("jdbc:hsqldb:mem:test", "sa", "");

		System.out.println("Average Body Mass Index - " + personService.
				getAdultMaleUsersAverageBMI(connection.
						getResultSet("SELECT * FROM person WHERE sex = 'male' AND age > 18")));
	}
}
