package com.example.task6;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

public class EfsDaoImpl implements EfsDao {

    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

    @Override
    public void save(ElasticFileSystem efs) {
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.save(efs);
    }

    @Override
    public ElasticFileSystem load(Class<ElasticFileSystem> elasticFileSystemClass, String id) {
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        ElasticFileSystem efs =mapper.load(ElasticFileSystem.class, id);
        return efs;
    }

    @Override
    public void addRecording(String fsId, Double recordedHours) {
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        ElasticFileSystem efs=load(ElasticFileSystem.class, fsId);
        efs.setMounts(efs.getMounts++);
        efs.setRecordedHours(efs.getRecordedHours+=recordedHours);
        mapper.save(efs);
    }

}
