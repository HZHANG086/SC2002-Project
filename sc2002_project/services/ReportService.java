package services;

import enums.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.*;


public class ReportService {
    public static void printOpportunitiesByStatus(List<InternshipOpportunity> list) {
        Map<OpportunityStatus, List<InternshipOpportunity>> map = list.stream().collect(Collectors.groupingBy(InternshipOpportunity::getStatus));
        for (OpportunityStatus s : OpportunityStatus.values()) {
            System.out.println("== " + s + " ==");
            List<InternshipOpportunity> l = map.get(s);
            if (l == null || l.isEmpty()) System.out.println(" (none)");
            else l.forEach(i -> System.out.println(" " + i));
        }
    }
}