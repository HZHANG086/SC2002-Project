package controllers;

import enums.*;
import models.*;
import services.*;

public class StudentController {
    private UserService userService;
    private InternshipService internshipService;
    private ApplicationService applicationService;


    public StudentController(UserService us, InternshipService is, ApplicationService as) {
        this.userService = us; this.internshipService = is; this.applicationService = as;
    }


    public void apply(Student s, String internshipId) {
        InternshipOpportunity opp = internshipService.findById(internshipId);
        if (opp == null) { System.out.println("Internship not found."); return; }
        if (!opp.isVisible() || opp.getStatus() != OpportunityStatus.APPROVED) { System.out.println("Not open for applications."); return; }
        if (!s.canApplyForLevel(opp.getLevel())) { System.out.println("Your year doesn't allow applying for this level."); return; }
        if (s.hasReachedApplicationLimit()) { System.out.println("You have reached the maximum number of active applications (3)."); return; }
        Application app = new Application(s, opp);
        applicationService.addApplication(app);
        System.out.println("Application submitted: " + app.getId());
    }
}