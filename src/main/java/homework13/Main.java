package homework13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static String USERS = "https://jsonplaceholder.typicode.com/users";
    public static String POSTS = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedException {
//        create();
//        update(9);
//        delete(9);
//        get();
//        getById(10);
//        getByUsername("Delphine");
//        getPostsById(1);
//        todo(1);
    }


    public static void create() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS)).POST(HttpRequest.BodyPublishers.ofFile(Path.of("src/main/resources/user.json"))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response.body());
    }

    public static void update(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "/" + id))
                .PUT(HttpRequest.BodyPublishers.ofFile(Path.of("src/main/resources/user.json"))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void delete(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "/" + id))
                .DELETE().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    }

    public static void get() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void getById(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "/" + id))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void getByUsername(String username) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "?username=" + username))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void getPostsById(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "/" + id + "/posts"))
                .GET().build();
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("src/main/resources/posts.json")));
        int postNum = getLargestIdFromPosts();

        request = HttpRequest.newBuilder().uri(URI.create(POSTS + "/" + postNum + "/comments"))
                .GET().build();

        response = client.send(request,HttpResponse.BodyHandlers.ofFile(Path.of("src/main/resources/user-" + id + "-post-" + postNum + "-comments.json")));

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static int getLargestIdFromPosts() throws FileNotFoundException {
        File file = new File("src/main/resources/posts.json");
        Scanner scanner = new Scanner(new FileInputStream(file));
        int id = Integer.MIN_VALUE;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("\"id\":")){
                id = Integer.parseInt(line.substring(line.indexOf(':') + 1, line.indexOf(',')).trim());
            }
        }
        return id;
    }

    public static void todo(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(USERS + "/" + id + "/todos?completed=false"))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
