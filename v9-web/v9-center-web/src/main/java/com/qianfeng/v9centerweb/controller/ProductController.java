package com.qianfeng.v9centerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.qianfeng.v9.api.IProductService;
import com.qianfeng.v9.common.pojo.ResultBean;
import com.qianfeng.v9.entity.TProduct;
import com.qianfeng.v9.pojo.TProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Reference
    private IProductService productService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public TProduct getById(@PathVariable Long id){
        return productService.selectByPrimaryKey(id);
    }

    @RequestMapping("list")
    public String list(Model model){
        List<TProduct> list=productService.list();
        model.addAttribute("list",list);
        return "product/list";
    }

    @RequestMapping("page/{pageIndex}/{pagesize}")
    public String page(@PathVariable("pageIndex") Integer pageIndex,@PathVariable("pagesize") Integer pagesize,Model model){
        PageInfo<TProduct> page=productService.page(pageIndex,pagesize);
        model.addAttribute("page",page);
        return "product/list";
    }

    @PostMapping("add")
    public String add(TProductVo vo){
        System.out.println(vo);
        Long id=productService.save(vo);
        return "redirect:/product/page/1/1";
    }

    @PostMapping("delete/{id}")
    @ResponseBody
    public ResultBean deleteById(@PathVariable("id") Long id){
        int count=productService.deleteByPrimaryKey(id);
        if (count>0){
            return new ResultBean("200","删除成功");
        }
            return new ResultBean("400","删除失败");
    }

    @PostMapping("batchDel")
    @ResponseBody
    public ResultBean batchDel(@RequestParam List<Long> ids){
        Long count=productService.batchDelete(ids);
        if (count>0){
            return new ResultBean("200","删除成功");
        }
        return new ResultBean("400","删除失败");
    }
}
