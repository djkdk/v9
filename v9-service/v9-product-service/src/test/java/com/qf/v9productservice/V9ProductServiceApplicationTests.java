package com.qf.v9productservice;

import com.github.pagehelper.PageInfo;
import com.qianfeng.v9.api.IProductService;
import com.qianfeng.v9.api.IProductTypeService;
import com.qianfeng.v9.entity.TProduct;
import com.qianfeng.v9.entity.TProductType;
import com.qianfeng.v9.pojo.TProductVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V9ProductServiceApplicationTests {
	@Autowired
	private IProductService productService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private IProductTypeService productTypeService;

	@Test
	public void contextLoads() throws SQLException {
//		List<TProduct> list=productService.list();
//		Assert.assertEquals(list.size(),3);
//		PageInfo<TProduct> page=productService.page(1,1);
//		System.out.println(page.getList().size());
//		TProduct product=new TProduct();
//		product.setName("huashuo");
//		product.setPrice(9999L);
//		product.setSalePrice(8888L);
//		product.setSalePoint("haokan");
//		product.setTypeName("bijben");
//		product.setImages("aa");
//		product.setTypeId(1L);
//		product.setFlag(true);
//
//		TProductVo tProductVo=new TProductVo();
//		tProductVo.setProductDesc("kskskskskksks");
//		tProductVo.setProduct(product);
//
//		Long id=productService.save(tProductVo);
//		System.out.println(id);
//		int i=productService.deleteByPrimaryKey(1L);
//		System.out.println(i);
//		System.out.println(dataSource.getConnection());
		List<TProductType> list=productTypeService.list();
		System.out.println(list.size());
	}

}
