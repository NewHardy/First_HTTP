package org.example;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client
{
    private static final String LOCATOR = "https://www.google.com/";
    public static void getHTML () throws IOException
    {
        URL url = new URL(LOCATOR);
        HttpURLConnection connector= (HttpURLConnection) url.openConnection();
        connector.setRequestMethod("GET");
        int response = connector.getResponseCode();
        if (response==HttpURLConnection.HTTP_OK)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(connector.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine;
            while((inputLine=br.readLine())!=null)
            {
                sb.append(inputLine).append("\n");
            }
            br.close();
            FileWriter fw = new FileWriter("CHESS.html");
            fw.write(sb.toString());
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        getHTML();
    }
}