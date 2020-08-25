package com.belsoft.project_v2;

import java.util.*;

public class CustomDictionary {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Application> applications = new HashMap<>();
    private final Map<String, Domain> domains = new HashMap<>();

    private final List<MapInfo> mapsInfo = new ArrayList<>();


    public CustomDictionary() {
        mapsInfo.add(new MapInfo(users, false));
        mapsInfo.add(new MapInfo(applications, true));
        mapsInfo.add(new MapInfo(domains, false));
    }

    public void Add(User user) {
        users.put(user.getName(), user);
    }

    public void Add(Application app) {
        applications.put(app.getPort(), app);
    }

    public void Add(Domain domain) {
        domains.put(domain.getIp(), domain);
    }


    public void print(String key) {
        var found = false;
        for (var mapInfo: mapsInfo) {
            if (mapInfo.getMap().containsKey(key)) {
                System.out.println(key + " = " + mapInfo.getMap().get(key).toString());
                found = true;
            }
        }
        if (!found) System.out.println(key + " is not a valid key.");
    }

    public void printAll() {
        System.out.println("\nPrinting all entries:");
        mapsInfo.forEach( mapInfo -> {
            mapInfo.getMap().keySet().stream()
                    .sorted(mapInfo.isReverseSorting() ? Comparator.reverseOrder() : Comparator.naturalOrder())
                    .forEach(key -> System.out.println(key + " = " + mapInfo.getMap().get(key)));
        });
    }
}
