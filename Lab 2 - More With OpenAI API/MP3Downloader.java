import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.FileUtils;

import java.util.Base64;

public class MP3Downloader {

    private static String FDR_SPEECH_URL = "https://www.fdrlibrary.org/documents/356632/405112/afdr003.mp3";

    public static void main(String[] args) throws Exception{
        System.out.println("Welcome to Lab 3");
        String toFile = "speech.mp3";

        try {
            File speech = new File("speech.mp3");
            //connectionTimeout, readTimeout = 10 seconds
            FileUtils.copyURLToFile(new URL(FDR_SPEECH_URL), speech, 10000, 10000);
            System.out.println(speech.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
