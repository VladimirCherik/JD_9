package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker getURL = new HttpStatusChecker();
    public void downloadStatusImage(int code) {
        try {
            URL url = new URL(getURL.getStatusImage(code));
            try (InputStream inputStream = url.openStream();
                 OutputStream outputStream = new FileOutputStream("image.jpg")) {

                byte[] b = new byte[2048];
                int length;
                while ((length = inputStream.read(b)) != -1) {
                    outputStream.write(b, 0, length);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
