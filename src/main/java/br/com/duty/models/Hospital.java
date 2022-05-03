package br.com.duty.models;

import javax.persistence.*;

@Entity
@Table(name = "hospital", schema = "public")
public class Hospital {


    public Hospital() {}

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital(int id) {
        this.id = id;
    }

    public Hospital(int id, String name, Addres addres) {
        this.id = id;
        this.name = name;
        this.addres = addres;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Addres addres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Addres getAddres() {
        return addres;
    }

    public void setAddres(Addres addres) {
        this.addres = addres;
    }
}
