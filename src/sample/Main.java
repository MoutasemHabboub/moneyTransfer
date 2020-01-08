package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import javafx.util.Pair;
import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.NameValuePair;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("sss");
        try {
          // call_me();
            //call_me_addemployee();
           // call_LOGiN();
            call_me_addNewTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //  launch(args);
    }
    public static void call_LOGiN() throws Exception{
        URL url = new URL("http://192.168.1.2:3000/employee/login");
        StringBuilder postData = new StringBuilder();
        JSONObject jsonObject=new JSONObject();


        jsonObject.put("email","koko@kekeko.com");
        jsonObject.put("password","jojo");
        System.out.println(jsonObject);

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        String jsonInputString = "{name: Upendra, job: Programmer}";
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
/*لازم نحفظ التوكين*/
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    public static void call_me_addemployee() throws Exception{
        URL url = new URL("http://192.168.1.2:3000/employee/create");
        StringBuilder postData = new StringBuilder();
        JSONObject jsonObject=new JSONObject();


        jsonObject.put("email","koko@kekeko.com");
        jsonObject.put("password","jojo");
        jsonObject.put("firstName","koko");
        jsonObject.put("lastName","keke");
        jsonObject.put("salary",1000000);
        System.out.println(jsonObject);

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        String jsonInputString = "{name: Upendra, job: Programmer}";
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
/*لازم نحفظ التوكين*/
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
        conn.disconnect();

    }
    public static void call_me_addNewTransaction() throws Exception{
        URL url = new URL("http://192.168.1.2:3000/transaction/make");
        StringBuilder postData = new StringBuilder();
        JSONObject jsonObject=new JSONObject();



        jsonObject.put("payerIdentityNumber",0101010101);
        jsonObject.put("payerFirstName","jojo");
        jsonObject.put("payerLastName","koko");
        jsonObject.put("payerAddress","keke");

        jsonObject.put("payeeIdentityNumber",0111111101);
        jsonObject.put("payeeFirstName","jojo1");
        jsonObject.put("payeeLastName","koko1");
        jsonObject.put("payeeAddress","keke1");
        jsonObject.put("cardNumber",10000);
        jsonObject.put("moneyAmount",10000);
        System.out.println(jsonObject);

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZGVudGl0eU51bWJlciI6IjA5OTk5OTk5OTkiLCJpYXQiOjE1Nzg1MDY2NTgsImV4cCI6MTU3ODU0MjY1OH0.mx-rGjsbxNwcBDMySCDoBuEy4dDmr8cvjYPJ_fNosSI");

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        String jsonInputString = "{name: Upendra, job: Programmer}";
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
/*لازم نحفظ التوكين*/
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
        conn.disconnect();

    }
    public static void callDelet() throws Exception{
        String url = "192.168.1.2:3000/employee/delete/wwrw@otw.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("DELETE");
        //add request header
        con.setRequestProperty("Content-Type", "application/json");
        //con.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZGVudGl0eU51bWJlciI6IjA5OTk5OTk5OTkiLCJpYXQiOjE1Nzg1MDY2NTgsImV4cCI6MTU3ODU0MjY1OH0.mx-rGjsbxNwcBDMySCDoBuEy4dDmr8cvjYPJ_fNosSI");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print in String
        System.out.println(response.toString());

        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");


    }
    public static void call_me1() throws Exception {
        /*
        Map params = new HashMap();
        params.put("name", "Jinu Jawad");
        params.put("email", "helloworld@gmail.com");
        params.put("CODE", 1111);
        params.put("message", "Hello Post Test success");*/




/*
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(( ), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(), "UTF-8"));
        if (postData.length() != 0) postData.append('&');
        postData.append(URLEncoder.encode(( ), "UTF-8"));
        postData.append('=');
        postData.append(URLEncoder.encode(String.valueOf(), "UTF-8"));*/
        List<Pair<String ,String >> urlParameters = new ArrayList<>();
       /* urlParameters.add(new Pair<>());
        urlParameters.add(new Pair<>());*/


      //  byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        //conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

       /* conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        System.out.println(response);
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("origin- "+myResponse.getString("origin"));
        System.out.println("url- "+myResponse.getString("url"));
        JSONObject form_data = myResponse.getJSONObject("form");
        System.out.println("CODE- "+form_data.getString("CODE"));
        System.out.println("email- "+form_data.getString("email"));
        System.out.println("message- "+form_data.getString("message"));
        System.out.println("name"+form_data.getString("name"));
    */
    }

    public static void ShowTransaction() throws Exception {
        String url = "http://192.168.1.2:3000/transaction/fetch/77777";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZGVudGl0eU51bWJlciI6IjA5OTk5OTk5OTkiLCJpYXQiOjE1Nzg1MDY2NTgsImV4cCI6MTU3ODU0MjY1OH0.mx-rGjsbxNwcBDMySCDoBuEy4dDmr8cvjYPJ_fNosSI");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print in String
        System.out.println(response.toString());

        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");

con.disconnect();
    }
/*
    public static void call_me() throws Exception {
        String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());
        //Read JSON response and print

        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("statusCode- "+myResponse.getString("statusCode"));
        System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
        System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
        System.out.println("countryCode- "+myResponse.getString("countryCode"));
        System.out.println("countryName- "+myResponse.getString("countryName"));
        System.out.println("regionName- "+myResponse.getString("regionName"));
        System.out.println("cityName- "+myResponse.getString("cityName"));
        System.out.println("zipCode- "+myResponse.getString("zipCode"));
        System.out.println("latitude- "+myResponse.getString("latitude"));
        System.out.println("longitude- "+myResponse.getString("longitude"));
        System.out.println("timeZone- "+myResponse.getString("timeZone"));



    }*/
}
