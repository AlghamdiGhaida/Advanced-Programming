/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bllay
 */
@Entity
@Table(name = "hall")
public class hall implements java.io.Serializable {

    @Column(name = "hallName")
    private String hallName;

    @Id
    @Column(name = "HallNo")
    private int HallNo;

    @Column(name = "Size")
    private String Size;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "distanceFromAirport")
    private int distanceFromAirport;

    @Column(name = "distanceFromCityCenter")
    private int distanceFromCityCenter;

    @Column(name = "hallPrice")
    private int hallPrice;

    @Column(name = "numOfGates")
    private int numOfGates;

    public hall() {

    }

    public String gethallName() {
        return hallName;
    }

    public int getHallNo() {
        return HallNo;
    }

    public String getSize() {
        return Size;
    }

    public String getcity() {
        return city;
    }

    public String getstreet() {
        return street;
    }

    public int getdistanceFromAirport() {
        return distanceFromAirport;
    }

    public int getdistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    public int gethallPrice() {
        return hallPrice;
    }

    public int getnumOfGates() {
        return numOfGates;
    }

    public void sethallName(String hallName) {
        this.hallName = hallName;
    }

    public void setHallNo(int HallNo) {
        this.HallNo = HallNo;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public void setstreet(String street) {
        this.street = street;
    }

    public void setdistanceFromAirport(int distanceFromAirport) {
        this.distanceFromAirport = distanceFromAirport;
    }

    public void setdistanceFromCityCenter(int distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    public void sethallPrice(int hallPrice) {
        this.hallPrice = hallPrice;
    }

    public void setnumOfGates(int numOfGates) {
        this.numOfGates = numOfGates;
    }
}
