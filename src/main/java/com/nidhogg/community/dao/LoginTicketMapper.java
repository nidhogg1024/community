package com.nidhogg.community.dao;

import com.nidhogg.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated
public interface LoginTicketMapper {
    int insertLoginTicket(LoginTicket loginTicket);

    LoginTicket selectByTicket(String ticket);

    int updateStatus(String ticket, int status);

}
