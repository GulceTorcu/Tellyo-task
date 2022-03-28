package com.example.task2;

import android.arch.persistence.room.Entity;

import java.beans.Transient;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "video")
public class Video implements java.io.Serializable {
    private long id;
    private String name;
    private Date createdOn;
    private Set<DailyStatistics> dailyStatistics;
    private Boolean userHasAccess;

    // Getters
    @Id
    @Column(name = “id”, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = “name”, nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = “created_on”, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
        return createdOn;
    }

    @Transient
    public Boolean isUserHasAccess() {
        return userHasAccess;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "video", cascade = CascadeType.ALL)
    public Set<DailyStatistics> getDailyStatistics() {
        return dailyStatistics;
    }
}
