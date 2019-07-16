package org.wq.demo.springclouddemo.http_test;

import com.google.gson.Gson;
import spring.demo.demo.feign.FeignClientUtils;
import spring.demo.demo.feign.OssClient;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:19 2018/12/17
 */
public class HttpTest {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        File fileDir = new File("C:\\Users\\wangqiang26\\Desktop\\0321");
        if(fileDir.isDirectory()){
            File[] files = fileDir.listFiles();
            for(int i = 0; i< files.length ; i++){
                File file = files[i];
                try{
//                    FileInputStream fin = new FileInputStream(new File("C:\\Users\\wangqiang26\\Desktop\\fensi.png"));
                    FileInputStream fin =  new FileInputStream(file);
                    FileChannel channel = fin.getChannel();
                    int size = (int)channel.size();
                    MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);
                    byte[] bytes = new byte[size];
                    buf.get(bytes);
                    String gw = "http://gw.b2b-v2gray.jcloudec.com/oss";
                    Map<String, String> res = FeignClientUtils.getDefaultClient(OssClient.class, gw).uploadImage(20L, bytes);
                    hashMap.put(file.getName(), res.toString());
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println(e);
                }
            }
            String s = new Gson().toJson(hashMap);
            System.out.println(s);
        }
        System.out.println();
    }


    public static void postHttp(){

    }


    public static void main1(String[] args) {
        String substring = "abcdefg".substring(0, 2);
        System.out.println(new BigDecimal("0.016").setScale(2, RoundingMode.DOWN));
        System.out.println(new BigDecimal("0.016").setScale(2, RoundingMode.UP));
        System.out.println(new BigDecimal("0.016").setScale(2, RoundingMode.HALF_UP));
        System.out.println(new BigDecimal("0.016").setScale(2, RoundingMode.HALF_DOWN));

        System.out.println(substring);
    }








}
