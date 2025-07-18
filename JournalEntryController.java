package com.jrana.journalApp.controller;

import com.jrana.journalApp.entiity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalentries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalentries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalentries.put(myEntry.getId(),myEntry);
        return true;
    }
   @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryById(@PathVariable Long myID){
       return journalentries.get(myID);
    }
    @DeleteMapping("id/{myID}")
    public JournalEntry deleteJournalEntryBYID(@PathVariable long myID){
        return journalentries.remove(myID);
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJouranlByID(@PathVariable long id, @RequestBody JournalEntry myEntry){
        return journalentries.put(id, myEntry);
    }
}
