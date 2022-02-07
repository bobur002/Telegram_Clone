package base;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public abstract class BaseDatabase<T> {
    public abstract List<T> getObjectList();
    public abstract Document getObject(String id);
    public abstract boolean addObject(T t) throws JsonProcessingException;
    public static MongoDatabase getConnection(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        return mongoClient.getDatabase("admin");

    }


}
