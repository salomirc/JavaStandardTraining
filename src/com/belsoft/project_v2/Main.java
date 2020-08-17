package com.belsoft.project_v2;

public class Main {
    public static void main(String[] args) {

        var dictionary = new CustomDictionary();

        dictionary.Add(new User("John", "Java developer"));
        dictionary.Add(new User("Mary", "Kotlin developer"));
        dictionary.Add(new User("Nick", "C# developer"));
        dictionary.Add(new Application("8080", "Ktor Netty engine app"));
        dictionary.Add(new Application("80", "Apache2 web server"));
        dictionary.Add(new Application("8089", "Spring microservice app"));
        dictionary.Add(new Domain("192.160.0.1", "john.com"));
        dictionary.Add(new Domain("192.160.0.2", "mary.com"));
        dictionary.Add(new Domain("192.160.0.3", "nick.com"));

        dictionary.print("Mary");
        dictionary.print("80");
        dictionary.print("192.160.0.3");
        dictionary.print("Selena");

        dictionary.printAll();
    }
}
