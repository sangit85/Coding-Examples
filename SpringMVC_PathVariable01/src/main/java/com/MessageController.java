package com;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MessageController {
 @RequestMapping(value = "/", method = RequestMethod.GET)
 public String showHome(Model model) {
  //model.addAttribute(new User());
  model.addAttribute("message", "MVC Example with dynamic URL");
  return "home";
 }
 
 @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
 public String getUser(@PathVariable("userId") String userId, Model model) {
  // adding the user object to model
  // ideally get it from DB
  model.addAttribute("USER", findUserById(userId));
  return "user";
 }
 
 // Dummy Method-- Creating user object
 private User findUserById(String userId) {
  System.out.println("User ID " + userId);
  User user = new User();
  user.setUserId(userId);
  user.setFirstName("Leonard");
  user.setLastName("Nimoy");
  return user;
 }
}