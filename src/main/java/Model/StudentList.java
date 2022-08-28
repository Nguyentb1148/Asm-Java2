/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import ManageStudent.Student;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tranbaonguyen
 */
public class StudentList implements Serializable {
    List<Student> studentList = new ArrayList<>();
    public int add(Student sv) {
        studentList.add(sv);
        return 1;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public int deleteStudentById(String maStudent) {
        for (Student sv : studentList) {
            if (sv.getIdPerson().equalsIgnoreCase(maStudent)) {
                studentList.remove(sv);
                return 1;
            }
        }
        return -1;
    }
    public Student getStudentById(String id) {
        for (Student sv : studentList) {
            if (sv.getIdPerson().equalsIgnoreCase(id)) {
                return sv;
            }
        }
        return null;
    }
    public int updateStudentById(Student student) {
        for (Student sv : studentList) {
            if (sv.getIdPerson().equalsIgnoreCase(student.getIdPerson())) {
                sv.setName(student.getName());
                sv.setBirthday(student.getBirthday());
                sv.setSex(student.getSex());
                sv.setAddress(student.getAddress());
                return 1;
            }
        }
        return -1;
    }
}
