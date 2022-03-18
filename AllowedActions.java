package com.example.tellyo;

import java.util.*;
import java.util.stream.Collectors;

public class AllowedActions {

    public String and(String actionsOne, String actionsTwo) {
        List<String> firstActions = Arrays.asList(actionsOne.split(","));
        List<String> secondActions = Arrays.asList(actionsTwo.split(","));
        Set<String> set = firstActions.stream().map(network -> secondActions.stream().filter(sec -> network.equals(sec) &&
                        AllowedActionsEnum.getByName(network.toUpperCase()) != null).findAny())
                .filter(Optional::isPresent).map(Optional::get).collect(java.util.stream.Collectors.toCollection(LinkedHashSet::new));

        String resultSet = "";
        for (String net : set) {
            resultSet = resultSet.concat(net + ",");
        }
        return resultSet.substring(0, resultSet.length() - 1);
    }

    public String or(String actionsOne, String actionsTwo) {
        List<String> firstActions = Arrays.asList(actionsOne.split(","));
        List<String> secondActions = Arrays.asList(actionsTwo.split(","));
        Set<String> filtered = firstActions.stream().filter(network -> AllowedActionsEnum.getByName(network.toUpperCase()) != null)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        filtered.addAll(secondActions.stream().filter(network -> AllowedActionsEnum.getByName(network.toUpperCase()) != null)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
        String resultSet = "";
        for (String net : filtered) {
            resultSet = resultSet.concat(net + ",");
        }
        return resultSet.substring(0, resultSet.length() - 1);
    }
}
