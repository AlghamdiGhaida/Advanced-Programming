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
@Table(name = "user")
public class user implements java.io.Serializable {

    @Id
    @Column(name = "OrganizationName")
    private String OrganizationName;

    @Column(name = "ISIN")
    private int ISIN;

    @Column(name = "PhoneNumber")
    private int PhoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "Password")
    private String Password;

    public user() {

    }

    public user(String OrganizationName, int ISIN, int PhoneNumber, String Password) {
        this.OrganizationName = OrganizationName;
        this.ISIN = ISIN;
        this.PhoneNumber = PhoneNumber;
        this.Password = Password;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public String getEmail() {
        return email;
    }

    public int getISIN() {
        return ISIN;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setOrganizationName(String OrganizationName) {
        this.OrganizationName = OrganizationName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setISIN(int ISIN) {
        this.ISIN = ISIN;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
