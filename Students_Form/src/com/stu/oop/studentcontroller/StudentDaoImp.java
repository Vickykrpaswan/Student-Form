
package com.stu.oop.studentcontroller;

import java.sql.ResultSet;
import com.stu.oop.model.Student;
import com.stu.oop.studentdb.StudentDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class StudentDaoImp implements StudentDao{

    @Override
    public void save(Student students) {
        try {
            Connection con = StudentDb.getConnection();
            String sql = "INSERT INTO students(sname,scourse,sfee) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, students.getSname());
            ps.setString(2, students.getScourse());
            ps.setInt(3, students.getSfee());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Student students){
        try {
          
            Connection con = StudentDb.getConnection();
            String sql = "UPDATE students SET sname=?,scourse=?,sfee=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, students.getSname());
            ps.setString(2, students.getScourse());
            ps.setInt(3, students.getSfee());
            ps.setInt(4, students.getId());
            ps.executeUpdate();
 
        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void delete(Student students) {
        try {
          
            Connection con = StudentDb.getConnection();
            String sql = "delete from students  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, students.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Student get(int id) {
        Student st = new Student();
        try {
            Connection con = StudentDb.getConnection();
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setId(rs.getInt("id"));
                st.setSname(rs.getString("sname"));
                st.setScourse(rs.getString("scourse"));
                st.setSfee(rs.getInt("sfee"));
 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    @Override
    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = StudentDb.getConnection();
            String sql = "SELECT * FROM students ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            
            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSname(rs.getString("sname"));
                st.setScourse(rs.getString("scourse"));
                st.setSfee(rs.getInt("sfee"));
 
                list.add(st);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
