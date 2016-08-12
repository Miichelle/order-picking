package generator;

import java.io.IOException;
import java.util.Properties;

/**
 * Michelle Beckers
 * Datum: 12-8-2016
 * Time: 23:34
 */
public class AMQPProperties {
    private final Properties properties;

    private final String host;
    private final String queue;

    public AMQPProperties(String propertyResourcePath, String provider) {
        this.properties = new Properties();

        try {
            this.properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyResourcePath));
        } catch (IOException | IllegalArgumentException | NullPointerException ex) {
            // log error occurrence during reading of amqp properties
            System.exit(0);
        }

        String hostPropertyKey = String.format("%s.sender.host", provider);
        String queuePropertyKey = String.format("%s.sender.queue", provider);

        this.host = this.properties.getProperty(hostPropertyKey);
        this.queue = this.properties.getProperty(queuePropertyKey);
    }

    public String getHost() { return this.host; }
    public String getQueue() { return this.queue; }
}
