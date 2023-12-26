package com.example.bookManagement.feature.login.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import lombok.Data;

/**
 * ログインフォーム
 * @author hi-lee-mon
 */
@Data
public class LoginForm {
  @Nullable
  @Length(min = 8, max = 20)
  private String userId;
  @Nullable
  @Length(min = 8, max = 20)
  private String password;
}
