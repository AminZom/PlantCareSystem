package com.jsip.plant;

import javax.persistence.*;

enum Status {
    Green,
    LightGreen,
    Yellow,
    Red
}

@Entity
@Table
public class Plant {
    @Id
    @SequenceGenerator(
            name = "plant_sequence",
            sequenceName = "plant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "plant_sequence"
    )
    private Long id;
    private String name;
    private String lastWateredDate;
    private String wateringFreq;
    @Transient
    private Status status;

    public Plant() {
    }

    public Plant(Long id, String name, String lastWateredDate, String wateringFreq) {
        this.id = id;
        this.name = name;
        this.lastWateredDate = lastWateredDate;
        this.wateringFreq = wateringFreq;
    }

    public Plant(String name, String lastWateredDate, String wateringFreq) {
        this.name = name;
        this.lastWateredDate = lastWateredDate;
        this.wateringFreq = wateringFreq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastWateredDate() {
        return lastWateredDate;
    }

    public void setLastWateredDate(String lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
    }

    public String getWateringFreq() {
        return wateringFreq;
    }

    public void setWateringFreq(String wateringFreq) {
        this.wateringFreq = wateringFreq;
    }

    public Status getStatus() {
        String[] lastWateredTokens = lastWateredDate.split(" ");
        String[] wateringFreqTokens = wateringFreq.split(" ");
        int lastWateredDay = Integer.parseInt(lastWateredTokens[0]);
        int wateringFreqNum = Integer.parseInt(wateringFreqTokens[1]);
        int difference = wateringFreqNum - lastWateredDay;

        if(difference < -2)
            return Status.Red;
        else if(difference == -1 || difference == -2)
            return Status.Yellow;
        else if(difference == 0 || difference == 1)
            return Status.LightGreen;
        else
            return Status.Green;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastWateredDate='" + lastWateredDate + '\'' +
                ", status=" + status +
                '}';
    }
}
