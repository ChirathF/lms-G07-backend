package com.mit.lms.response;

import com.mit.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class UserCreatesResponse {
   private  User user;

   public  UserCreatesResponse(User user){
       this.user = user;
   }
}
