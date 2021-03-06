package com.attraction.modular.base.controller;

import cn.hutool.http.HttpRequest;
import com.attraction.common.util.FtpUtil;
import com.attraction.common.util.IDUtils;
import com.attraction.common.util.fastDfs.*;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 文件上传 控制层
 */
@Controller
@RequestMapping("/file")
public class UploadController {
    // ---------------------- 常量 ----------------------

    private String FTP_ADDRESS = "127.0.0.1";

    private String FTP_PORT = "21";

    private String FTP_USERNAME = "root";

    private String FTP_PASSWORD = "root";

    private String FTP_BASE_PATH = "";

    private String IMAGE_BASE_URL = "http://localhost:8099";

    /**
     * FastDFS秘钥
     */
//    private String fastDFSHttpSecretKey = "HandFastDFSToken";


    // ---------------------- 自动注入 && 变量----------------------

    private FastDFSClient fastDFSClient = new FastDFSClient();
    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageClient storageClient = null;
    private StorageServer storageServer = null;
    private StorageClient1 storageClient1 = null;
    private Properties properties = null;
    private InputStream imgServerConf = null;
    // ----------------------

    /**
     * fastFDS 上传图片
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/uploadFiles"})
    @ResponseBody
    public Map uploadFileFastDFS(MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap = new HashMap<>(16);
        List<String> data = new ArrayList<String>(4);
        for (int i = 0; i < file.length; i++) {
            MultipartFile item = file[i];

            String ext_Name = item.getOriginalFilename().split("\\.")[1];
            String imgName = item.getOriginalFilename().split("\\.")[0];

            byte[] bytes = null;
            try {
                bytes = item.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String imgPath = uploadFileFastDFSAction(bytes, ext_Name);
            if (null == imgPath || imgPath.equals("") || imgPath.length() < 6) {
                resultMap.put("errno", 1);
                resultMap.put("message", "File Upload Fail");
                return resultMap;
            } else {
                resultMap.put("errno", 0);
                data.add(imgPath);
            }
        }
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * FastDFS 文件上传
     *
     * @param byteFile
     * @param ext_file
     * @return
     */
    public String uploadFileFastDFSAction(byte[] byteFile, String ext_file) {
        // 拼接服务区的文件路径
        StringBuffer sbPath = new StringBuffer();
        try {
            // 初始化文件资源
            ClientGlobal.init("/usr/local/fdfs_client.conf");

            // 链接FastDFS服务器，创建tracker和Stroage
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            //利用字节流上传文件
            String[] strings = storageClient.upload_file(byteFile, ext_file, null);
            for (String string : strings) {
                sbPath.append("/" + string);
            }
            // 全路径
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return sbPath.toString();
    }

    /**
     * wangeditor FTP 方式 图片上传
     *
     * @param uploadFile
     * @return
     */
    @RequestMapping("/uploadFTP")
    @ResponseBody
    public Map uploadFileFTP(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>(16);
        try {
            List<String> data = new LinkedList<>();
                // 生成一个新的文件名
                // 取原始文件名
                String oldName = uploadFile.getOriginalFilename();
                // 生成新文件名
                // UUID.randomUUID()
                String newName = IDUtils.genImageName();
                newName = newName + oldName.substring(oldName.lastIndexOf("."));
                // 图片上传
                String imagePath = new DateTime().toString("/yyyy/MM/dd");
                boolean result = FtpUtil.uploadFile(FTP_ADDRESS, Integer.valueOf(FTP_PORT), FTP_USERNAME,
                        FTP_PASSWORD, FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
                // 返回结果
                if (!result) {
                    resultMap.put("errno", 1);
                    resultMap.put("message", "File Upload Fail");
                } else {
                    resultMap.put("errno", 0);
                    data.add(IMAGE_BASE_URL + imagePath + "/" + newName);
                }
                resultMap.put("data", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //为了保证功能的兼容性，需要把Result转换成json格式的字符串。
        return resultMap;
    }
}