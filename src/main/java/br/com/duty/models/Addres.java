package br.com.duty.models;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "address")
public class Addres{

    public Addres() {}
    public Addres(int id, int zipcode, String street, int unitNumber) {
        this.id = id;
        this.zipcode = zipcode;
        this.street = street;
        this.unitNumber = unitNumber;
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "zipcode", nullable = false)
    private int zipcode;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "unit_name", nullable = false)
    private int unitNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
}
