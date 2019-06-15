package com.qianfeng.v9searchservice;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V9SearchServiceApplicationTests {
	@Autowired
	private SolrClient solrClient;

	@Test
	public void addTest() throws IOException, SolrServerException {
		SolrInputDocument document=new SolrInputDocument();
		document.setField("id",2);
		document.setField("product_name","华为旗舰");
		document.setField("product_price",9999);
		document.setField("product_images","123");
		document.setField("product_sale_point","全球限量100台");
		solrClient.add(document);
		solrClient.commit();
		System.out.println("保存成功");
	}

	@Test
	public void queryTest() throws IOException, SolrServerException {
		SolrQuery condition=new SolrQuery();
		condition.setQuery("product_name:华为旗舰大龙虾");

		QueryResponse response=solrClient.query(condition);

		SolrDocumentList solrDocuments=response.getResults();
		for (SolrDocument solrDocument : solrDocuments) {
			System.out.println("id:"+solrDocument.get("id")+",name:"+solrDocument.get("product_name"));
		}
	}

	@Test
	public void contextLoads() {
	}

}
