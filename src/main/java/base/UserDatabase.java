package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import module.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase extends BaseDatabase<User> {

    @Override
    public List<User> getObjectList() {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");
        List<User> usersList = new ArrayList<>();

        for (Document doc: users.find()) {
            String json = doc.toJson();
            usersList.add(new Gson().fromJson(json,User.class));
        }
        return usersList;
    }

    @Override
    public User getObject(String id) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users
                = connection.getCollection("users");
        Document document = users.find(Filters.eq("id", id)).first();
        return new Gson().fromJson(document.toJson(),User.class);
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
