package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class TestVideoDownload
{
  public static void main(String[] args)
    throws Exception
  {
    URL url = new URL("http://v.youku.com/v_show/id_XODE5NDQ2ODQ=.html");
    URLConnection uc = url.openConnection();
    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
    String str = null;
    String xz = "";
    while ((str = br.readLine()) != null) {
      System.out.println(str);
    }

    System.out.println("下载地址为：" + xz);
  }

  private static void getDondow(String url, String pathName) throws Exception
  {
    URL ul = new URL(url);
    HttpURLConnection conn = (HttpURLConnection)ul.openConnection();
    BufferedInputStream bi = new BufferedInputStream(conn.getInputStream());
    FileOutputStream bs = new FileOutputStream(pathName);
    System.out.println("文件大约：" + conn.getContentLength() / 1024 + "K");
    byte[] by = new byte[1024];
    int len = 0;
    while ((len = bi.read(by)) != -1) {
      bs.write(by, 0, len);
    }
    bs.close();
    bi.close();
  }
}