package com.company.sprint6;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Student person = new Student("Vlad", "NULP", 4);
        Student person1 = new Student("Oleg", "NULP", 4);
        Worker person2 = new Worker("Vlad", "Junior", 4);
        Worker person5 = new Worker("Oleg", "Junior", 5);
        Worker person3 = new Worker("Oleg", "Junior", 5);

        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person5);
        list.add(new Person("ANDRII"));

        System.out.println(MyUtils.maxDuration(list));

    }
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

class Student extends Person implements Comparable<Student>{
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public int compareTo(Student student) {
        return studyYears - student.getStudyYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (studyYears != student.studyYears) return false;
        return studyPlace != null ? studyPlace.equals(student.studyPlace) : student.studyPlace == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (studyPlace != null ? studyPlace.hashCode() : 0);
        result = 31 * result + studyYears;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", studyPlace='").append(studyPlace).append('\'');
        sb.append(", studyYears=").append(studyYears);
        sb.append('}');
        return sb.toString();
    }
}

class Worker extends Person implements Comparable<Worker> {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public int compareTo(Worker worker) {
        return experienceYears - worker.getExperienceYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;

        if (experienceYears != worker.experienceYears) return false;
        return workPosition != null ? workPosition.equals(worker.workPosition) : worker.workPosition == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (workPosition != null ? workPosition.hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + experienceYears;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worker{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", workPosition='").append(workPosition).append('\'');
        sb.append(", experienceYears=").append(experienceYears);
        sb.append('}');
        return sb.toString();
    }
}

class MyUtils {
    public static List<Person> maxDuration(List<Person> persons) {
        List<Person> peoples = persons;
        List<Person> res = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();

        for(Person person : peoples){
            if(person instanceof Student){
                students.add( (Student)person);
            }
            else if(person instanceof Worker){
                workers.add((Worker) person);
            }
            else {
                continue;
            }
        }

        for(Student std : students)
            if (std.getStudyYears() == Collections.max(students).getStudyYears())
                res.add(std);

        for(Worker wrk : workers)
            if (wrk.getExperienceYears() == Collections.max(workers).getExperienceYears())
                res.add(wrk);

        Set<Person> set = new HashSet<>(res);
        List<Person> result = new ArrayList<>(set);
        return result;
    }
}
