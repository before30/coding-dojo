package cc.before30.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: before30 
 * Date: 2016. 12. 23.
 * Time: 오후 12:19
 */

@RestController
public class Hello2 {

	@RequestMapping("/hello2")
	public String hello2() {
		return "world2";
	}
}
