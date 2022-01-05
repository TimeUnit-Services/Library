package dev.timeunit.libraries.redis;

import redis.clients.jedis.Jedis;

public interface RedisCommand<T> {
    T execute(Jedis paramJedis);
}
