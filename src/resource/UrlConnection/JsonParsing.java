package resource.UrlConnection;


import com.fasterxml.jackson.core.*;
import java.io.IOException;

import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
public class JsonParsing {
    public static void readJson(String wordText) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(wordText);
        JsonToken jsonToken = jsonParser.nextToken();
        while(jsonParser.hasCurrentToken()) {
            if(jsonToken == VALUE_STRING) {
             //
                System.out.printf("%15s%n",jsonParser
                        .getText()
                        .replaceAll("<span class=\"searchmatch\">", "")
                        .replaceAll("</span>" , "")
                        .replaceAll("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z", "")
                        + " ");
            }
            jsonToken = jsonParser.nextToken();
        }
        System.out.println();
    }

}
