package resource;

import resource.UrlConnection.Connection;
import resource.UrlConnection.JsonParsing;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
// Программа парсинга JSON данных из викепедия https://ru.wikipedia.org
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter find word" );
        Scanner in = new Scanner(System.in);
        String wordFine = in.nextLine();
        long start = System.nanoTime();
        Connection connection = new Connection();
        String wordText = connection.setRead(wordFine);
        JsonParsing parsing = new JsonParsing();
        parsing.readJson(wordText);
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}

