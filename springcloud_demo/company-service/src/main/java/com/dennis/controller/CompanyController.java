package com.dennis.controller;

import com.dennis.domain.Result;
import com.dennis.domain.SsCompany;
import com.dennis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李恒
 * @date 2019-08-14 18:00
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 查询所有公司
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        try {
            List<SsCompany> companies = companyService.findAll(null);
            return new Result(true, "查询成功", companies);
        } catch (Exception e) {
            return new Result(false, "查询失败", null);
        }
    }

    /**
     * 查询单个公司
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable(name = "id") String id) {
        try {
            System.out.println("查询用户");
            SsCompany ssCompany = companyService.selectById(id);
            return new Result(true, "查询单个用户成功", ssCompany);
        } catch (Exception e) {
            return new Result(false, "查询单个用户失败", null);
        }
    }

    /**
     * 新增公司
     */
    @PostMapping
    public Result save(@RequestBody SsCompany ssCompany) {
        try {
            companyService.insert(ssCompany);
            return new Result(true, "保存成功", null);
        } catch (Exception e) {
            return new Result(false, "保存失败", null);
        }
    }

    /**
     * 更新公司
     *
     * @param ssCompany
     * @return
     */
    @PutMapping
    public Result update(@RequestBody SsCompany ssCompany) {
        try {
            companyService.updateById(ssCompany);
            return new Result(true, "更新成功", null);
        } catch (Exception e) {
            return new Result(false, "更新失败", null);
        }
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") String id) {
        try {
            companyService.deleteById(id);
            return new Result(true, "删除成功", null);
        } catch (Exception e) {
            return new Result(false, "删除失败", null);
        }
    }
}
