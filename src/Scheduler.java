import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;


public class Scheduler {

    public void start(String token){
        try {
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Start?token=" + token;
            URL url = new URL(endpoint);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
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
    }

    public void stop(String token){
        try {
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Stop?token=" + token;
            URL url = new URL(endpoint);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
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
    }

    public void getAppointments(String token){
        try {
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/Schedule?token=" + token;
            URL url = new URL(endpoint);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
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
    }

    public void getNextAppointment(String token){
        try {
            String endpoint = "http://scheduling-interview-2021-265534043.us-west-2.elb.amazonaws.com/api/Scheduling/AppointmentRequest?token=" + token;
            URL url = new URL(endpoint);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
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
    }

    public void scheduleAppointment(String token){
        //fixme
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


}
