package com.TakeCare.catalog.models.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.ManyToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;

    @Column(unique = true)
    private String email;

    private String phone_Number;
    private String password;

    // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    // private List<AppointmentEntity> appointment;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ChartEntity> chart;

    public UserEntity() {
    }

    
    public UserEntity(String first_name, String last_name, String email, String phone_Number, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_Number = phone_Number;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return this.phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // public List<AppointmentEntity> getAppointment() {
    //     return this.appointment;
    // }

    // public void setAppointment(List<AppointmentEntity> appointment) {
    //     this.appointment = appointment;
    // }


    public List<ChartEntity> getChart() {
        return this.chart;
    }

    public void addChart(ChartEntity chart) {
        if (this.chart != null){
            this.chart.add(chart);
        } else {
            this.chart = new ArrayList<>();
        }
    }

    public void resetChart(){
        chart = new ArrayList<>();
    }



}
