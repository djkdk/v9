package com.qf.v9productservice.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qianfeng.v9.api.IProductTypeService;
import com.qianfeng.v9.common.base.BaseServiceImpl;
import com.qianfeng.v9.common.base.IBaseDao;
import com.qianfeng.v9.entity.TProductType;
import com.qianfeng.v9.mapper.TProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
@Service
public class ProductTypeServiceImpl extends BaseServiceImpl<TProductType> implements IProductTypeService{
    @Autowired
    private TProductTypeMapper productTypeMapper;

    @Override
    public IBaseDao<TProductType> getBaseDao() {
        return productTypeMapper;
    }

    @Override
    public List<TProductType> queryList(Long pid) {
        return productTypeMapper.queryList(pid);
    }
}
