package com.bridgelabz.fundoonotes;

import com.bridgelabz.fundoonotes.model.LabelData;
import com.bridgelabz.fundoonotes.repository.LabelRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bridgelabz.fundoonotes.implementation.NoteServiceImplementation;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LabelServiceTest {
    @Mock
    private NoteRepository noteRepo;
    @Mock
    private UserRepository repo;
    @Mock
    private LabelRepository labelRepo;
    UserInformation user = new UserInformation();
    LabelData label = new LabelData();
    @Test
    public void createLabelTest() {
        label.setUserId(1);
        label.setName("demo");
        label.setLabelId(1);
        Mockito.when(labelRepo.save()).thenReturn(label);
    }
//    @Test
//    public void addLabelTest(){
//        user.setUserId(1);
//        Mockito.when(repo.findUserById(1)).then(user);
//        note.setId(1);
//        Mockito.when(noteRepo.findById(1));
//        label.setList(List<NoteData>);
}
