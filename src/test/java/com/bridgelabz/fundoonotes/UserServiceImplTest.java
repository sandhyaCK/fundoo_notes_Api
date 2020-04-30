package com.bridgelabz.fundoonotes;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.implementation.ServiceImpl;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;


import com.bridgelabz.fundoonotes.service.Services;
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

import javax.xml.ws.soap.Addressing;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class UserServiceImplTest {

    @MockBean
    private UserRepository repository;
    @Mock
    ModelMapper modelMapper;
    @Mock
    private BCryptPasswordEncoder encryption;
@MockBean
        DtoData user1;
    Services userServiceImpl = new ServiceImpl();
    UserInformation user = new UserInformation();

    @Test
    public void createUserInformation() throws Exception {
        user1.setEmail("csandhyait@gmail.com");
        user1.setName("sandy");
        String epassword=encryption.encode("sandy");
        user1.setPassword(epassword);
        user1.setMobileNumber("8087968379");
        user = modelMapper.map(user1, UserInformation.class);
        user.setIsVerified(0);

        user.setDateTime(LocalDateTime.of(2020, Month.APRIL, 30, 14, 44, 9));
        user.setPassword(epassword);
        user.setUserId(3L);
        Mockito.when(repository.save(user)).thenReturn(user);
        assertThat(userServiceImpl.getSingleUser("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA")).isEqualTo(user);
    }

    @Test
    public void testGetUsers() throws Exception {
        List<UserInformation> users=new ArrayList<>();
        users.add(createUserInformation());
        Mockito.when(repository.getUsers()).thenReturn(users);
        List<UserInformation> response= userServiceImpl.getUsers();
        response.forEach(System.out::println);
    }
    @Test
    public  void testGetUserById() {

        user.setUserId(1);
        user.setName("Sandhya");
        user.setEmail("csandhyait@gmail.com");
        user.setPassword("sandhya");
        Mockito.when(repository.findUserById(1)).thenReturn(user);
    }
   // @Test
    public  void testLogin() {
        LoginInfo login=new LoginInfo();
        login.setEmail("csandhyait@gmail.com");
        String epassword=encryption.encode("sandy");
        login.setPassword(epassword);
        user = modelMapper.map(user1, UserInformation.class);
        user.setIsVerified(1);
        user.setUserId(3L);
        user.setName("sandy");
        user.setDateTime(LocalDateTime.of(2020, Month.APRIL, 30, 14, 44, 9));
       user.setMobileNumber("8087968379");
        Mockito.when(repository.save(user)).thenReturn(user);
        assertThat(userServiceImpl.getSingleUser("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6M30.J7bbcxYxFXsWCWRY3DMIuSAFZ_PwgmvlOShtZh5ew2UEOFwiSnfIyon0sUYuZx5RO1VVwHvFFOhEfl5a-daIOA")).isEqualTo(user);
    }    }
    @Test
    public void testUpdate(){
        user.setUserId(1);
        Mockito.when(repository.findUserById(1)).thenReturn(user);
        user.setPassword("samdy");
        Mockito.when(repository.update("sandy",1)).thenReturn(1);

    }
    @Test
    public void testVerify(){
        user.setUserId(2);
        Mockito.when(repository.verify(1)).thenReturn(true);
    }

}

}



