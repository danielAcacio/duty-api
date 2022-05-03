package br.com.duty.models;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "contact")
public class Contact {

    public Contact() {}

    public Contact(int id, Long cellPhoneNumber, User user, Hospital hospital) {
        this.id = id;
        this.cellPhoneNumber = cellPhoneNumber;
        this.user = user;
        this.hospital = hospital;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "cell_phone_number", nullable = false)
    private Long cellPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(Long cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
