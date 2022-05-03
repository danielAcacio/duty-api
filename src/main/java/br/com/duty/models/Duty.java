package br.com.duty.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "duty", schema = "public")
public class Duty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = true)
    private Hospital hospital;

    @Temporal(TemporalType.DATE)
    @Column(name = "duty_date", nullable = false)
    private Date date;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "duty_schedule", nullable = false)
    private Schedule schedule;


    private int ratingHappynes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getRatingHappynes() {
        return ratingHappynes;
    }
    public void setRatingHappynes(int ratingHappynes) {
        this.ratingHappynes = ratingHappynes;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
