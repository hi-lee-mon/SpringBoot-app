package com.example.bookManagement.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class MessageUtil {

  /**
   * 日本語メッセージ取得処理
   *
   * @param messageSource メッセージソース
   * @param key メッセージ キー
   * @param params 置換文字列
   * @return メッセージ
   */
  public static String getMessage(MessageSource messageSource, String key, Object...params){
    return messageSource.getMessage(key,params, Locale.JAPAN);
  }

  /**
   * 汎用メッセージ取得処理
   * @param messageSource メッセージソース
   * @param key メッセージ キー
   * @param locale 言語種別
   * @param params 置換文字列
   * @return メッセージ
   */
  public static String getMessage(MessageSource messageSource, String key,Locale locale, Object...params){
    return messageSource.getMessage(key,params, locale);
  }
}
