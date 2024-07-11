package provider;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.InetSocketAddress;

import java.util.logging.Logger;
import com.sun.net.httpserver.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException{

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/page1", new P1Handler());
        server.createContext("/page2", new P2Handler());
        server.start();
        System.out.println("Server is listening on port 8000.");
    }

    static class P1Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            headers.add("Access-Control-Allow-Headers", "Content-Type");
            String requestMethod = exchange.getRequestMethod();
            System.out.println("Received request with method: " + requestMethod);
            if (requestMethod.equals("GET")) {
                handleGetRequest(exchange);
            } else{
                exchange.sendResponseHeaders(405, -1);
            }
        }

        private void handleGetRequest(HttpExchange exchange) throws IOException {
            String response = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss MM/dd/yyyy"));
            System.out.println("inside GET: " + response);
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, 0);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }  
       
    static class P2Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getResponseHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            headers.add("Access-Control-Allow-Headers", "Content-Type");
            String requestMethod = exchange.getRequestMethod();
            System.out.println("Received request with method: " + requestMethod);
            if (requestMethod.equals("GET")) {
                handleGetRequest(exchange);
            } else{
                exchange.sendResponseHeaders(405, -1);
            }
        }

        private void handleGetRequest(HttpExchange exchange) throws IOException {
            String response = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
            System.out.println("inside GET: " + response);
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, 0);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }  


}
