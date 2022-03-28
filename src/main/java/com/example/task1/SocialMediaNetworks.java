package com.example.task1;

import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaNetworks {

    public String and(String networksOne, String networksTwo) {
        List<String> firstNetworks = Arrays.asList(networksOne.split(","));
        List<String> secondNetworks = Arrays.asList(networksTwo.split(","));
        Set<String> set = firstNetworks.stream().map(network -> secondNetworks.stream().filter(sec -> network.equals(sec) &&
                        SocialMediaNetworksEnum.getByName(network.toUpperCase()) != null).findAny())
                .filter(Optional::isPresent).map(Optional::get).collect(java.util.stream.Collectors.toCollection(LinkedHashSet::new));

        String resultSet = "";
        for (String net : set) {
            resultSet = resultSet.concat(net + ",");
        }
        return resultSet.substring(0, resultSet.length() - 1);
    }

    public String or(String networksOne, String networksTwo) {
        List<String> firstNetworks = Arrays.asList(networksOne.split(","));
        List<String> secondNetworks = Arrays.asList(networksTwo.split(","));
        Set<String> filtered = firstNetworks.stream().filter(network -> SocialMediaNetworksEnum.getByName(network.toUpperCase()) != null)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        filtered.addAll(secondNetworks.stream().filter(network -> SocialMediaNetworksEnum.getByName(network.toUpperCase()) != null)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        String resultSet = "";
        for (String net : filtered) {
            resultSet = resultSet.concat(net + ",");
        }
        return resultSet.substring(0, resultSet.length() - 1);
    }
}
