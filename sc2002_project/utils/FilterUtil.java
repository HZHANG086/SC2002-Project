package utils;

import enums.*;
import java.util.List;
import java.util.stream.Collectors;
import models.*;


public class FilterUtil {
    public static List<InternshipOpportunity> filterByMajor(List<InternshipOpportunity> list, String major) {
    return list.stream().filter(i -> i.getPreferredMajor() == null || i.getPreferredMajor().isEmpty() || i.getPreferredMajor().equalsIgnoreCase(major)).collect(Collectors.toList());
    }


    public static List<InternshipOpportunity> filterByLevel(List<InternshipOpportunity> list, InternshipLevel level) {
        return list.stream().filter(i -> i.getLevel() == level).collect(Collectors.toList());
    }
}