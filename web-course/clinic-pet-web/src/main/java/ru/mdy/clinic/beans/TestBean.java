package ru.mdy.clinic.beans;/**
 * TODO: comments
 */

/**
 * TODO: comments
 * @author admin
 *
 * @since 21 апр. 2016 г.
 */
public class TestBean {
 private static int requestCount = 0;
 public int getCurrentCount(){
  return requestCount++;
 }
}