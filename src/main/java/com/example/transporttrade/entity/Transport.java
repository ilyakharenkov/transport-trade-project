package com.example.transporttrade.entity;


import jakarta.persistence.*;

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="brand")
    private String brand;
    @Column(name="model")
    private String model;
    @Column(name="category")
    private String category;
    @Column(name="number")
    private String number;
    @Column(name="type")
    private String type;
    @Column(name="year")
    private int year;
    @Column(name="trailer")
    private String trailer;

    public Transport(){
    }
    public Transport(String brand, String model, String category, String number, String type, int year, String trailer){
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.number = number;
        this.type = type;
        this.year = year;
        this.trailer = trailer;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }

    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getNumber(){
        return this.number;
    }
    public void setNumber(String number){
        this.number = number;
    }

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }

    public String getTrailer(){
        return this.trailer;
    }
    public void setTrailer(String trailer){
        this.trailer = trailer;
    }

}
