package com.dev.system.tool;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import javax.imageio.ImageIO;

public class ImgCompress
{
  private Image img;
  private int width;
  private int height;
  private File destFile;

  public static void main(String[] args)
    throws Exception
  {
    System.out.println("开始：" + new Date().toLocaleString());
    ImgCompress imgCom = new ImgCompress("e:\\temp\\02.png");
    imgCom.resizeFix(700, 800);
    System.out.println("结束：" + new Date().toLocaleString());
  }

  public ImgCompress(String fileName)
    throws IOException
  {
    File file = new File(fileName);
    this.img = ImageIO.read(file);
    this.width = this.img.getWidth(null);
    this.height = this.img.getHeight(null);
  }

  public ImgCompress(InputStream inputStream, File destFile01)
    throws IOException
  {
    this.img = ImageIO.read(inputStream);
    this.width = this.img.getWidth(null);
    this.height = this.img.getHeight(null);
    this.destFile = destFile01;
  }

  public void resizeFix(int w, int h)
    throws IOException
  {
    if (this.width / this.height > w / h)
      resizeByWidth(w);
    else
      resizeByHeight(h);
  }

  public void resizeByWidth(int w)
    throws IOException
  {
    int h = this.height * w / this.width;
    if (this.width < w)
      resize(this.width, this.height);
    else
      resize(w, h);
  }

  public void resizeByHeight(int h)
    throws IOException
  {
    int w = this.width * h / this.height;
    if (this.height < h)
      resize(this.width, this.height);
    else
      resize(w, h);
  }

  public void resize(int w, int h)
    throws IOException
  {
    BufferedImage image = new BufferedImage(w, h, 1);
    image.getGraphics().drawImage(this.img, 0, 0, w, h, null);
    FileOutputStream out = new FileOutputStream(this.destFile);

    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
    encoder.encode(image);
    out.close();
  }

  public void resizeByWidth(int w, File destFile)
    throws IOException
  {
    int h = this.height * w / this.width;
    resize(w, h, destFile);
  }

  public void resizeByHeight(int h, File destFile)
    throws IOException
  {
    int w = this.width * h / this.height;
    resize(w, h, destFile);
  }

  public void resize(int w, int h, File destFile)
    throws IOException
  {
    BufferedImage image = new BufferedImage(w, h, 1);
    image.getGraphics().drawImage(this.img, 0, 0, w, h, null);
    FileOutputStream out = new FileOutputStream(destFile);

    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
    encoder.encode(image);
    out.close();
  }
}