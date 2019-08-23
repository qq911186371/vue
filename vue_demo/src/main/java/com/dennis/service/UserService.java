package com.dennis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.dennis.domain.PeUser;

import java.util.List;

public interface UserService {
    List<PeUser> findAll(Wrapper wrapper);
}
