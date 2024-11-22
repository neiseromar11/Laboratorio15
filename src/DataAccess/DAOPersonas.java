/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class DAOPersonas {
    
    private Connection connection;
    private Statement statement;
    public DAOPersonas(Connection con){
    try{
        connection = con ; 
   statement= con.createStatement();
    }catch (Exception s){
        System.err.println(s.getMessage());
    
    }
    
    }
    
    public List<Persona> getPersonas(){
        try{
             String query="Select * from persona";
            ResultSet resultSet=statement.executeQuery(query);
            return PersonasExtras.fromResultSet(resultSet);
           
        } catch (Exception s){
        System.err.println(s.getMessage());
        return null;
    
    }
    }
    
    
    
    public boolean actualizarDatos(Persona per){
    
        
    }
    
}

