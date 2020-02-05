package resource.UrlConnection;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class Connection {

    private String url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
    private StringBuffer response = new StringBuffer();
    private String inputLine;
    private String result;
    //url = URLEncoder.encode(url, "UTF-8"); если вдруг надо перекодировать
    public String setRead(String wordFine){ // метож считывающий текст из википедии и возвращает результат
        try {
            URL obj = new URL(url + wordFine); // создаем обьект URL для получения сущности
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection(); // получаем сущность URL

            connection.setRequestMethod("GET"); // получаем метод запроса GET (запрашиваем данные для считывания)

            BufferedInputStream inputStream =
                    new BufferedInputStream(connection.getInputStream());// возвращаем InputStream из соединения
            try(ByteArrayOutputStream result = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                    result.write(buffer, 0, length);
                }
                inputStream.close();
                connection.disconnect();
                return result.toString("UTF-8");
            }
        } catch (MalformedInputException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException ex){
        ex.printStackTrace();
        }
        return null;
    }
}

