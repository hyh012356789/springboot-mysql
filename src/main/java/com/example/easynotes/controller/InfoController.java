package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.Result;
import com.example.easynotes.model.XcXInfo;
import com.example.easynotes.model.XcXInfo1;
import com.example.easynotes.repository.InfoRepository;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    InfoRepository infoRepository;

    @GetMapping("/lists")
    public Result<List<XcXInfo>> getLists() {
        return new Result<List<XcXInfo>>(infoRepository.findAll());
    }
     @PostMapping(value ="/add", consumes = "application/json")
     public Result<XcXInfo> addInfo(@RequestBody XcXInfo1 info) {

         XcXInfo info1 = new XcXInfo();
         info1.setTime(1500217200);
         info1.setAddtime(info.getAddtime());
         info1.setDeparture(info.getDeparture());
         info1.setDate(info.getDate());
         info1.setAvatarUrl(info.getAvatarUrl());
         info1.setDestination(info.getDestination());
         info1.setGender(info.getGender());
         info1.setName(info.getName());
         info.setAddtime((int)(new Date().getTime()/1000));
         Result<XcXInfo> result = new Result<XcXInfo>(infoRepository.save(info1));
         result.setStatus(1);
         result.setMsg("成功");

         return result;
     }
    @PostMapping("/index") Result<XcXInfo> getInfo( @RequestBody XcXInfo1 info){
        //XcXInfo info1 = infoRepository.findById(6L).get();
        Result<XcXInfo> result = new Result<XcXInfo>(infoRepository.findById(info.getId()).get());
        result.setStatus(1);
        result.setMsg("成功");

        return result;
    }
   /* @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }*/
}
