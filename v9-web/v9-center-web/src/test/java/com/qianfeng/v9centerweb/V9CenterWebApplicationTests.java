package com.qianfeng.v9centerweb;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V9CenterWebApplicationTests {

	@Autowired
	private FastFileStorageClient client;

	@Test
	public void contextLoads() throws FileNotFoundException {
//		File file=new File("D:\\IDEAprojects\\v9\\v9-web\\v9-center-web\\hello.html");
//		FileInputStream inputStream=new FileInputStream(file);
//		StorePath storePath= client.uploadFile(inputStream,file.length(),"html",null);
//		System.out.println(storePath);
//		System.out.println(storePath.getFullPath());
//		System.out.println(storePath.getGroup());
//		System.out.println(storePath.getPath());

		File file=new File("D:\\IDEAprojects\\v9\\v9-web\\v9-center-web\\img-1.jpg");
		FileInputStream inputStream=new FileInputStream(file);
		StorePath storePath= client.uploadImageAndCrtThumbImage(inputStream,file.length(),"jpg",null);
		System.out.println(storePath);
		System.out.println(storePath.getFullPath());
		System.out.println(storePath.getGroup());
		System.out.println(storePath.getPath());

	}
	@Test
	public void delete(){
		client.deleteFile("group1/M00/00/00/wKj0gV0DbpeASL0cAACIgjiTqBk104_100x100.jpg");
		System.out.println("ok");
	}

}
