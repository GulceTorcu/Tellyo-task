package com.example.task6;

public interface EfsDao {

    public void save(ElasticFileSystem efs);
    public ElasticFileSystem load(Class<ElasticFileSystem> elasticFileSystemClass, String id);
    public void addRecording(String fsId, Double recordedHours);

}
