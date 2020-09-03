package com.hks.bookmanager.interceptor;

import com.hks.bookmanager.model.Ticket;
import com.hks.bookmanager.model.User;
import com.hks.bookmanager.service.TicketService;
import com.hks.bookmanager.service.UserService;
import com.hks.bookmanager.utils.ConcurrentUtils;
import com.hks.bookmanager.utils.CookieUtils;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HostInfoInterceptor implements HandlerInterceptor {

  @Autowired
  private TicketService ticketService;

  @Autowired
  private UserService userService;

  /**
   * 为注入host信息
   *
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String t = CookieUtils.getCookie("t", request);
    if (!StringUtils.isEmpty(t)) {
      Ticket ticket = ticketService.getTicket(t);
      if (ticket != null && ticket.getExpiredAt().after(new Date())) {
        User host = userService.getUser(ticket.getUserId());
        ConcurrentUtils.setHost(host);
      }
    }
    return true;
  }

}
