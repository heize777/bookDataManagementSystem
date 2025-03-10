package com.example.interceptor;

import com.example.controller.Code;
import com.example.controller.Result;
import com.example.utils.ProjectUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("token");
        // 设置响应头编码格式
        response.setContentType("application/json;charset=UTF-8");

        // 对象转json
        ObjectMapper objectMapper = new ObjectMapper();

        // 长度校验
        if (ProjectUtil.hasLength(jwt)) {
            Result error = new Result(Code.BUSINESS_LOGIN_ERR, null, "token令牌不能为空");
            String notLogin = objectMapper.writeValueAsString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 解析jwt
        try {
            Claims claims = ProjectUtil.parseJwt(jwt);
            request.setAttribute("username", claims.get("username"));
        } catch (Exception e) {
            Result error = new Result(Code.BUSINESS_LOGIN_ERR, null, "token令牌不存在或已失效");
            String notLogin = objectMapper.writeValueAsString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
