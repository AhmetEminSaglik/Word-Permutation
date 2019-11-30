
public class Student extends Person {

    private int numCourses = 0;
    private String[] Courses;
    private int[] Grades;
    final int MAX_COURSE = 30;

    public Student(String name, String address) {
        super(name, address);
        Grades = new int[MAX_COURSE];
        Courses = new String[MAX_COURSE];

    }

    public int[] getGrades() {
        return Grades;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void addCourseGrade(String courses, int grades) {

        Courses[numCourses] = courses;
        Grades[numCourses] = grades;
        numCourses++;
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(" " + Courses[i] + " :" + Grades[i]);
        }
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public double getAverageGrade() {
        double average = 0;
        for (int i = 0; i < getNumCourses(); i++) {
            average += Grades[i];
        }
        average /= (getNumCourses() + 1);
        return average;
    }

    @Override
    public String toString() {
        return "Student : " + super.toString();
    }

}
