package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CloudController {
	@Autowired
	UserService userService;
	// PathVariable
	@RequestMapping("/user/{id}")
	public Bean getUserInfo(@PathVariable("id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Orange");
		bean.setName("lili");
		bean.setId(id);
		return bean;
	}
	// Path
	@RequestMapping(value="/userList",method = { RequestMethod.POST,RequestMethod.GET })
	public Bean getUserList(@RequestParam(required = true, value = "id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Banana");
		bean.setName("Mr Wang");
		bean.setId(id);
		return bean;
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getUser",method = { RequestMethod.POST,RequestMethod.GET })
	public List<User> getUser(@RequestParam(required = true, value = "id") String id) {
		Map<String,Object> params = new HashMap<>();
		params.put("id",id);
		return userService.getUsers(params);
	}
	/**
	 * https://blog.csdn.net/peterwanghao/article/details/79722247
	 * @return
	 */
	@GetMapping("/helloworld")
    public String HelloWorld() {
        return "Hello World!";
    }
}
