package com.qf.v9productservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.v9.api.IProductService;
import com.qianfeng.v9.common.base.BaseServiceImpl;
import com.qianfeng.v9.common.base.IBaseDao;
import com.qianfeng.v9.entity.TProduct;
import com.qianfeng.v9.entity.TProductDesc;
import com.qianfeng.v9.mapper.TProductDescMapper;
import com.qianfeng.v9.mapper.TProductMapper;
import com.qianfeng.v9.pojo.TProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author
 * @Date ${Date}
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<TProduct> implements IProductService {
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductDescMapper tProductDescMapper;
    @Override
    public IBaseDao<TProduct> getBaseDao() {
        return productMapper;
    }

    @Override
    public PageInfo<TProduct> page(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TProduct> list=list();
        PageInfo<TProduct> pageInfo=new PageInfo<TProduct>(list,2);
        return pageInfo;
    }

    @Override
    @Transactional
    public Long save(TProductVo vo) {
        TProduct Product=vo.getProduct();
        Product.setFlag(true);
        int count=productMapper.insert(Product);

        String productDesc=vo.getProductDesc();
        TProductDesc tProductDesc=new TProductDesc();
        tProductDesc.setProductId(Product.getId());
        tProductDesc.setProductDesc(productDesc);
        tProductDescMapper.insert(tProductDesc);
        return Product.getId();
    }

    @Override
    public Long batchDelete(List<Long> ids) {
        return productMapper.batchUpdateFlag(ids);
    }

    //逻辑删除，flag=0
    @Override
    public int deleteByPrimaryKey(Long id) {
        TProduct product=new TProduct();
        product.setId(id);
        product.setFlag(false);
        return productMapper.updateByPrimaryKeySelective(product);
    }
}
