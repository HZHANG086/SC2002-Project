package models;

import enums.*;
import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private int year;
    private String major;
    private List<Application> applications = new ArrayList<>();
    private Application acceptedApplication = null;


    public Student(String userID, String name, String major, int year, String email) {
        super(userID, name, email);
        this.major = major;
        this.year = year;
    }


    public int getYear() { return year; }
    public String getMajor() { return major; }
    public List<Application> getApplications() { return applications; }
    public Application getAcceptedApplication() { return acceptedApplication; }
    public void setAcceptedApplication(Application a) { this.acceptedApplication = a; }


    public boolean canApplyForLevel(InternshipLevel level) {
        if (year <= 2) {
        return level == InternshipLevel.BASIC;
        }
    return true;
    }


    public boolean hasReachedApplicationLimit() {
        int active = 0;
        for (Application a : applications) {
            if (a.getStatus() == ApplicationStatus.PENDING || a.getStatus() == ApplicationStatus.SUCCESSFUL) active++;
        }
        return active >= 3;
    }


    @Override
    public String toString() {
        return String.format("Student: %s, %s, Year %d", name, major, year);
    }
}