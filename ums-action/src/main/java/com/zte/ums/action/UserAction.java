package com.zte.ums.action;

import com.zte.ums.entity.vo.UserVO;
import com.zte.ums.service.UserService;
import com.zte.ums.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:hellboy
 * Date:2018-10-29 15:36
 * Description:<描述>
 */
@WebServlet("/regist")
public class UserAction extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserVO userVO = new UserVO();
        //支持中文
        req.setCharacterEncoding("utf-8");

        //从表单中获取值，存入vo
        userVO.setUsername(req.getParameter("username"));
        userVO.setPassword(req.getParameter("password"));
        userVO.setAge(Integer.parseInt(req.getParameter("age")));
        try {
            userService.regist(userVO);
            //返回成功页面
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } catch (Exception e) {
            //返回失败页面
            e.printStackTrace();
            req.getRequestDispatcher("fail.jsp").forward(req,resp);

        }
    }
}
