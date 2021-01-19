package tech.bison.arbeitsbuch.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( //
    path = "${spring.data.rest.base-path}/hello-world", //
    produces = MediaType.TEXT_PLAIN_VALUE, //
    consumes = MediaType.TEXT_PLAIN_VALUE //
)
public class HelloWorldController {

  @GetMapping
  public @ResponseBody String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/other")
  public @ResponseBody String otherHelloWorld() {
    return "Other Hello World";
  }

  @PostMapping
  public @ResponseBody String helloWorld(@RequestBody String body) {
    return body;
  }

}
