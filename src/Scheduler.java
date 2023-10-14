import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;


public class Scheduler {
    HttpURLConnection http;

    public void start(String token){
        try {
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Start?token=" + token;
            URL url = new URL(endpoint);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(false);
            http.connect();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("Reset successfully");
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        http.disconnect();
    }

    public void stop(String token){
        try {
            System.out.println("STOP");
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Stop?token=" + token;
            URL url = new URL(endpoint);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(false);
            http.connect();

            String respData;
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                respData = readString(respBody);

                System.out.println(respData);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                InputStream respBody = http.getErrorStream();
                respData = readString(respBody);
                System.out.println(respData);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        http.disconnect();
    }

    public void getAppointments(String token){
        try {
            System.out.println("GET APPTS");
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Schedule?token=" + token;
            URL url = new URL(endpoint);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setDoOutput(false);
            http.connect();

            String respData;
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                respData = readString(respBody);

                System.out.println(respData);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                InputStream respBody = http.getErrorStream();
                respData = readString(respBody);
                System.out.println(respData);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        http.disconnect();
    }

    public void getNextAppointment(String token){
        try {
            System.out.println("GET NEXT APPTS");
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/AppointmentRequest?token=" + token;
            URL url = new URL(endpoint);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setDoOutput(false);
            http.connect();

            String respData;
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                respData = readString(respBody);

                System.out.println(respData);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                InputStream respBody = http.getErrorStream();
                respData = readString(respBody);
                System.out.println(respData);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        http.disconnect();
    }

    public void scheduleAppointment(String token, AppointmentInfoRequest request){
        try {
            System.out.println("SCHEDULE APPTS");
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Schedule?token=" + token;
            URL url = new URL(endpoint);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true); //this one does have a request body
            http.setRequestProperty("Content-Type", "application/json");

            http.connect();

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String reqData = gson.toJson(request);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            String respData;
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBody = http.getInputStream();
                respData = readString(respBody);

                System.out.println(respData);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                InputStream respBody = http.getErrorStream();
                respData = readString(respBody);
                System.out.println(respData);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        http.disconnect();
    }

    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }
}
