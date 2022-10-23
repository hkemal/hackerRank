package com.hkemal.java.dataStructures;

import java.util.*;

public class B6_JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student {

    private int id;

    private String name;

    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    private final PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCGPA).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getID));

    public List<Student> getStudents(List<String> events) {
        events.forEach(item -> {
            if (item.equals("SERVED")) {
                queue.poll();
            } else {
                List<String> strings = Arrays.asList(item.split(" "));
                Student student = new Student(Integer.parseInt(strings.get(3)), strings.get(1), Double.parseDouble(strings.get(2)));
                queue.add(student);
            }
        });
        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}
