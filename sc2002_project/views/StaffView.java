package views;

import controllers.*;
import enums.*;
import java.util.Scanner;
import models.*;
import services.*;


public class StaffView {
    private CareerCenterStaff staff;
    private UserService userService;
    private InternshipService internshipService;
    private Scanner scanner = new Scanner(System.in);


    public StaffView(CareerCenterStaff s, UserService us, InternshipService is) { this.staff = s; this.userService = us; this.internshipService = is; }


    public void show() {
        while (true) {
            System.out.println("\n--- Staff Menu (" + staff.getName() + ") ---");
            System.out.println("1) Approve company reps");
            System.out.println("2) Approve internships");
            System.out.println("3) View report by status");
            System.out.println("4) Logout");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            if (c.equals("1")) approveReps();
            else if (c.equals("2")) approveInternships();
            else if (c.equals("3")) ReportService.printOpportunitiesByStatus(internshipService.getAll());
            else if (c.equals("4")) break;
        }
    }


    private void approveReps() {
        for (User u : userService.getAllUsers().values()) {
            if (u instanceof CompanyRepresentative) {
                CompanyRepresentative rep = (CompanyRepresentative) u;
                if (rep.getRegistrationStatus() == RequestStatus.PENDING) {
                    System.out.println(rep);
                    System.out.print("Approve this rep? (y/n): ");
                    String ans = scanner.nextLine().trim();
                    if (ans.equalsIgnoreCase("y")) new StaffController(userService, internshipService).approveCompanyRep(rep);
                }
            }
        }
    }


    private void approveInternships() {
        for (InternshipOpportunity i : internshipService.getAll()) {
            if (i.getStatus() == OpportunityStatus.PENDING) {
                System.out.println(i);
                System.out.print("Approve this internship? (y/n): ");
                String ans = scanner.nextLine().trim();
                if (ans.equalsIgnoreCase("y")) new StaffController(userService, internshipService).approveInternship(i);
            }
        }
    }
}