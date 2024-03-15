/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bllay
 */
@Entity
@Table(name = "reservation")
public class reservation implements java.io.Serializable {

    //@OneToOne
    @Column(name = "OrganizationName")
    private String OrganizationName;

    @Id
    @Column(name = "reservationNo")
    private int reservationNo;

    @Column(name = "ConferenceType")
    private String ConferenceType;

    @Column(name = "TotalPrice")
    private int TotalPrice;

    @Column(name = "GuestsNo")
    private int GuestsNo;

    @Column(name = "Date")
    private String Date;

    //@OneToOne
    @Column(name = "HallNo")
    private int HallNo;
    
    @Column(name = "services")
    private String services;

    public reservation() {

    }

    public String getOrganizationName() {
        return OrganizationName;
    }
    
    public String getservices(){
        return services;
    }

    public int getreservationNo() {
        return reservationNo;
    }

    public String getConferenceType() {
        return ConferenceType;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public int getGuestsNo() {
        return GuestsNo;
    }

    public String getDate() {
        return Date;
    }

    public int getHallNo() {
        return HallNo;
    }


    public void setOrganizationName(String OrganizationName) {
        this.OrganizationName = OrganizationName;
    }
    
    public void setservices(String services){
        this.services = services;
    }

    public void setreservationNo(int reservationNo) {
        this.reservationNo = reservationNo;
    }

    public void setConferenceType(String ConferenceType) {
        this.ConferenceType = ConferenceType;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setGuestsNo(int GuestsNo) {
        this.GuestsNo = GuestsNo;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setHallNo(int HallNo) {
        this.HallNo = HallNo;
    }

}
