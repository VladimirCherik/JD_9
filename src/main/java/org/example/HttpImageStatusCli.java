package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private final HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
    void askStatus(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter HTTP status code: ");
        while(true){
            if(in.hasNextInt()){
                int statusCode = in.nextInt();
                try {
                    imageDownloader.downloadStatusImage(statusCode);
                    System.out.println("The image downloaded successful");
                    break;
                }catch (Exception e){
                    System.out.printf("There is not image for HTTP status %s\n", statusCode);
                    System.out.println("Please enter valid number");
                }
            } else {
                System.out.println("Please enter valid number");
                in.next();
            }
        }
        in.close();
    }
}
