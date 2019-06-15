package com.qianfeng.v9centerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qianfeng.v9.api.IProductTypeService;
import com.qianfeng.v9.entity.TProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
@Controller
@RequestMapping("producttype")
public class ProductTypeController {
    @Reference
    private IProductTypeService productTypeService;

    @RequestMapping("query")
    @ResponseBody
    public List<TProductType> query(@RequestParam Long pid){
        List<TProductType> list=productTypeService.queryList(pid);
        return list;
    }
}
