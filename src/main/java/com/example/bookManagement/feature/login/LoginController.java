package com.example.bookManagement.feature.login;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookManagement.constant.UrlConst;
import com.example.bookManagement.constant.ViewNameConst;
import com.example.bookManagement.feature.login.form.LoginForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
  /**セッション情報*/
  private final HttpSession session;

  /**ログイン処理はSpringSecurityに任せるため、ここではログイン画面の表示のみを行う。 */

  /**
   * ログイン画面表示
   * @param modelAndView
   * @return ログイン画面
   */
  @GetMapping(UrlConst.LOGIN)
  public ModelAndView view(ModelAndView modelAndView) { 
    // 空のフォームを作成
    modelAndView.addObject("loginForm", new LoginForm());
    // 遷移先の指定
    modelAndView.setViewName(ViewNameConst.LOGIN);
    return modelAndView;
  }

  /**
   * ログインエラー画面表示
   *
   * @param modelAndView
   * @return
   */
  @GetMapping(value=UrlConst.LOGIN,params="error")
  public ModelAndView loginError(ModelAndView modelAndView){
    var errorInfo = (Exception)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    modelAndView.addObject("errorMsg",errorInfo.getMessage());
    // 空のフォームを作成
    modelAndView.addObject("loginForm", new LoginForm());
    // 遷移先の指定
    modelAndView.setViewName(ViewNameConst.LOGIN);
    return modelAndView;
  }
}
