package services;

import java.util.ArrayList;
import java.util.List;
import models.*;


public class InternshipService {
    private List<InternshipOpportunity> internships = new ArrayList<>();


    public void addOpportunity(InternshipOpportunity o) { internships.add(o); }
    public List<InternshipOpportunity> getAll() { return internships; }


    public InternshipOpportunity findById(String id) {
        for (InternshipOpportunity i : internships) if (i.getId().equals(id)) return i;
        return null;
    }
}