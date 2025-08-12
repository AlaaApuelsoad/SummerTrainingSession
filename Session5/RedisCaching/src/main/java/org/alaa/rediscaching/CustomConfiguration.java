package org.alaa.rediscaching;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class CustomConfiguration {


    /**
     * Redis cache configuration bean to customize how Spring Boot interacts with Redis for caching.
     * - This bean tells Spring how to serialize cache values before storing them in Redis.
     * - By default, Spring uses Java's binary serialization (JDK serialization), which is not human-readable.
     * - This configuration changes that to use JSON (via Jackson), making values readable and easier to debug.
     */

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()//--disable caching null values
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(
                                new GenericJackson2JsonRedisSerializer()
                        )
                );
    }



}
