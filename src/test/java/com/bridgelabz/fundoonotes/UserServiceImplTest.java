package com.bridgelabz.fundoonotes;

import com.bridgelabz.fundoonotes.configuration.RabbitMQSender;
import com.bridgelabz.fundoonotes.implementation.ServiceImpl;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.response.MailObject;
import com.bridgelabz.fundoonotes.response.MailResponse;
import com.bridgelabz.fundoonotes.service.Services;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Environment;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
        @Mock
        private JwtGenerator generate;
        @Mock
        private BCryptPasswordEncoder encryption;
        @Mock
        private ModelMapper modelMapper;
        @Mock
        private MailResponse response;
        @Mock
        private MailObject mailObject;
        @Mock
        private UserRepository repository;
        @Mock
        private JavaMailSenderImpl mailSenderImplementation;
        @Mock
        private Environment environment;
        @Mock
        RabbitMQSender rabbitMQSender;
        Services userServiceImpl=new ServiceImpl();
        UserInformation user = new UserInformation();

        @Test
        private UserInformation createUserInformation() {
            user.setIsVerified(1);
            user.setUserId(123L);
            user.setEmail("abi@gmail.com");
            user.setName("abi");
            Mockito.when(repository.save(user)).thenReturn(user);
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
            user.setEmail("sandhya@gmail.com");
            user.setPassword("sandhya");
            Mockito.when(repository.findUserById(1)).thenReturn(user);
        }
        @Test
        public  void testLogin() {
            user.setUserId(1);
            user.setName("Sandhya");
            user.setEmail("sandhya@gmail.com");
            user.setName("sandhya");
            Mockito.when(repository.getUser("sandhya@gmail.com")).thenReturn(user);
        }
        @Test
        public void testUpdate(){
            user.setUserId(1);
            Mockito.when(repository.findUserById(1)).thenReturn(user);
            user.setPassword("samdy");
            Mockito.when(repository.update("sandy",1)).thenReturn(1);

        }
    }

