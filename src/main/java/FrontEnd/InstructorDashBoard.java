package FrontEnd;

/**
 *
 * @author Asus
 */

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
    private String loggedInstructor;
    private String username ;
    private CourseDB courseDB = new CourseDB("courses.json");
    private InstructorDB instructorDB = new InstructorDB("users.json");

    private DefaultListModel<Course> courseModel = new DefaultListModel<>();
    private DefaultListModel<Lesson> lessonModel = new DefaultListModel<>();
    private ArrayList<Instructor> list =instructorDB.load();

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
    

public InstructorDashBoard(String username ) {
    this.username = username ;
   

                    // Prevent duplicate usernames
        for (Instructor i : list) {
            if (i.getUsername().trim().equals(username)) {
                this.loggedInstructor=i.getUserId();
            }}
                
    initComponents();

    // Create lists manually and attach them into your panels
    courseList = new JList<>(courseModel);
    lessonList = new JList<>(lessonModel);

    // Add to panels created in NetBeans
    LessonPanel.setLayout(new BorderLayout());
    LessonPanel.add(new JScrollPane(courseList), BorderLayout.CENTER);

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
        if (c.getInstructorId().equals(loggedInstructor)) {
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
        coursePanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        LessonPanel = new javax.swing.JScrollPane();
        create = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        btnRefreshCourses = new javax.swing.JButton();
        AddLesson = new javax.swing.JButton();
        DeleteLesson = new javax.swing.JButton();
        btnRefreshLessons = new javax.swing.JButton();
        ViewEnrolledStudents = new javax.swing.JButton();
        editLesson = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coursePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coursePanel))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LessonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LessonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        create.setText("Add Course ");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        delete.setText("Delete Course ");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        edit.setText("Edit Course ");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        btnRefreshCourses.setText("Refresh ");
        btnRefreshCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCoursesActionPerformed(evt);
            }
        });

        AddLesson.setText("Add Lesson");
        AddLesson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLessonActionPerformed(evt);
            }
        });

        DeleteLesson.setText("Delete Lesson");
        DeleteLesson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLessonActionPerformed(evt);
            }
        });

        btnRefreshLessons.setText("Refresh Lessons");
        btnRefreshLessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshLessonsActionPerformed(evt);
            }
        });

        ViewEnrolledStudents.setText("View Enrolled Students");
        ViewEnrolledStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEnrolledStudentsActionPerformed(evt);
            }
        });

        editLesson.setText("Edit Lesson");
        editLesson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLessonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(create)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefreshCourses)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete)
                                .addGap(18, 18, 18)
                                .addComponent(edit)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddLesson)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteLesson)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshLessons))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ViewEnrolledStudents)
                        .addGap(18, 18, 18)
                        .addComponent(editLesson)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(create)
                            .addComponent(delete)
                            .addComponent(edit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddLesson)
                            .addComponent(DeleteLesson)
                            .addComponent(btnRefreshLessons))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefreshCourses)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ViewEnrolledStudents)
                        .addComponent(editLesson)))
                .addGap(0, 41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        String title = JOptionPane.showInputDialog("Course Title:");
String desc = JOptionPane.showInputDialog("Description:");

if (title == null || title.isBlank()) return;

Course c = new Course(title, desc, this.loggedInstructor);
courseDB.add(c);
loadCourses();
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
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

    private void btnRefreshCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCoursesActionPerformed
        // TODO add your handling code here:
        loadCourses();
lessonModel.clear();
selectedCourse = null;
        
    }//GEN-LAST:event_btnRefreshCoursesActionPerformed

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
for (Instructor i : list) {
            if (i.getUsername().trim().equals(username)) {
                i.addLesson(selectedCourse.getCourseId(), l);
            }}
loadLessons();
    }//GEN-LAST:event_AddLessonActionPerformed

    private void DeleteLessonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLessonActionPerformed
        // TODO add your handling code here:
        Lesson selectedLesson = lessonList.getSelectedValue();

if (selectedCourse == null || selectedLesson == null) {
    JOptionPane.showMessageDialog(this, "Select a lesson first.");
    return;
}

for (Instructor i : list) {
            if (i.getUsername().trim().equals(username)) {
                i.deleteLesson(
        selectedCourse.getCourseId(),
        selectedLesson.getLessonId()
);
            }}

loadLessons();
    }//GEN-LAST:event_DeleteLessonActionPerformed

    private void btnRefreshLessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshLessonsActionPerformed
        // TODO add your handling code here:
         if (selectedCourse == null) {
    JOptionPane.showMessageDialog(this, "Select a course first.");
    return;
}

loadLessons();
    }//GEN-LAST:event_btnRefreshLessonsActionPerformed

    private void ViewEnrolledStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEnrolledStudentsActionPerformed
        // TODO add your handling code here:
        viewEnrolledStudents();
    }//GEN-LAST:event_ViewEnrolledStudentsActionPerformed

    private void editLessonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLessonActionPerformed
        // TODO add your handling code here: Lesson selectedLesson = lessonList.getSelectedValue();
Lesson selectedLesson = lessonList.getSelectedValue();
if (selectedCourse == null || selectedLesson == null) {
    JOptionPane.showMessageDialog(this, "Select a lesson first.");
    return;
}

String newTitle = JOptionPane.showInputDialog("New Title:", selectedLesson.getTitle());
String newContent = JOptionPane.showInputDialog("New Content:", selectedLesson.getContent());

for (Instructor i : list) {
            if (i.getUsername().trim().equals(username)) {
                i.editLesson(
        selectedCourse.getCourseId(),
        selectedLesson.getLessonId(),
        newTitle,
        newContent,
        selectedLesson.getLessonId()
);
            }}

loadLessons();
    }//GEN-LAST:event_editLessonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddLesson;
    private javax.swing.JButton DeleteLesson;
    private javax.swing.JScrollPane LessonPanel;
    private javax.swing.JButton ViewEnrolledStudents;
    private javax.swing.JButton btnRefreshCourses;
    private javax.swing.JButton btnRefreshLessons;
    private javax.swing.JScrollPane coursePanel;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton editLesson;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
