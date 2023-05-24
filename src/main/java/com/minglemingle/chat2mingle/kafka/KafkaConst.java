package com.minglemingle.chat2mingle.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaConst {
    public static final String BOOTSTRAP_SERVER;
    public static final String AUTO_OFFSET_RESET;
    public static final String GROUP_ID;

    private KafkaConst() {}

    static {
        Properties properties = new Properties();
        try (InputStream inputStream = KafkaConst.class.getResourceAsStream("/config/kafka.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retrieve the values from the properties object and assign them to the fields
        BOOTSTRAP_SERVER = properties.getProperty("kafka.bootstrap_server");
        AUTO_OFFSET_RESET = properties.getProperty("kafka.auto_offset_reset");
        GROUP_ID =  properties.getProperty("kafka.group_id");
    }

}
