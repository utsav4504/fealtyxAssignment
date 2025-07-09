package com.fealtyx.fealtyx.service;

import com.fealtyx.fealtyx.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {
    private final Map<Integer, Student> studentMap = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Student createStudent(Student student) {
        int id = idCounter.getAndIncrement();
        student.setId(id);
        studentMap.put(id, student);
        return student;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Optional<Student> getStudentById(int id) {
        return Optional.ofNullable(studentMap.get(id));
    }

    public Optional<Student> updateStudent(int id, Student updatedStudent) {
        if (studentMap.containsKey(id)) {
            updatedStudent.setId(id);
            studentMap.put(id, updatedStudent);
            return Optional.of(updatedStudent);
        }
        return Optional.empty();
    }

    public boolean deleteStudent(int id) {
        return studentMap.remove(id) != null;
    }
}

