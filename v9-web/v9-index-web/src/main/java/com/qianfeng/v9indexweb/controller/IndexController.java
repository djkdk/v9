package com.qianfeng.v9indexweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qianfeng.v9.api.IProductTypeService;
import com.qianfeng.v9.entity.TProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Reference
    private IProductTypeService productTypeService;

    @RequestMapping("home")
    public String showProductType(Model model){
        List<TProductType> list=productTypeService.list();
        model.addAttribute("list",list);
        return "home";
    }
}
