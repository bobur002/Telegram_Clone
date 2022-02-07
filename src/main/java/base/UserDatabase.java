package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import module.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase extends BaseDatabase<User> {

    @Override
    public List<User> getObjectList() {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");
        List<User> usersList = new ArrayList<>();

        return null;
    }

    @Override
    public Document getObject(String id) {
        return null;
    }

    @Override
    public boolean addObject(User user) throws JsonProcessingException {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");
        Gson gson = new Gson();
        String toJson = gson.toJson(user);
        users.insertOne(Document.parse(toJson));
        return true;
    }
}
