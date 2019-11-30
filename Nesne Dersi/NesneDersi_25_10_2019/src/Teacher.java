
public class Teacher extends Person {

    private int numCourses = 0;
    private String[] courses;

    final int MAX_COURSE = 5;

    public Teacher(String name, String address) {
        super(name, address);
        courses = new String[MAX_COURSE];

    }

    public boolean addCourse(String course) {

        for (int i = 0; i < getNumCourses(); i++) {
            if (courses[i].equals(course)) {
                System.out.println("Böyle bir ders zaten varmış");
                return false;
            }

            courses[numCourses] = course;
            numCourses++;
            return true;
        }

        System.out.println("Bu returne kalmamasi gerekiyor --> addCourse");
        return true;
    }

    public boolean removeCourse(String course) {
        boolean found = false;
        int courseIndex = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            for (int i = courseIndex; i < numCourses - 1; i++) {
                courses[i] = courses[i + 1];

            }
            numCourses--;
            return true;
        }
        return false;
    }

    /*
    public boolean removeCourse(String course) {
        for (int i = 0; i < getNumCourses(); i++) {
            if (getCourses()[i].equals(course)) {
                removeCourses(i);
                System.out.println("Böyle bir ders varmış ve kaldırıldı");
                return true;
            }
        }
        System.out.println("Böyle bir ders zaten yokmuş");
        return true;
    }*/
    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public String[] getCourses() {
        return courses;
    }

    public void removeCourses(int numCourse) {
        this.courses[numCourse] = "";
    }

    public void setCourses(String courses) {

        this.courses[getNumCourses()] = courses;
        setNumCourses(numCourses + 1);
    }

    @Override
    public String toString() {
        return "Teacher : " + super.toString();
    }

}
