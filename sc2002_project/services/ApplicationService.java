package services;

import java.util.ArrayList;
import java.util.List;
import models.*;


public class ApplicationService {
    private List<Application> applications = new ArrayList<>();


    public void addApplication(Application a) {
        applications.add(a);
        a.getStudent().getApplications().add(a);
        a.getOpportunity().getApplicants().add(a);
    }


    public List<Application> getAll() { return applications; }
}