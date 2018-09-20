package com.example.serg.rozklad;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ConnectionFactory {
    private double API_VERSION = 0;
    private String API = "";
    private String METHOD = "POST";
    private String TYPE = "application/x-www-form-urlencoded; charset=utf-8";
    private String USER_AGENT = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.0.3705)";
    private String data = "";
    private URL connection;
    private HttpURLConnection finalConnection;

    private HashMap<String, String> fields = new HashMap<String, String>();
    public ConnectionFactory(String[] endpoint, String url, double version){
        this.API=url;
        this.API_VERSION = version;
        fields.put("version", String.valueOf(version));
        for (int i=0;i<endpoint.length;i++){
            String [] points = endpoint[i].split(";");
            for (int f=0;f<points.length;f++){
                fields.put(points[f].split(":")[0], points[f].split(":")[1]);
            }
        }
    }
    public String buildConnection(){
        StringBuilder content = new StringBuilder();
        if(!this.getEndpoints().equalsIgnoreCase("")&& !this.getEndpoints().isEmpty()){
            String vars ="";
            String vals ="";
            try {
                for (Map.Entry<String,String> entry : fields.entrySet()){
                    vars = entry.getKey();
                    vals = entry.getValue();
                    data+= ("&"+vars+"="+vals);
                }
                if (data.startsWith("&")){
                    data= data.replaceFirst("&", "");
                }
                connection = new URL(API);
                BufferedReader reader = new BufferedReader(new InputStreamReader(readWithAccess(connection,data)));
                String line;
                while ((line = reader.readLine())!= null){
                    content.append(line + "\n");
                }
                reader.close();
                return content.toString();
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        } else {
            //System.out.println("Endpoints is null");
            return null;
        }
        //System.out.println("Endpoints not is null");
        return null;
    }

    private InputStream readWithAccess(URL url,String data){
        try{
            byte []out = data.toString().getBytes("utf-8");
            System.err.println("01");
            finalConnection = (HttpURLConnection) url.openConnection();
            System.err.println("02");
            finalConnection.setRequestMethod("POST");
            System.err.println("03");
            finalConnection.setRequestProperty("Content-Length", String.valueOf(out.length));
            System.err.println("04");
            finalConnection.setDoOutput(true);
            System.err.println("05");
            finalConnection.setInstanceFollowRedirects(false);
            System.err.println("06");
            finalConnection.addRequestProperty("User-Agent",USER_AGENT);
            System.err.println("07");
            finalConnection.addRequestProperty("Content-Type",TYPE);
            System.err.println("08");
            finalConnection.setRequestProperty("charset", "utf-8");
            System.err.println("Try connect");
            finalConnection.connect();
            try{
                OutputStream os = finalConnection.getOutputStream();
                os.write(out);
            }catch (Exception e){
                System.err.println(e.getMessage()+"<1");
            }
            return finalConnection.getInputStream();
        }catch (Exception e){
            System.err.println(e.getMessage()+"<2");
            return null;
        }
    }

    public String getApiVersion(){
        return String.valueOf(API_VERSION);
    }
    public String getData(){
        return data;
    }
    public String getEndpoints(){
        return fields.toString();
    }
    public String getEnpointValue(String key){
        return fields.get(key);
    }
    public void setUserAgent(String userAgent){
        this.USER_AGENT = userAgent;
    }
    public void setMethod(String method){
        this.METHOD = method;
    }
    public void setSubmissionType(String type){
        this.TYPE = type;
    }
}
