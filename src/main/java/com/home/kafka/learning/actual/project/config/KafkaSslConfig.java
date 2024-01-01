package com.home.kafka.learning.actual.project.config;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Map;

//@Configuration
public class KafkaSslConfig {

    @Value("${kafka.ssl.enabled}")
    private Boolean kafkaSslEnabled;

    @Value("${kafka.ssl.keystore.location:#{null}}")
    private String kafkaSslKeystoreLocation;

    @Value("${kafka.ssl.keystore.password:#{null}}")
    private String kafkaSslKeystorePassword;

    @Value("${kafka.ssl.keystore.type:#{null}}")
    private String kafkaSslKeystoreType;

    @Value("${kafka.ssl.truststore.location:#{null}}")
    private String kafkaSslTruststoreLocation;

    @Value("${kafka.ssl.truststore.password:#{null}}")
    private String kafkaSslTruststorePassword;

    @Value("${kafka.ssl.truststore.type:#{null}}")
    private String kafkaSslTruststoreType;

    @Value("${kafka.ssl.endpoint.identification.algorithm:#{null}}")
    private String kafkaSslEndpointIdentificationAlgo;

    public Map<String, Object> kafkaSslConfig(Map<String, Object> props) throws FileNotFoundException {
        if (Boolean.TRUE.equals(kafkaSslEnabled)) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,"SSL");
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, ResourceUtils.getFile(this.kafkaSslTruststoreLocation).getAbsolutePath());
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, this.kafkaSslTruststorePassword);
            props.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, this.kafkaSslTruststoreType);

            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, ResourceUtils.getFile(this.kafkaSslKeystoreLocation).getAbsolutePath());
            props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, this.kafkaSslKeystorePassword);
            props.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, this.kafkaSslKeystoreType);
            props.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, this.kafkaSslEndpointIdentificationAlgo);

        }
        return props;

    }





}
