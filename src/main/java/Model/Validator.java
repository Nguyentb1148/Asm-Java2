package Model;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // checking name when user input
    public static boolean checkName(JTextField feild, StringBuilder stringBuilder) {
        // create variable validata for update status
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Name is not empty!")) {
            return false;
        }

        try {
            String name = feild.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();

            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    stringBuilder.append("Name does not contain number!\n");
                    feild.setText("");
                    if (!checkEmpty(feild, stringBuilder, "Name is not empty!")) {
                        feild.setBackground(Color.green);
                        return false;
                    }
                 break;
                }
            }
            // for special characters
            if (isSpecial) {
                stringBuilder.append("Name does not contain special characters!\n");
                feild.setBackground(new Color(214, 0, 0, 116));
            }

            if (name.startsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setBackground(new Color(214, 0, 0, 116));
            }

        } catch (Exception e) {
            stringBuilder.append("Name must be a string!\n");
            feild.setBackground(new Color(204, 0, 0, 21));
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }

    public static boolean checkEmpty(JTextField feild, StringBuilder stringBuilder, String message) {
        boolean isValidate = true;
        if (feild.getText().equals("")) {
            stringBuilder.append(message).append("\n");
            feild.setBackground(new Color(214, 0, 0, 116));
            isValidate = false;
        } else {
            feild.setBackground(Color.white);
        }
        return isValidate;
    }

    public void checkIsCorrect(JTextField feild, StringBuilder stringBuilder, String message) {
        if (!feild.getText().isBlank()) {
            feild.setBackground(new Color(255, 255, 255, 255));
        }
    }

    public static boolean checkId(JTextField feild, StringBuilder stringBuilder) {
        // create variable validate for update status
        boolean isValidate = true;

        if (!checkEmpty(feild, stringBuilder, "Id is not empty!")) {
            return false;
        }

        try {
            String name = feild.getText();
            Pattern pattern = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matcher = pattern.matcher(name);
            boolean isSpecial = matcher.find();

            // for special characters
            if (isSpecial) {
                stringBuilder.append("id does not contain special characters!");
                feild.setBackground(new Color(214, 0, 0, 116));
            }

            if (name.startsWith(" ")) {
                stringBuilder.append("Please remove space!\n");
                feild.setBackground(new Color(214, 0, 0, 116));
            }

        } catch (Exception e) {
            stringBuilder.append("id must be a string!");
            feild.setBackground(new Color(204, 0, 0, 21));
            System.out.println("Name error: " + e.getMessage());
            isValidate = false;
        }

        if (isValidate) {
            feild.setBackground(Color.white);
        }

        return isValidate;
    }
}
