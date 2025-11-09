import java.util.List;
import models.*;
import services.*;
import utils.*;
import views.*;


public class Main {
    public static void main(String[] args) {
        String studentPath = "data/sample_student_list.txt";
        String staffPath = "data/sample_staff_list.txt";
        String companyPath = "data/sample_company_representative_list.txt";


        List<Student> students = FileHandler.readStudents(studentPath);
        List<CareerCenterStaff> staff = FileHandler.readStaff(staffPath);
        List<CompanyRepresentative> reps = FileHandler.readCompanyReps(companyPath);


        UserService userService = new UserService();
        InternshipService internshipService = new InternshipService();
        ApplicationService applicationService = new ApplicationService();
        WithdrawalService withdrawalService = new WithdrawalService();


        // populate users
        for (Student s : students) userService.addUser(s);
        for (CareerCenterStaff c : staff) userService.addUser(c);
        for (CompanyRepresentative r : reps) userService.addUser(r);


        System.out.println("Loaded: " + students.size() + " students, " + staff.size() + " staff, " + reps.size() + " company reps.");


        MenuView menu = new MenuView(userService, internshipService, applicationService, withdrawalService);
        menu.showMainMenu();
    }
}