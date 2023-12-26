package com.example.bookManagement.feature.signup;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookManagement.constant.UrlConst;
import com.example.bookManagement.constant.ViewNameConst;
import com.example.bookManagement.constant.message.ErrorMessageConst;
import com.example.bookManagement.constant.message.MessageConst;
import com.example.bookManagement.entity.UserInfo;
import com.example.bookManagement.feature.signup.form.SignupForm;
import com.example.bookManagement.feature.signup.service.SignupService;
import com.example.bookManagement.util.MessageUtil;

import lombok.RequiredArgsConstructor;

/**
 * ユーザ登録画面 Controller
 *
 * @author shun
 *
 */
@Controller
@RequiredArgsConstructor
public class SignupController {
  /**ログインService*/
  private final SignupService signupService;

  /**メッセージソース*/
  private final MessageSource messageSource;

  /**
   * 初期表示
   *
   * @param modelAndView モデル
   * @return 表示画面
   */
  @GetMapping(UrlConst.SIGNUP)
  public ModelAndView view(ModelAndView modelAndView){
    // 空のフォームを作成
    modelAndView.addObject("signupForm", new SignupForm());
    // 遷移先の指定
    modelAndView.setViewName(ViewNameConst.SIGNUP);
    return modelAndView;
  }

  /**
   * ユーザ登録処理
   *
   * @param modelAndView モデル
   * @param signupForm 入力情報
   * @param bindingResult バリデーション結果
   * @return 表示画面
   */
  @PostMapping(UrlConst.SIGNUP)
  public ModelAndView signup(
      ModelAndView modelAndView,
      @Validated SignupForm signupForm,
      BindingResult bindingResult
  ){
    if(bindingResult.hasErrors()){
      // バリデーションエラー処理
      modelAndView.setViewName(ViewNameConst.SIGNUP);
      return modelAndView;
    }

    // ユーザ作成
    Optional<UserInfo> userInfoOpt = signupService.registerUserInfo(signupForm);
    if(userInfoOpt.isEmpty()){
      // ユーザが既に存在していた場合
      modelAndView.addObject("message",MessageUtil.getMessage(messageSource,ErrorMessageConst.SIGNUP_EXISTS_LOGIN_ID));
      modelAndView.addObject("isError",true);
    } else {
      // ユーザの有無によってメッセージEnumを取得
      modelAndView.addObject("message", MessageUtil.getMessage(messageSource,MessageConst.SIGNUP_RESIST_SUCCEED));
      modelAndView.addObject("isError",false);
    }
    modelAndView.setViewName(ViewNameConst.SIGNUP);
    return modelAndView;
  }
}
