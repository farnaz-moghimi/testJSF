package com.gholeydon.gholi.dao;



import com.gholeydon.gholi.entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class PersonDao {

    @Inject
    DBHandler dbHandler;

    public void createPerson() {


        try (Connection connection = dbHandler.getConnection()) {
            String query = " CREATE TABLE IF NOT EXISTS PERSON (" + "   ID integer PRIMARY KEY AUTO_INCREMENT ," + "   NAME  VARCHAR2(20)    ," + "   family    VARCHAR2(20)    ," + "  nationalcode  VARCHAR2(25) ," + "   birthDay   date  )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void insertPerson(Person person) {
        DBHandler dbHandler = new DBHandler();
        try (Connection connection = dbHandler.getConnection()) {
            String query = "INSERT INTO PERSON  (NAME, family, nationalcode, birthDay) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getFamily());
            preparedStatement.setString(3, person.getNationalcode());
            preparedStatement.setDate(4, new Date(1));

            preparedStatement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editPerson(Person person){
        DBHandler dbHandler = new DBHandler();
        try (Connection connection = dbHandler.getConnection()){
            String query ="Update PERSON Set (NAME = ? , family = ? , nationalcode = ? , birthDay = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1,person.getName());
            preparedStatement.setString(2,person.getFamily());
            preparedStatement.setString(3,person.getNationalcode());
            preparedStatement.setDate(4,new Date(20));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<Person> findAllPerson(){
        List<Person> personList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler();
        try (Connection connection = dbHandler.getConnection()){

            Statement  selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery ("Select * from PERSON");

            while(resultSet.next())
            {
                Person p = new Person();
                p.setId(Long.valueOf(resultSet.getString(1)));
                p.setName(resultSet.getString(2));
                p.setFamily(resultSet.getString(3));
                p.setNationalcode(resultSet.getString(4));
               // p.setBirthDay(LocalDate.parse((resultSet.getString(4))));
                personList.add(p);
            }

            return personList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Person findPerson(String nationalCode){

        DBHandler dbHandler = new DBHandler();
        try (Connection connection = dbHandler.getConnection()){

            String query = "Select * from PERSON WHERE nationalcode=(?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,nationalCode);

            ResultSet resultSet = preparedStatement.executeQuery();

            Person p = new Person();
            if(resultSet.getRow()==1) {
                while (resultSet.next()) {

                    p.setId(Long.valueOf(resultSet.getString(1)));
                    p.setName(resultSet.getString(2));
                    p.setFamily(resultSet.getString(3));
                    p.setNationalcode(resultSet.getString(4));
                    p.setBirthDay(LocalDate.parse((resultSet.getString(5))));
                }
            }else {
                new Exception("Bishtar 1 done peyda kardam");
            }

            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
