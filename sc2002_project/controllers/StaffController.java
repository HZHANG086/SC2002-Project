package controllers;

import enums.*;
import models.*;
import services.*;

public class StaffController {
    private UserService userService;
    private InternshipService internshipService;


    public StaffController(UserService us, InternshipService is) { this.userService = us; this.internshipService = is; }


    public void approveCompanyRep(CompanyRepresentative rep) {
        rep.setRegistrationStatus(RequestStatus.APPROVED);
        System.out.println("Approved rep: " + rep.getName());
    }


    public void approveInternship(InternshipOpportunity opp) {
        opp.setStatus(OpportunityStatus.APPROVED);
        opp.setVisible(true);
        System.out.println("Approved internship: " + opp.getId());
    }
}