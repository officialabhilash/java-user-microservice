package com.example.user.core.base.kafka.utils;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class CreateKafkaTopic {
    public static String createKafkaTopic(String topicName, int numPartitions, short replicationFactor) {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        String status = "IN_PROGRESS";
        try (AdminClient adminClient = AdminClient.create(props)) {
            NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
            adminClient.createTopics(Collections.singleton(newTopic)).all().get();
            System.out.println("Topic '" + topicName + "' created successfully.");
            status = "SUCCESS";
        } catch (ExecutionException e) {
            System.err.println("Topic creation failed: " + e.getCause().getMessage());
            status = "FAILURE";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Topic creation was interrupted");
            status = "INTERRUPTED";
        }
        return status;
    }
}
