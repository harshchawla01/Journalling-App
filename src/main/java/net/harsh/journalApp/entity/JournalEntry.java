package net.harsh.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries") // document in a NoSQL DB is equivalent to a row in SQL. Either give the collection name in round brackets or it will be searched as class name
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode

@Data
@NoArgsConstructor // Required for deserialization from JSON to POJO
public class JournalEntry {

//    @Id // primary key
//    private String id;
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date; // introduced in Java 8
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
}
