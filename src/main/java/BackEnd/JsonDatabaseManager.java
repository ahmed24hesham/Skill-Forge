package BackEnd;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonDatabaseManager<T> {

    private String fileName;
    private Gson gson = new Gson();
    private Type typeOfT;

    // Constructor
    public JsonDatabaseManager(String fileName, Type typeOfT) {
        this.fileName = fileName;
        this.typeOfT = typeOfT;
    }

    // Load objects from JSON
    public ArrayList<T> load() {
        try (FileReader reader = new FileReader(fileName)) {
            ArrayList<T> list = gson.fromJson(reader, typeOfT);
            return list != null ? list : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save objects to JSON
    public void save(ArrayList<T> list) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(list, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add a new object
    public void add(T obj) {
        ArrayList<T> list = load();
        list.add(obj);
        save(list);
    }
}
