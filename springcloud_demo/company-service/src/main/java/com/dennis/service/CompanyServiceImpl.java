package com.dennis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.dennis.dao.CompanyDao;
import com.dennis.domain.SsCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李恒
 * @date 2019-08-14 19:41
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<SsCompany> findAll(Wrapper wrapper) {
        return companyDao.selectList(wrapper);
    }

    @Override
    public SsCompany selectById(String id) {
        return companyDao.selectById(id);
    }

    @Override
    public void insert(SsCompany ssCompany) {
        companyDao.insert(ssCompany);
    }

    @Override
    public void updateById(SsCompany ssCompany) {
        companyDao.updateById(ssCompany);
    }

    @Override
    public void deleteById(String companyId) {
        companyDao.deleteById(companyId);
    }
}
