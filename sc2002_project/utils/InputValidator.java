package utils;

public class InputValidator {
    public static boolean isStudentID(String id) {
        return id != null && id.matches("U\\d{7}[A-Za-z]");
    }


    public static boolean isEmail(String s) {
        return s != null && s.contains("@");
    }
}