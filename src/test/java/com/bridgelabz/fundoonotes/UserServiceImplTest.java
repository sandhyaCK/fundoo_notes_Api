package com.bridgelabz.fundoonotes;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.implementation.ServiceImpl;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;


import com.bridgelabz.fundoonotes.service.Services;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.ws.soap.Addressing;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    DtoData user1;
    @Mock
    Services userServiceImpl;
    UserInformation user = new UserInformation();
    @Mock
    JwtGenerator generator;
    String token=null;
    @Test
    public void createUserInformation() throws Exception {
        user1.setEmail("csandhyait@gmail.com");
        user1.setName("sandy");
        user1.setPassword("sandy");
        user1.setMobileNumber("8087968379");
        Mockito.when(userServiceImpl.register(user1)).thenReturn(true);
        assertThat(user);
    }
    @Test
    public  void testLogin() throws Exception {
        LoginInfo login=new LoginInfo();
        login.setEmail("csandhyait@gmail.com");
        login.setPassword("sandy");
        System.out.println("#####");
        Mockito.when(userServiceImpl.isUserExist("csandhyait@gmail.com")).thenReturn(true);
        System.out.println("#####");
        assertThat(user).isNotNull();
    }
    @Test
    public void testGetUsers() throws Exception {
        List<UserInformation> users=new ArrayList<>();
        Mockito.when( userServiceImpl.getUsers()).thenReturn(users);
        List<UserInformation> response= userServiceImpl.getUsers();
       assertThat(users).isNotNull();
    }

    @Test
    public  void testGetUserById() throws Exception {
        user.setUserId(3L);
        Mockito.when(generator.jwtToken(3L)).thenReturn(token);
        Mockito.when(userServiceImpl.getSingleUser(token)).thenReturn(user);
        assertThat(user).isNotNull();
    }


    @Test
    public void testVerify(){
        user.setUserId(3L);
        Mockito.when(generator.jwtToken(3L)).thenReturn(token);
        Mockito.when(userServiceImpl.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA")).thenReturn(true);
  assertThat(token).isNotNull();
    }

}

//   @Test
//    public void testUpdate(){
//        user.setUserId(1);
//        Mockito.when(repository.findUserById(1)).thenReturn(user);
//      user.setPassword("samdy");
//        Mockito.when(repository.update("sandy",1)).thenReturn(1);
//
//   }







