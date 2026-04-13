package mwa.giles.shiftmanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name =  "SHIFTS")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shiftId;
    public String shiftName;
    public Date shiftDate;
    public double rate;
    public double hours;
    public double totalPay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User user;
    }