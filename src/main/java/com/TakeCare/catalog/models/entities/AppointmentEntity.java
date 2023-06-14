// package com.TakeCare.catalog.models.entities;

// import java.sql.Date;

// import jakarta.annotation.Generated;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class AppointmentEntity {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     private String location;
//     private String speciality;
//     private String doctor;
//     private Date date;
//     private String time;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private UserEntity user;

//     public int getId() {
//         return this.id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getLocation() {
//         return this.location;
//     }

//     public void setLocation(String location) {
//         this.location = location;
//     }

//     public String getSpeciality() {
//         return this.speciality;
//     }

//     public void setSpeciality(String speciality) {
//         this.speciality = speciality;
//     }

//     public String getDoctor() {
//         return this.doctor;
//     }

//     public void setDoctor(String doctor) {
//         this.doctor = doctor;
//     }

//     public Date getDate() {
//         return this.date;
//     }

//     public void setDate(Date date) {
//         this.date = date;
//     }

//     public String getTime() {
//         return this.time;
//     }

//     public void setTime(String time) {
//         this.time = time;
//     }

// }
