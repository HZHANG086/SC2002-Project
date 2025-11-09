package controllers;

import enums.*;
import models.*;
import services.*;

public class CompanyRepController {
    private InternshipService internshipService;


    public CompanyRepController(InternshipService is) { this.internshipService = is; }


    public void createOpportunity(CompanyRepresentative rep, String title, String desc, InternshipLevel level, String preferredMajor, java.time.LocalDate open, java.time.LocalDate close, int slots) {
        if (rep.getInternships().size() >= 5) { System.out.println("You have reached your limit of 5 internships."); return; }
        InternshipOpportunity opp = new InternshipOpportunity(title, desc, level, preferredMajor, open, close, rep.getCompanyName(), rep, slots);
        rep.getInternships().add(opp);
        internshipService.addOpportunity(opp);
        System.out.println("Internship created (pending approval): " + opp.getId());
    }
}