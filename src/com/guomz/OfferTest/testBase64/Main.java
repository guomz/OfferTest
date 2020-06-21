package com.guomz.OfferTest.testBase64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {

        try {
//            URL url = new URL("http://alipay.dl.django.t.taobao.com/rest/1.0/image?fileIds=9qLThfVHSF60TJqBKkllFgAAACMAAQED&zoom=original");
//            URLConnection connection = url.openConnection();
//            InputStream is = connection.getInputStream();
//            byte[] arr = new byte[1024 * 1024];
//            is.read(arr);
//            is.close();
//            BASE64Encoder encoder = new BASE64Encoder();
//            String imgStr = encoder.encode(arr);
            String imgStr = encodeImgageToBase64("http://alipay.dl.django.t.taobao.com/rest/1.0/image?fileIds=9qLThfVHSF60TJqBKkllFgAAACMAAQED&zoom=original");
            System.out.println(imgStr);
            OutputStream os = new FileOutputStream("d:/test.jpg");
            os.write(new BASE64Decoder().decodeBuffer(imgStr));
            os.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String encodeImgageToBase64(String remark) {

        ByteArrayOutputStream outputStream = null;

        try {

            URL url = new URL(remark);

            BufferedImage bufferedImage = ImageIO.read(url);

            outputStream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage,"jpg",outputStream);

        } catch (IOException e) {



            return remark;

        }

        BASE64Encoder encoder = new BASE64Encoder();

        String s= encoder.encode(outputStream.toByteArray());

//s = s.replaceAll("\\r\\n","");

//return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串

        return s;

    }
}
