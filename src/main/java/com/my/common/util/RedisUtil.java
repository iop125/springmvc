package com.my.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RedisUtil {

    public void redisPool(){
        //创建一连接池对象
        JedisPool jedisPool = new JedisPool("39.104.139.60", 6379);
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
        System.out.println( redisUtil.lambdaMaxInteger());
        String a1 = "a";
//        Optional
////                .ofNullable(a)
////                .map(k->k+"bc")
////                .filter(::hasMultibyte)
////                .orElseThrow(()->new Exception("错误"));

    }

    public int lambdaMaxInteger() {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(129);
        integers.add(1111);
        integers.add(93);
        integers.add(66);
        integers.add(7);
        integers.add(2);
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a,b));
    }
}
