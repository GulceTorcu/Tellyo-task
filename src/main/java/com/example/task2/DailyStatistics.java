package com.example.task2;

import java.util.Date;

@Entity
@Table(name = "dailyStatistics")
public class DailyStatistics implements java.io.Serializable {
    private long id;
    private Date snapshotTime;
    private long views;
    private long comments;
    private Video relatedVideo;

    // Getters
    @Id
    @Column(name = “stats_id”, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = “snapshot_time”, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSnapshotTime() {
        return snapshotTime;
    }

    @Column(name = “views”, nullable = false)
    public long getViews() {
        return views;
    }

    @Column(name = “comments”, nullable = false)
    public long getComments() {
        return comments;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    public Video getRelatedVideo() {
        return relatedVideo;
    }

    ;
}
