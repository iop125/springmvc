package com.my.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {

    public void redisPool(){
        //创建一连接池对象
        JedisPool jedisPool = new JedisPool("192.168.3.115", 6380);
        //从连接池中获得连接
        Jedis jedis = jedisPool.getResource();
        String s = jedis.set("key2","key1-key1","NX","EX",10L);
        String s1 = jedis.set("key2","key1-key1");
        System.out.println("------"+s);

        String result = jedis.get("ke1") ;
        System.out.println(result);
        //关闭连接
        jedis.close();

        //关闭连接池
        jedisPool.close();

    }
    public static void main(String [] a){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.redisPool();

    }
}
