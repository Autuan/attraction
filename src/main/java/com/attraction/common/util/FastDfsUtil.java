package com.attraction.common.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDfsUtil {

    //fdfs_client 核心配置文件
    public String conf_filename = "E:/temp/fdfs_client.conf";
//    public String conf_filename = "src/main/resources/fdfs_client.conf";

    public boolean upload(String basePath , String newPath, String newName) {	//上传文件
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;

        try {
            ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            //要上传的文件路径
//            String local_filename = "/Users/shenwei/Desktop/1.png";
            String local_filename = basePath + newPath + "/" + newName;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//          String fileIds[] = storageClient.upload_file(local_filename, "png", nvp);
            String fileIds[] = storageClient.upload_file(local_filename, "png", null);

            if (fileIds.length > 1 ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally{
            try {
                if(null!=storageServer) storageServer.close();
                if(null!=trackerServer) trackerServer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void download() {	//下载文件
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;

        try {
            String groupName = "group1";
            String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] bytes = storageClient.download_file(groupName, filePath);

            String storePath = "/Users/shenwei/Desktop/download.png";
            OutputStream out = new FileOutputStream(storePath);
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(null!=storageServer) storageServer.close();
                if(null!=trackerServer) trackerServer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void getFileInfo(){ //获取文件信息
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;

        try {
            String groupName = "group1";
            String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            FileInfo file = storageClient.get_file_info(groupName, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(null!=storageServer) storageServer.close();
                if(null!=trackerServer) trackerServer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void getFileMate(){ //获取文件的原数据类型
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;

        try {
            String groupName = "group1";
            String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);

            //这个值是上传的时候指定的NameValuePair
            NameValuePair nvps [] = storageClient.get_metadata(groupName, filePath);
            if(null!=nvps && nvps.length>0){
                for(NameValuePair nvp : nvps){
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(null!=storageServer) storageServer.close();
                if(null!=trackerServer) trackerServer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void delete(){ //删除文件
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;

        try {
            String groupName = "group1";
            String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            trackerServer = tracker.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer,
                    storageServer);
            int i = storageClient.delete_file(groupName, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(null!=storageServer) storageServer.close();
                if(null!=trackerServer) trackerServer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}