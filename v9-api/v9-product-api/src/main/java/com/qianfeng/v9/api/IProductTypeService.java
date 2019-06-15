package com.qianfeng.v9.api;

import com.qianfeng.v9.common.base.IBaseService;
import com.qianfeng.v9.entity.TProductType;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
public interface IProductTypeService extends IBaseService<TProductType>{

    public List<TProductType> queryList(Long pid);

}
