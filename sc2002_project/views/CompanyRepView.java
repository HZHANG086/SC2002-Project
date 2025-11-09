package views;

import controllers.*;
import enums.*;
import java.time.LocalDate;
import java.util.Scanner;
import models.*;
import services.*;


public class CompanyRepView {
    private CompanyRepresentative rep;
    private InternshipService internshipService;
    private Scanner scanner = new Scanner(System.in);


    public CompanyRepView(CompanyRepresentative rep, InternshipService is) { this.rep = rep; this.internshipService = is; }


    public void show() {
        while (true) {
            System.out.println("\n--- Company Rep Menu (" + rep.getName() + ") ---");
            System.out.println("1) Create internship");
            System.out.println("2) View my internships");
            System.out.println("3) Logout");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            if (c.equals("1")) createInternship();
            else if (c.equals("2")) viewMine();
            else if (c.equals("3")) break;
        }
    }


    private void createInternship() {
        System.out.print("Title: "); String title = scanner.nextLine();
        System.out.print("Description: "); String desc = scanner.nextLine();
        System.out.print("Level (BASIC/INTERMEDIATE/ADVANCED): "); String lvl = scanner.nextLine().trim();
        System.out.print("Preferred Major (or blank): "); String major = scanner.nextLine().trim();
        System.out.print("Opening date (yyyy-MM-dd): "); LocalDate open = LocalDate.parse(scanner.nextLine().trim());
        System.out.print("Closing date (yyyy-MM-dd): "); LocalDate close = LocalDate.parse(scanner.nextLine().trim());
        System.out.print("Slots (1-10): "); int slots = Integer.parseInt(scanner.nextLine().trim());
        InternshipLevel level = InternshipLevel.valueOf(lvl.toUpperCase());
        new CompanyRepController(internshipService).createOpportunity(rep, title, desc, level, major, open, close, slots);
    }


    private void viewMine() {
        if (rep.getInternships().isEmpty()) { System.out.println("No internships created yet."); return; }
        for (InternshipOpportunity i : rep.getInternships()) System.out.println(i);
    }
}