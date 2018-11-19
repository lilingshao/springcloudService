package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.utils.SerializeUtil;

@RestController
@RequestMapping("demo")
public class ReportRestController {
	 @Resource
	 private UserService userService;
	
	/**
	 * @param response
	 */
	@RequestMapping(value="getTest",method = { RequestMethod.POST,RequestMethod.GET })
	public String getTest(HttpServletResponse response){
		return "index";
	}
	 @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
		 System.out.println("88888888888");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id", "1,100");
        List<User> list = this.userService.getUsers(params);
        String json = JSON.toJSONString(list);
        return json;
    }
	 
}
