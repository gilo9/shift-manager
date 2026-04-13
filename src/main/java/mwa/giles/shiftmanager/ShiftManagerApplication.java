package mwa.giles.shiftmanager;

import mwa.giles.shiftmanager.model.Shift;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class ShiftManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiftManagerApplication.class, args);
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:shiftdb","sa","");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
