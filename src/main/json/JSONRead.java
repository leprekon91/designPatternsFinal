package main.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JSONRead {
    public static JSONObject readFile() {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("input.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
