package com.dennis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.dennis.domain.SsCompany;

import java.util.List;

/**
 * @author 李恒
 * @date 2019-08-14 19:37
 */
public interface CompanyService {
    List<SsCompany> findAll(Wrapper wrapper);

    SsCompany selectById(String id);

    void insert(SsCompany ssCompany);

    void updateById(SsCompany ssCompany);

    void deleteById(String companyId);
}
