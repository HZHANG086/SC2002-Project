package views;

import java.util.Scanner;
import models.*;
import services.*;


public class MenuView {
    private Scanner scanner = new Scanner(System.in);
    private UserService userService;
    private InternshipService internshipService;
    private ApplicationService applicationService;
    private WithdrawalService withdrawalService;


    public MenuView(UserService us, InternshipService is, ApplicationService as, WithdrawalService ws) {
        this.userService = us; this.internshipService = is; this.applicationService = as; this.withdrawalService = ws;
    }


    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== Internship Management System ===");
            System.out.println("1) Login");
            System.out.println("2) Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) login();
            else if (choice.equals("2")) { System.out.println("Goodbye"); break; }
        }
    }


    private void login() {
        System.out.print("UserID: "); String id = scanner.nextLine().trim();
        System.out.print("Password: "); String pw = scanner.nextLine().trim();
        User u = userService.authenticate(id, pw);
        if (u == null) { System.out.println("Invalid credentials."); return; }
        System.out.println("Welcome " + u.getName());
        if (u instanceof Student) new StudentView((Student) u, internshipService, applicationService).show();
        else if (u instanceof CompanyRepresentative) new CompanyRepView((CompanyRepresentative) u, internshipService).show();
        else if (u instanceof CareerCenterStaff) new StaffView((CareerCenterStaff) u, userService, internshipService).show();
    }
}