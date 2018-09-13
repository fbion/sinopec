package com.sensenets.sinopec.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
  * @ClassName: HttpDownloadImageHelper
  * @Description: HTTP下载图片
  * @author wangkang
  * @date 2017年2月14日 下午2:44:04
  *
 */
public class HttpDownloadImageHelper {
    
    /**
     * 连接超时时间
     */
    private static final int TIME_OUT = 30000;
    
    /**
     * @Title: sendGetRequestWithStream
     * @Description: get方法获取文件流字节数组数据
     * @param url
     *            文件请求url
     * @return byte[] 文件字节数组
     * @throws Exception
     *             异常
     */
    public static byte[] sendGetRequestWithStream(String url) throws Exception {
        String result = null;
        CloseableHttpClient client = null;
        ByteArrayOutputStream os = null;
        byte[] data = null;
        try {
            client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).build();// 设置请求和传输超时时间
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (response.getEntity() != null) {
                InputStream instream = entity.getContent();
                os = new ByteArrayOutputStream();
                int temp = 0;
                while ((temp = instream.read()) != -1) {
                    os.write(temp);
                }
                os.flush();
                os.close();
                data = os.toByteArray();
            } else {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new Exception(result);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
 
}
