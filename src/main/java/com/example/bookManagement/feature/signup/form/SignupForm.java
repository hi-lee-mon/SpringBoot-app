package com.example.bookManagement.feature.signup.form;


import org.hibernate.validator.constraints.Length;

import com.example.bookManagement.constant.ValidationMessageConst;

import lombok.Data;

/**
 * ユーザ登録画面 Form
 *
 * @author shun
 *
 */
@Data
public class SignupForm {

  /**ログインID*/
  @Length(min=4,max=20,message = ValidationMessageConst.USER_ID_OVER)
  private String userId;

  /**パスワード*/
  @Length(min=4,max=20)
  private String password;
}
