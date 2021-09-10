package com.nidhogg.community;

import com.nidhogg.community.util.RedisKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testHyperLogLog() {
        String redisKey = "uv:20210909";
        redisTemplate.opsForHyperLogLog().add(redisKey,1);
        String six="uv:20210909:20210909";
        redisTemplate.opsForHyperLogLog().union(six,redisKey);
        Long size = redisTemplate.opsForHyperLogLog().size(six);
        System.out.println(size);
    }

    @Test
    public void recordDAU() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        String redisKey = RedisKeyUtil.getDAUKey(df.format(new Date()));
        System.out.println("bitmap:"+redisKey);
        redisTemplate.opsForValue().setBit(redisKey, 152, true);
    }
}
