package com.hks.bookmanager.service;

import com.hks.bookmanager.model.User;
import com.hks.bookmanager.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

@Service
public class HostHolder {

  public User getUser() {
    return ConcurrentUtils.getHost();
  }

  public void setUser(User user) {
    ConcurrentUtils.setHost(user);
  }
}
