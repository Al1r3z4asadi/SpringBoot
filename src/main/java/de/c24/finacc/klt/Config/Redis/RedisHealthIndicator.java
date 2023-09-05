package de.c24.finacc.klt.Config.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
@Component
public class RedisHealthIndicator implements HealthIndicator {


    private final RedisProperties redisProperties;

    @Autowired
    public RedisHealthIndicator(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }
    @Override
    public Health health() {
        try (Jedis jedis = new Jedis(redisProperties.getHost())) {
            // Check the connection status by performing a simple operation (e.g., PING)
            String pingResponse = jedis.ping();
            if ("PONG".equals(pingResponse)) {
                return Health.up().build();
            } else {
                return Health.down()
                        .withDetail("message", "Redis is not responding correctly")
                        .build();
            }
        } catch (Exception e) {
            // Log any exceptions related to Redis connection
            // You can replace System.out with your preferred logging mechanism
            System.out.println("Redis connection error: " + e.getMessage());
            return Health.down()
                    .withDetail("message", "Redis connection error: " + e.getMessage())
                    .build();
        }
    }
}