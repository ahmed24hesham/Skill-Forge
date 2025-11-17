/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import BackEnd.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class InstructorDashBoard extends JPanel { 
//private JList<Course> courseList;
//private BackEnd.InstructorDashBoard loggedInstructor;
//private CourseDB courseDB = new CourseDB("courses.json");
//private DefaultListModel<Course> courseModel = new DefaultListModel<>();
//private JList<Lesson> lessonList;
//private DefaultListModel<Lesson> lessonModel = new DefaultListModel<>();
//    
    private BackEnd.Instructor loggedInstructor;
    private CourseDB courseDB = new CourseDB("courses.json");
    private InstructorDB instructorDB = new InstructorDB("user.json");

    private DefaultListModel<Course> courseModel = new DefaultListModel<>();
    private DefaultListModel<Lesson> lessonModel = new DefaultListModel<>();

private Course selectedCourse;
private JList<Course> courseList;
private JList<Lesson> lessonList;
    
//  public void InstructorDashboard(BackEnd.InstructorDashBoard instr ) {
//    initComponents();
//
//    // Create lesson list manually
//    lessonList = new JList<>(lessonModel);
//
//    lessonPanel.setLayout(new BorderLayout());
//    lessonPanel.add(new JScrollPane(lessonList), BorderLayout.CENTER);
//
//    loadCourses();
//}
    

public InstructorDashBoard(String username) {
    
    this.loggedInstructor = instr;
    initComponents();

    // Create lists manually and attach them into your panels
    courseList = new JList<>(courseModel);
    lessonList = new JList<>(lessonModel);

    // Add to panels created in NetBeans
    coursePanel.setLayout(new BorderLayout());
    coursePanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

    LessonPanel.setLayout(new BorderLayout());
    LessonPanel.add(new JScrollPane(lessonList), BorderLayout.CENTER);

    // When selecting a course → load lessons
    courseList.addListSelectionListener(e -> {
        selectedCourse = courseList.getSelectedValue();
        loadLessons();
    });

    loadCourses();
}

private void loadCourses() {
    courseModel.clear();
    ArrayList<Course> list = courseDB.load();

    for (Course c : list) {
        if (c.getInstructorId().equals(loggedInstructor.getUserId())) {
            courseModel.addElement(c);
        }
    }
}


private void loadLessons() {
    lessonModel.clear();

    if (selectedCourse == null) return;

    for (Lesson l : selectedCourse.getLessons()) {
        lessonModel.addElement(l);
    }
}


//     public void InstructorDashboard(BackEnd.InstructorDashBoard instr) {
//        this.loggedInstructor = instr;
//        setLayout(new BorderLayout());
//
//        initUI();
//        loadCourses();
//    }
//     public void setInstructor(InstructorDashBoard instr) {
//        this.loggedInstructor = instr;
//        loadCourses();
//    }

     
  private void viewEnrolledStudents() {

    if (selectedCourse == null) {
        JOptionPane.showMessageDialog(this, "Select a course first.");
        return;
    }

    ArrayList<String> students = selectedCourse.getStudents();

    if (students.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No students enrolled in this course.");
        return;
    }

    // Build output
    StringBuilder sb = new StringBuilder("Enrolled Students:\n\n");
    for (String s : students) {
        sb.append("- ").append(s).append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
