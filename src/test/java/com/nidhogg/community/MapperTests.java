package com.nidhogg.community;

import com.nidhogg.community.dao.DiscussPostMapper;
import com.nidhogg.community.dao.LoginTicketMapper;
import com.nidhogg.community.dao.UserMapper;
import com.nidhogg.community.entity.DiscussPost;
import com.nidhogg.community.entity.LoginTicket;
import com.nidhogg.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void loginTest(){
        /*LoginTicket loginTicket=new LoginTicket();
        loginTicket.setUserId(1);
        loginTicket.setTicket("123");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date());
        int i = loginTicketMapper.insertLoginTicket(loginTicket);
        System.out.println(i);*/
        /*LoginTicket ticket = loginTicketMapper.selectByTicket("123");
        System.out.println(ticket);
        int i = loginTicketMapper.updateStatus(ticket.getTicket(), 1);
        System.out.println(i);*/
        User user = userMapper.selectByName("nidhogg");
        System.out.println(user.getPassword());
    }
}
