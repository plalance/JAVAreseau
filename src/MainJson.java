import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Mol on 04/06/2017.
 */
public class MainJson {

    static String message;

    public static void encode(String login) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("action", "login");
        obj.put("login", login);
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        message = out.toString();
        System.out.println(obj.toString());
    }

    public static void decode(String msg) {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(msg);


            String login = (String) jsonObject.get("login");
            String action = (String) jsonObject.get("action");

            System.out.println("La methode est: " + action);
            System.out.println("Le login est: " + login);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        encode("Toto");
        decode(message);
    }
}
