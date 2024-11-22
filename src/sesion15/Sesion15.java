/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sesion15;

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
public class Sesion15 {
private static final String URL="jdbc:mysql://10.144.176.69:3307/lab";
    private static final String USER="root";
    private static final String PASSWORD="root";
    public static void main (String [] args){
     
    Connection connection=null;
    
    try{
        connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement();
        
        String query="Select * from persona";
        ResultSet resultSet=statement.executeQuery(query);
        
        while (resultSet.next()) {
            System.out.println(""
                    + "ID"+ resultSet.getInt(1)
                    + "| Nombre : "+resultSet.getString(2)
                    + "| Apellido : "+resultSet.getString(3)
                    + "| DNI : "+resultSet.getString(4)
                    + "| Edad : "+resultSet.getString(5)
                    + "| Correo : "+resultSet.getString(6)
                    ); 
        }
        
        String nuevoCorreo ="neiser123@gmail.com";
        int idPersona=1;
        String queryUpdate="update persona set correo= '"+nuevoCorreo+"' "
                + "where idpersona=" + idPersona;
        
        int executeUpdate=statement.executeUpdate(queryUpdate);
        if (executeUpdate>0) {
            System.out.println("SE ACTUALIZO el correo");
            
        }
        else {
        
            System.err.println("NO se pudo actualizar");
        }
        
        
        String nombre = "Pedro";
        String apellido="Pelis";
        String dni = " 32165497";
        int edad = 27;
        String correo ="pedro123@gmail.com";
         String queryIns = ""

          + "INSERT INTO `lab`.`persona`\n"
          + "(`nombre`,\n"
          + "`apellido`,\n"
          + "`dni`,\n"
          + "`edad`,\n"
          + "`correo`)\n"
          + "VALUES\n"
          + "('" + nombre + "',\n"
          + "'" + apellido + "',\n"
          + "'" + dni + "',\n"
          + edad + ",\n"
          + "'" + correo + "');";
 
                
              int executeIns=statement.executeUpdate(queryIns);
              if (executeIns>0) {
                  System.out.println("SE INSERTO EL NUEVO REGISTRO");
            
        }else
              {
                  System.err.println("No se pudo insertar");
              }
                
               
               int idPersonaDel = 12;
               String queryDel = ""
               + "DELETE FROM `lab`.`persona`\n"
               + "WHERE idpersona = "+idPersonaDel;
                int executeDel = statement.executeUpdate(queryDel);
                if (executeDel > 0) {
                  System.out.println("SE ELIMINÓ EL NUEVO REGISTRO");
                } else {
                  System.err.println("No se pudo eliminar");
                }         
        
    }
    
    
    catch (SQLException e){
        e.printStackTrace();
    
    }
   
    }
    
}
