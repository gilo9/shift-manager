package mwa.giles.shiftmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Shift {
    @Id
    @GeneratedValue
    private Long shiftId;
    public String shiftName;
    public Date shiftDate;
    public Long employeeId;
    public double Rate;
    public double Hours;
    public double totalpay;

    protected Shift(){}
    public Shift(String shiftName, Date shiftDate, int employeeId, double Rate, double Hours){}



}
