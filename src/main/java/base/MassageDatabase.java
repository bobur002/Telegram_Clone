package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import module.Massage;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MassageDatabase extends BaseDatabase<Massage>{
    @Override
    public List<Massage> getObjectList() {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("massages");
        List<Massage> massageList = new ArrayList<>();

        for (Document doc: users.find()) {
            String json = doc.toJson();
            massageList.add(new Gson().fromJson(json,Massage.class));
        }
        return massageList;
    }

    @Override
    public Massage getObject(String id) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> massages
                = connection.getCollection("massages");
        Document document = massages.find(Filters.eq("id", id)).first();
        return new Gson().fromJson(document.toJson(),Massage.class);
    }

    @Override
    public boolean addObject(Massage massage) throws JsonProcessingException {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> massages = connection.getCollection("massages");
        Gson gson = new Gson();
        String toJson = gson.toJson(massage);
        massages.insertOne(Document.parse(toJson));
        return true;
    }
}
