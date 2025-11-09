package models;

import enums.*;
import java.util.ArrayList;
import java.util.List;


public class CompanyRepresentative extends User {
    private String companyName;
    private String department;
    private String position;
    private RequestStatus registrationStatus = RequestStatus.PENDING;
    private List<InternshipOpportunity> internships = new ArrayList<>();


    public CompanyRepresentative(String userID, String name, String companyName, String department, String position, String email) {
        super(userID, name, email);
        this.companyName = companyName;
        this.department = department;
        this.position = position;
    }


    public String getCompanyName() { return companyName; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    public RequestStatus getRegistrationStatus() { return registrationStatus; }
    public void setRegistrationStatus(RequestStatus s) { this.registrationStatus = s; }
    public List<InternshipOpportunity> getInternships() { return internships; }


    @Override
    public String toString() {
        return String.format("CompanyRep: %s @ %s", name, companyName);
    }
}