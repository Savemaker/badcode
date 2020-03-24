package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {


    /**
     * Возвращает средний индекс массы тела всех лиц мужского пола старше 18 лет
     *
     * @return
     */
    public double getAdultMaleUsersAverageBMI(ResultSet resultSet) {
        double totalBMI = 0.0;
        long countOfPerson = 0;
        double averageBMI = 0.0;
        int FAILURE = -1;

        try {
            List<Person> adultPersons = getPeopleList(resultSet);
            for (Person p : adultPersons) {
                double heightInMeters = p.getHeight() / 100d;
                double BMI = p.getWeight() / (Double) (heightInMeters * heightInMeters);
                totalBMI += BMI;
            }
            countOfPerson = adultPersons.size();
            averageBMI = totalBMI / countOfPerson;
            return averageBMI;

        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public List<Person> getPeopleList(ResultSet resultSet) throws SQLException {
        List<Person> adultPersons = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            //Retrieve by column name
            person.setId(resultSet.getLong("id"));
            person.setSex(resultSet.getString("sex"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getLong("age"));
            person.setWeight(resultSet.getLong("weight"));
            person.setHeight(resultSet.getLong("height"));
            adultPersons.add(person);
        }
        return adultPersons;
    }

}
