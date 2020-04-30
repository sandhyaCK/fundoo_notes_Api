package com.bridgelabz.fundoonotes;

import com.bridgelabz.fundoonotes.implementation.NoteServiceImplementation;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotesServiceTest {
    @Mock
    private NoteRepository noteRepo;
    @Mock
    private UserRepository repo;
    NoteData note =new NoteData();
    UserInformation user=new UserInformation();
    NoteService service=new NoteServiceImplementation();

    @Test
    public void createNoteTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setArchieved(0);
        note.setColour("red");
        note.setDescription("welcome");
        note.setId(1);
        note.setCreatedDateAndTime(LocalDateTime.now());
        note.setPinned(0);
        note.setTitle("hello");
        note.setTrashed(0);
        Mockito.when(noteRepo.save(note)).thenReturn(note);
    }
    @Test
    public void testGetNotes() throws Exception {
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        List<NoteData> notes = new ArrayList<>();
        notes.add(createNoteTest());
        Mockito.when(noteRepo.getNotes()).thenReturn(notes);
        List<UserInformation> response = service.getAllNotes();
        response.forEach(System.out::println);
    }
    @Test
    public void updateTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.findById(1));
        note.setTitle("hii");
        note.setDescription("demo");
        note.setArchieved(1);
        note.setUpDateAndTime(LocalDateTime.now());
        note.setPinned(0);
        Mockito.when(noteRepo.save()).thenReturn(note);
    }
    @Test
    public void updateColorTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.findById(1));
        note.setColour("blue");
        Mockito.when(noteRepo.updateColor(1,1,"blue"));
    }

    @Test
    public void deleteNote(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.deleteNote(1,1)).thenReturn(true);
    }
    @Test
    public void archeiveNoteTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.findById(1));
        note.setArchieved(1);
        note.setPinned(0);
        Mockito.when(noteRepo.save()).thenReturn(note);
    }
    @Test
    public void pinNoteTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.findById(1));
        note.setPinned(1);
        note.setArchieved(0);
        Mockito.when(noteRepo.save()).thenReturn(note);
    }
    @Test
    public void trashNoteTest(){
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        note.setId(1);
        Mockito.when(noteRepo.findById(1));
        note.setPinned(0);
        note.setArchieved(0);
        note.setTrashed(1);
        Mockito.when(noteRepo.save()).thenReturn(note);
    }
    @Test
    public void GetArchievedNotesTest() throws Exception {
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        List<NoteData> notes = new ArrayList<>();
        notes.add(createNoteTest());
        Mockito.when(noteRepo.getArchievedNotes()).thenReturn(notes);
        List<UserInformation> response = service.getarchieved();
        response.forEach(System.out::println);
    }
    @Test
    public void GetPinnedNotes() throws Exception {
        user.setUserId(1);
        Mockito.when(repo.findUserById(1)).then(user);
        List<NoteData> notes = new ArrayList<>();
        notes.add(createNoteTest());
        Mockito.when(noteRepo.getPinnededNotes()).thenReturn(notes);
        List<UserInformation> response = service.getPinneded();
        response.forEach(System.out::println);
    }
}
