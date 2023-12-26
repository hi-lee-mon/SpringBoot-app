package com.example.bookManagement.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.bookManagement.entity.UserInfo;
import com.example.bookManagement.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 認証処理
 *
 * @author shun
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  /**ユーザ情報テーブルrepository*/
  private final UserInfoRepository repository;

  /**
   * ログインIDからユーザ情報を取得する
   * @param userId ログインID
   * @return ユーザ情報
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Optional<UserInfo> userInfoOpt = repository.findById(userId);
    UserInfo userInfo = userInfoOpt.orElseThrow(()->
        new UsernameNotFoundException(userId));

    // Userクラスを作成する。作成したUserクラスは後続の処理でフィールドをチェックされる。チェック結果OKの場合はBeanをまるごとセッションとして保管される。     
    return User.withUsername(userInfo.getUserId())
        .password(userInfo.getPassword())
        .build();
  }
}
