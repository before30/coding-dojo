package cc.before30.controller

import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
  * User: before30 
  * Date: 2016. 12. 23.
  * Time: 오후 12:15
  */
@RestController
class Hello {
  @RequestMapping(Array("/hello")) def hello = "world"
}
