package com.qianfeng.v9centerweb.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qianfeng.v9.common.pojo.ResultBean;
import com.qianfeng.v9centerweb.pojo.MultiUploadResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author
 * @Date ${Date}
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private FastFileStorageClient client;

    @Value("${image.server}")
    private String imageserver;

    @RequestMapping("upload")
    @ResponseBody
    public ResultBean upload(MultipartFile file){
        String filename=file.getOriginalFilename();
        String lasname=filename.substring(filename.lastIndexOf(".")+1);
        try {
            StorePath storePath=client.uploadFile(file.getInputStream(),file.getSize(),lasname,null);
            String path=new StringBuilder(imageserver).append(storePath.getFullPath()).toString();
            return new ResultBean("200",path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultBean("400","由于网络原因上传失败，请稍后再试");
    }

    @PostMapping("multiupload")
    @ResponseBody
    public MultiUploadResultBean multiupload(MultipartFile[] files){
        String[] data=new String[files.length];
        for (int i = 0; i < files.length; i++) {
            String filename=files[i].getOriginalFilename();
            String lasname=filename.substring(filename.lastIndexOf(".")+1);
            try {
                StorePath storePath=client.uploadFile(files[i].getInputStream(),files[i].getSize(),lasname,null);
                String path=new StringBuilder(imageserver).append(storePath.getFullPath()).toString();
                data[i]=path;
            } catch (IOException e) {
                e.printStackTrace();
                return new MultiUploadResultBean("1",null);
            }
        }
        return new MultiUploadResultBean("0",data);
    }
}
