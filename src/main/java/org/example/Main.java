package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>();

        for (Employee e : list) {
            if (e != null && !seen.add(e)) {
                duplicates.add(e);
            }
        }

        return new ArrayList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new LinkedHashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (Employee e : list) {
            if (e != null) {
                if (!seen.contains(e.getId())) {
                    map.put(e.getId(), e);
                    seen.add(e.getId());
                }
            }
        }

        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> freq = new HashMap<>();
        for (Employee e : list) {
            if (e != null) {
                freq.put(e, freq.getOrDefault(e, 0) + 1);
            }
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<Employee, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
