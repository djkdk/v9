package com.qianfeng.v9.api;

import com.github.pagehelper.PageInfo;
import com.qianfeng.v9.common.base.IBaseService;
import com.qianfeng.v9.entity.TProduct;
import com.qianfeng.v9.pojo.TProductVo;

import java.util.List;

/**
 * @author
 * @Date ${Date}
 */
public interface IProductService extends IBaseService<TProduct>{
    public PageInfo<TProduct> page(Integer pageIndex, Integer pageSize);

    public Long save(TProductVo vo);

    //批量删除
    public Long batchDelete(List<Long> ids);
}
