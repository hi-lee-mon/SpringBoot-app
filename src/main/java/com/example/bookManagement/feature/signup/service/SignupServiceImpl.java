package com.example.bookManagement.feature.signup.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookManagement.entity.UserInfo;
import com.example.bookManagement.feature.signup.form.SignupForm;
import com.example.bookManagement.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;


/**
 * ユーザ登録画面 Service実装クラス
 *
 * @author shun
 *
 */
@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

  /**ユーザ情報テーブルDAO*/
  private final UserInfoRepository repository;
  /**Dozer Mapper*/
  private final Mapper dozerMapper;
  /**パスワードエンコーダー*/
  private final PasswordEncoder passwordEncoder;

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<UserInfo> registerUserInfo(SignupForm signupForm){
    // ユーザが既に登録済か確認
    Optional<UserInfo> foundUser = repository.findById(signupForm.getUserId());
    if(foundUser.isPresent()){
      // 登録済の場合は空を返す
      return Optional.empty();
    }
    // UserInfoインスタンスが持つフィールドにsignupFormのデータを流し込む。両方にないフィールドは無視される。
    UserInfo userInfo = dozerMapper.map(signupForm,UserInfo.class);
    String encodedPassword = passwordEncoder.encode(signupForm.getPassword());
    userInfo.setPassword(encodedPassword);
    userInfo.setUserId(signupForm.getUserId());
    return Optional.of(repository.save(userInfo));
  }
}
