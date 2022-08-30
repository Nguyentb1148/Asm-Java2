package Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // checking name when user input
    public static void checkName(JTextField field, StringBuilder stringBuilder) {
        // create variable validate for update status
        boolean isValidate = true;
        if (!checkEmpty(field, stringBuilder, "Name is not empty!")) {
            return;
        }
        try {
            String name = field.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();

            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    stringBuilder.append("Name does not contain number!\n");
                    field.setBorder((Border) Color.red);
                 break;
                }
            }
            // for special characters
            if (isSpecial) {
                stringBuilder.append("Name does not contain special characters!\n");
                field.setBorder((Border) Color.red);
            }
        } catch (Exception e) {
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }
        if (isValidate) {
            field.setBackground(Color.white);
        }
    }

    public static boolean checkEmpty(JTextField field, StringBuilder stringBuilder, String message) {
        boolean isValidate = true;
        if (field.getText().equals("")) {
            stringBuilder.append(message).append("\n");
            field.setBackground(new Color(214, 0, 0, 116));
            isValidate = false;
        } else {
            field.setBackground(Color.white);
        }
        return isValidate;
    }
    public static boolean checkId(JTextField field, StringBuilder stringBuilder) {
        // create variable validate for update status
        boolean isValidate = true;
        if (!checkEmpty(field, stringBuilder, "Id is not empty!")) {
            return false;
        }
        try {
            String name = field.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();
            // for special characters
            if (isSpecial) {
                stringBuilder.append("id does not contain special characters!\n");
                field.setBorder((Border) Color.red);
            }
        } catch (Exception e) {
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }
        if (isValidate) {
            field.setBackground(Color.white);
        }
        return isValidate;
    }
}
