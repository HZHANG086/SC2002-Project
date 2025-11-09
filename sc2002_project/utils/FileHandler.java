package utils;

import enums.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class FileHandler {
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static List<Student> readStudents(String path) {
        List<Student> students = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("Student file not found at: " + path);
            return students;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (first) { first = false; continue; }
                String norm = line.replace('\t', ',');
                String[] parts = norm.split(",");
                if (parts.length < 5) continue;
                String id = parts[0].trim();
                String name = parts[1].trim();
                String major = parts[2].trim();
                int year = Integer.parseInt(parts[3].trim());
                String email = parts[4].trim();
                students.add(new Student(id, name, major, year, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<CareerCenterStaff> readStaff(String path) {
        List<CareerCenterStaff> staff = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("Staff file not found at: " + path);
            return staff;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (first) { first = false; continue; }
                String norm = line.replace('\t', ',');
                String[] parts = norm.split(",");
                if (parts.length < 5) continue;
                String id = parts[0].trim();
                String name = parts[1].trim();
                String role = parts[2].trim();
                String dept = parts[3].trim();
                String email = parts[4].trim();
                staff.add(new CareerCenterStaff(id, name, dept, email));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return staff;
    }

    public static List<CompanyRepresentative> readCompanyReps(String path) {
        List<CompanyRepresentative> reps = new ArrayList<>();
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("Company rep file not found at: " + path);
            return reps;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (first) { first = false; continue; }
                String norm = line.replace('\t', ',');
                String[] parts = norm.split(",");
                if (parts.length < 7) continue;
                String id = parts[0].trim();
                String name = parts[1].trim();
                String company = parts[2].trim();
                String dept = parts[3].trim();
                String pos = parts[4].trim();
                String email = parts[5].trim();
                String status = parts[6].trim();
                CompanyRepresentative rep = new CompanyRepresentative(id, name, company, dept, pos, email);
                try { rep.setRegistrationStatus(RequestStatus.valueOf(status.toUpperCase())); } catch (Exception ex) { /* ignore */ }
                reps.add(rep);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return reps;
    }
}