
package com.stu.oop.studentcontroller;

import com.stu.oop.model.Student;
import java.util.List;


public interface StudentDao{
    public void save(Student students);
    public void update(Student students);
    public void delete(Student students);
    public Student get(int id);
    public List<Student> list();
    
}