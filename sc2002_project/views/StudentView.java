package views;

import controllers.*;
import enums.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import models.*;
import services.*;


public class StudentView {
    private Student student;
    private InternshipService internshipService;
    private ApplicationService applicationService;
    private Scanner scanner = new Scanner(System.in);


    public StudentView(Student s, InternshipService is, ApplicationService as) { this.student = s; this.internshipService = is; this.applicationService = as; }


    public void show() {
        while (true) {
            System.out.println("\n--- Student Menu (" + student.getName() + ") ---");
            System.out.println("1) View available internships");
            System.out.println("2) My applications");
            System.out.println("3) Logout");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            if (c.equals("1")) viewAvailable();
            else if (c.equals("2")) viewApplications();
            else if (c.equals("3")) break;
        }
    }


    private void viewAvailable() {
        List<InternshipOpportunity> list = internshipService.getAll().stream().filter(i -> i.isVisible() && i.getStatus() == OpportunityStatus.APPROVED && (i.getPreferredMajor() == null || i.getPreferredMajor().isEmpty() || i.getPreferredMajor().equalsIgnoreCase(student.getMajor()))).collect(Collectors.toList());
        if (list.isEmpty()) { System.out.println("No opportunities available."); return; }
        for (InternshipOpportunity i : list) System.out.println(i);
        System.out.print("Enter internship ID to apply or blank to return: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) return;
        new StudentController(new UserService(), internshipService, applicationService).apply(student, id);
    }


    private void viewApplications() {
        if (student.getApplications().isEmpty()) { System.out.println("No applications."); return; }
        for (Application a : student.getApplications()) System.out.println(a);
    }
}