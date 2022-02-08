package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import module.Chat;
import module.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ChatDatabase extends BaseDatabase<Chat>{
    @Override
    public List<Chat> getObjectList() {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("chats");
        List<Chat> usersList = new ArrayList<>();

        for (Document doc: users.find()) {
            String json = doc.toJson();
            usersList.add(new Gson().fromJson(json,Chat.class));
        }
        return usersList;
    }

    @Override
    public Chat getObject(String id) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users
                = connection.getCollection("chats");
        Document document = users.find(Filters.eq("id", id)).first();
        return new Gson().fromJson(document.toJson(),Chat.class);
    }

    @Override
    public boolean addObject(Chat chat) throws JsonProcessingException {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> chats = connection.getCollection("chats");
        Gson gson = new Gson();
        String toJson = gson.toJson(chat);
        chats.insertOne(Document.parse(toJson));
        return true;
    }
}
