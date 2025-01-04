package net.harsh.journalApp.service;

import net.harsh.journalApp.entity.JournalEntry;
import net.harsh.journalApp.entity.User;
import net.harsh.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component // It is being used as a bean for JournalEntry
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

//    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) { // For post mapping
        try {
            User user = userService.findByUsername(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);// save is a function provided by MongoRepository
            user.getJournalEntries().add(saved);
//            user.setUserName(null);
            userService.saveEntry(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error occurred while saving journal entry. " + e);
        }
    }

    public void saveEntry(JournalEntry journalEntry) { // For put mapping
        journalEntryRepository.save(journalEntry); // We already updated what we wanted to in the PutMapping function in JournalController
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) { // JournalEntry is boxed in Optional so that we can handle the case where nothing is returned
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName) {
        User user = userService.findByUsername(userName);
//        user.getJournalEntries().remove(journalEntryRepository.findById(id));
        user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
        userService.saveEntry(user);
        // Consistency user ke next save par bhi aa jaegi par hame to hath ke hath hi delete chahiye
        journalEntryRepository.deleteById(id);
        return true;
    }
}
