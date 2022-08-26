/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

//import ManageStudent.Student;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tranbaonguyen
 */
public class StudentList {

//        String path = "C:\\Users\\dell\\OneDrive\\Máy tính\\Data.txt";
//        String path ="/Users/tranbaonguyen/Desktop/Data.txt";

        List<Student> studentList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

        public Student getStudentByEmail(String email) {
                for (Student sv : studentList) {
                        if (sv.getEmail().equalsIgnoreCase(email)) {
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

//        public void saveToFile() throws IOException {
//                HandleFile.writeObject(path, studentList);
//        }
//
//        public void loadFormFile() throws IOException,
//                ClassNotFoundException {
//                File file = new File(path);
//
//                if (file.exists()) {
//                        studentList = (ArrayList<Student>) HandleFile.readObj(path);
//                }
//        }
        public void updateDataTable(DefaultTableModel tbM) {
                for (Student sv : studentList) {
                        Object[] rowData = new Object[7];
                        rowData[0] = sv.getIdPerson();
                        rowData[1] = sv.getName();
                        rowData[2] = dateFormat.format(sv.getBirthday());
                        rowData[3]= sv.getEmail();
                        rowData[4]=sv.getPhoneNumber();
                        rowData[5] = sv.getSex() ? "Male" : "Female";
                        rowData[6] = sv.getAddress();
                        tbM.addRow(rowData);
                }
                tbM.fireTableDataChanged();
        }
}
