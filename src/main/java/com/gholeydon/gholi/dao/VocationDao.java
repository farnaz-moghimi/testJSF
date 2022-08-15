package com.gholeydon.gholi.dao;



import com.gholeydon.gholi.entity.Vocation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@RequestScoped
public class VocationDao {

    @Inject
    DBHandler dbHandler;

    public void createVocation(){

        try(Connection connection = dbHandler.getConnection()) {
            String query = "CREATE TABLE IF NOT EXISTS VOCATION ( " + "ID  integer PRIMARY KEY AUTO_INCREMENT,"+ "VDate date," + "DURATION  VARCHAR2(20)," +"PERSON  VARCHAR2(20))";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertVocation(Vocation vocation){

        try (Connection connection = dbHandler.getConnection()){
            String  query ="INSERT INTO VOCATION (DATE,DURATION,PERSON) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setDate(1,new Date(20));
            preparedStatement.setLong(2,vocation.getDuration());
            preparedStatement.setLong(3,vocation.getPerson().getId());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
