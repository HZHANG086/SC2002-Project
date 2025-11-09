package models;

import enums.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class InternshipOpportunity {
    private static int counter = 1;
    private String id;
    private String title;
    private String description;
    private InternshipLevel level;
    private String preferredMajor;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private OpportunityStatus status = OpportunityStatus.PENDING;
    private String companyName;
    private CompanyRepresentative repInCharge;
    private int slots;
    private boolean visible = false;
    private List<Application> applicants = new ArrayList<>();


    public InternshipOpportunity(String title, String description, InternshipLevel level, String preferredMajor, LocalDate opening, LocalDate closing, String companyName, CompanyRepresentative rep, int slots) {
        this.id = String.format("INT%04d", counter++);
        this.title = title;
        this.description = description;
        this.level = level;
        this.preferredMajor = preferredMajor;
        this.openingDate = opening;
        this.closingDate = closing;
        this.companyName = companyName;
        this.repInCharge = rep;
        this.slots = slots;
    }


    public String getId() { return id; }
    public String getTitle() { return title; }
    public InternshipLevel getLevel() { return level; }
    public String getPreferredMajor() { return preferredMajor; }
    public LocalDate getOpeningDate() { return openingDate; }
    public LocalDate getClosingDate() { return closingDate; }
    public OpportunityStatus getStatus() { return status; }
    public void setStatus(OpportunityStatus s) { this.status = s; }
    public String getCompanyName() { return companyName; }
    public CompanyRepresentative getRepInCharge() { return repInCharge; }
    public int getSlots() { return slots; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean v) { this.visible = v; }
    public List<Application> getApplicants() { return applicants; }


    public int confirmedSlots() {
        int c = 0;
        for (Application a : applicants) if (a.getStatus() == ApplicationStatus.SUCCESSFUL && a.isAccepted()) c++;
        return c;
    }


    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s - %s to %s - %s slots - %s",
                id, title, level, companyName, openingDate, closingDate, slots, status);
    }
}