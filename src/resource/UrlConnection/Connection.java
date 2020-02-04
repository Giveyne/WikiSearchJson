package resource.UrlConnection;

import java.io.BufferedReader;
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
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                connection.getInputStream())
                                );// возвращаем InputStream из соединения

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString(); // переводим СтрингБаффер в Стринг
            in.close();
            connection.disconnect();
        return result;
        } catch (MalformedInputException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException ex){
        ex.printStackTrace();
        }
        return null;
    }
}

