package com.example.bookManagement.feature.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookManagement.constant.UrlConst;
import com.example.bookManagement.constant.ViewNameConst;

/**
 * ホーム画面 Controller
 *
 * @author shun
 *
 */
@Controller
public class HomeController {

  /**
   * 初期表示
   * @param modelAndView モデル
   * @return 表示画面
   */
  @GetMapping(UrlConst.HOME)
  public ModelAndView view(ModelAndView modelAndView){
    // 遷移先の指定
    modelAndView.setViewName(ViewNameConst.HOME);
    modelAndView.addObject("isAuthenticated", true);
    return modelAndView;
  }

}
