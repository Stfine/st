package com.xiaoxiang.cabbage.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConfigurationProperties(prefix="redis")
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.namespace}")
	private String namespace;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.database}")
	private int database;
	
	@Bean
	public JedisPool jedisPool() {
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(20);
		jedisPoolConfig.setMinIdle(2);
		jedisPoolConfig.setMaxIdle(10);
		
		JedisPool jedisPool = 
				new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
		
		return jedisPool;
	}
	
	
}
