package com.qianfeng.v9.mapper;

import com.qianfeng.v9.common.base.IBaseDao;
import com.qianfeng.v9.entity.TProductType;

import java.util.List;

public interface TProductTypeMapper extends IBaseDao<TProductType>{
    public List<TProductType> queryList(Long pid);

}