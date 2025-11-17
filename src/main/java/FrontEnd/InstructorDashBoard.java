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
    

public InstructorDashBoard(BackEnd.Instructor instr) {
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
        create = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        instructorDashboard = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LessonPanel = new javax.swing.JPanel();
        AddLesson = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        DeleteLesson = new javax.swing.JButton();
        ViewEnrolledStudents = new javax.swing.JButton();
        btnRefreshCourses = new javax.swing.JButton();
        btnRefreshLessons = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        create.setBackground(new java.awt.Color(255, 136, 17));
        create.setText("Create Courses");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(255, 136, 17));
        edit.setText("Edit Courses");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 136, 17));
        delete.setText("Delete Courses");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        instructorDashboard.setBackground(new java.awt.Color(255, 136, 17));
        instructorDashboard.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        instructorDashboard.setForeground(new java.awt.Color(255, 255, 255));
        instructorDashboard.setText("Instructor Dashboard");

        javax.swing.GroupLayout coursePanelLayout = new javax.swing.GroupLayout(coursePanel);
        coursePanel.setLayout(coursePanelLayout);
        coursePanelLayout.setHorizontalGroup(
            coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );
        coursePanelLayout.setVerticalGroup(
            coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(coursePanel);

        javax.swing.GroupLayout LessonPanelLayout = new javax.swing.GroupLayout(LessonPanel);
        LessonPanel.setLayout(LessonPanelLayout);
        LessonPanelLayout.setHorizontalGroup(
            LessonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        LessonPanelLayout.setVerticalGroup(
            LessonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(LessonPanel);

        AddLesson.setText("Add Lesson");
        AddLesson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLessonActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Lesson");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DeleteLesson.setText("Delete Lesson");
        DeleteLesson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLessonActionPerformed(evt);
            }
        });

        ViewEnrolledStudents.setText("ViewEnrolled Students");
        ViewEnrolledStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEnrolledStudentsActionPerformed(evt);
            }
        });

        btnRefreshCourses.setText("Refresh Courses");
        btnRefreshCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCoursesActionPerformed(evt);
            }
        });

        btnRefreshLessons.setText("Refresh Lessons");
        btnRefreshLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshLessonsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(instructorDashboard))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(create)
                                    .addComponent(delete))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ViewEnrolledStudents)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DeleteLesson)
                                        .addGap(66, 66, 66)
                                        .addComponent(AddLesson))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edit)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRefreshCourses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefreshLessons)
                                .addGap(94, 94, 94)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(instructorDashboard)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(create)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(jButton2)
                            .addComponent(ViewEnrolledStudents))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddLesson)
                            .addComponent(DeleteLesson))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshLessons))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
      
        String title = JOptionPane.showInputDialog("Course Title:");
String desc = JOptionPane.showInputDialog("Description:");

if (title == null || title.isBlank()) return;

Course c = new Course(title, desc, this.loggedInstructor.getUserId());
courseDB.add(c);
loadCourses();
    }//GEN-LAST:event_createActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        
        selectedCourse = courseList.getSelectedValue();
if (selectedCourse == null) {
    JOptionPane.showMessageDialog(this, "Select a course first.");
    return;
}

String newTitle = JOptionPane.showInputDialog("New Title:", selectedCourse.getTitle());
String newDesc = JOptionPane.showInputDialog("New Description:", selectedCourse.getDescription());

ArrayList<Course> all = courseDB.load();

for (Course c : all) {
    if (c.getCourseId().equals(selectedCourse.getCourseId())) {
        c.setTitle(newTitle);
        c.setDescription(newDesc);
    }
}

courseDB.save(all);
loadCourses();
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
Course sel = courseList.getSelectedValue();
if (sel == null) {
    JOptionPane.showMessageDialog(this, "Select a course first.");
    return;
}

int ok = JOptionPane.showConfirmDialog(this,
        "Delete " + sel.getTitle() + "?",
        "Confirm",
        JOptionPane.YES_NO_OPTION);

if (ok != JOptionPane.YES_OPTION) return;

ArrayList<Course> list = courseDB.load();
list.removeIf(c -> c.getCourseId().equals(sel.getCourseId()));
courseDB.save(list);

loadCourses();
lessonModel.clear();
    }//GEN-LAST:event_deleteActionPerformed

    private void DeleteLessonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLessonActionPerformed
        // TODO add your handling code here:
        Lesson selectedLesson = lessonList.getSelectedValue();

if (selectedCourse == null || selectedLesson == null) {
    JOptionPane.showMessageDialog(this, "Select a lesson first.");
    return;
}

loggedInstructor.deleteLesson(
        selectedCourse.getCourseId(),
        selectedLesson.getLessonId()
);

loadLessons();
    }//GEN-LAST:event_DeleteLessonActionPerformed

    private void AddLessonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLessonActionPerformed
        // TODO add your handling code here:
        if (selectedCourse == null) {
    JOptionPane.showMessageDialog(this, "Select a course first.");
    return;
}

String title = JOptionPane.showInputDialog("Lesson Title:");
String content = JOptionPane.showInputDialog("Lesson Content:");

if (title == null || title.isBlank()) return;

Lesson l = new Lesson(title, content);

loggedInstructor.addLesson(selectedCourse.getCourseId(), l);
loadLessons();
    }//GEN-LAST:event_AddLessonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lesson selectedLesson = lessonList.getSelectedValue();

if (selectedCourse == null || selectedLesson == null) {
    JOptionPane.showMessageDialog(this, "Select a lesson first.");
    return;
}

String newTitle = JOptionPane.showInputDialog("New Title:", selectedLesson.getTitle());
String newContent = JOptionPane.showInputDialog("New Content:", selectedLesson.getContent());

loggedInstructor.editLesson(
        selectedCourse.getCourseId(),
        selectedLesson.getLessonId(),
        newTitle,
        newContent,
        selectedLesson.getLessonId()
);

loadLessons();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ViewEnrolledStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEnrolledStudentsActionPerformed
        // TODO add your handling code here:
        viewEnrolledStudents();
    }//GEN-LAST:event_ViewEnrolledStudentsActionPerformed

    private void btnRefreshCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCoursesActionPerformed
        // TODO add your handling code here:
        loadCourses();
lessonModel.clear();
selectedCourse = null;
    }//GEN-LAST:event_btnRefreshCoursesActionPerformed

    private void btnRefreshLessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshLessonsActionPerformed
        // TODO add your handling code here:
        if (selectedCourse == null) {
    JOptionPane.showMessageDialog(this, "Select a course first.");
    return;
}

loadLessons();
    }//GEN-LAST:event_btnRefreshLessonsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddLesson;
    private javax.swing.JButton DeleteLesson;
    private javax.swing.JPanel LessonPanel;
    private javax.swing.JButton ViewEnrolledStudents;
    private javax.swing.JButton btnRefreshCourses;
    private javax.swing.JButton btnRefreshLessons;
    private javax.swing.JPanel coursePanel;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel instructorDashboard;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
