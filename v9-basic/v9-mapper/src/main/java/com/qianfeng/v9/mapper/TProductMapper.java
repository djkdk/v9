package com.qianfeng.v9.mapper;

import com.qianfeng.v9.common.base.IBaseDao;
import com.qianfeng.v9.entity.TProduct;

import java.util.List;

public interface TProductMapper extends IBaseDao<TProduct>{

    Long batchUpdateFlag(List<Long> ids);
}