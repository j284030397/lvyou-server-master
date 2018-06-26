package com.dev.base.cache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenProcessor
{
  private long privious;
  private static TokenProcessor instance = new TokenProcessor();
  public static String FORM_TOKEN_KEY = "FORM_TOKEN_KEY";

  public static TokenProcessor getInstance()
  {
    return instance;
  }

  public synchronized boolean isTokenValid(HttpServletRequest request)
  {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return false;
    }
    String saved = (String)session.getAttribute(FORM_TOKEN_KEY);
    if (saved == null) {
      return false;
    }
    String token = request.getParameter(FORM_TOKEN_KEY);
    if (token == null) {
      return false;
    }
    return saved.equals(token);
  }

  public synchronized boolean isTokenValid(HttpServletRequest request, String token)
  {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return false;
    }
    String saved = (String)session.getAttribute(FORM_TOKEN_KEY);
    if (saved == null) {
      return false;
    }
    if (token == null) {
      return false;
    }
    return saved.equals(token);
  }

  public synchronized void reset(HttpServletRequest request)
  {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }
    session.removeAttribute(FORM_TOKEN_KEY);
  }

  public synchronized void saveToken(HttpServletRequest request)
  {
    HttpSession session = request.getSession();
    try {
      byte[] id = session.getId().getBytes();
      long current = System.currentTimeMillis();
      if (current == this.privious) {
        current += 1L;
      }
      this.privious = current;
      byte[] now = String.valueOf(current).getBytes();
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(id);
      md.update(now);
      String token = toHex(md.digest());
      session.setAttribute(FORM_TOKEN_KEY, token);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
  }

  public String generateToken(String seek, boolean flag) {
    try {
      byte[] id = seek.getBytes();
      byte[] now = new Long(System.currentTimeMillis()).toString().getBytes();
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(id);
      md.update(now);
      return toHex(md.digest());
    }
    catch (IllegalStateException e) {
      return null; } catch (NoSuchAlgorithmException e) {
    }
    return null;
  }

  public String toHex(byte[] buffer)
  {
    StringBuffer sb = new StringBuffer(buffer.length * 2);
    for (int i = 0; i < buffer.length; i++) {
      sb.append(Character.forDigit((buffer[i] & 0x60) >> 4, 16));
      sb.append(Character.forDigit(buffer[i] & 0xF, 16));
    }
    return sb.toString();
  }
}