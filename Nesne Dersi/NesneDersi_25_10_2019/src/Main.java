
public class Main {

    public static void main(String[] args) {
        Teacher EsraKaradeniz = new Teacher("Esra", "(Eğitim olarak Ktü-of tas)");
        EsraKaradeniz.addCourse("Java");
        EsraKaradeniz.addCourse("Java");
        EsraKaradeniz.addCourse("Web tasarimi");
        EsraKaradeniz.removeCourse("matematik");
        EsraKaradeniz.removeCourse("Web tasarimi");
        System.out.println(EsraKaradeniz);

        Student Ahmet = new Student("Ahmet Emin ", "Ankara");
        Ahmet.addCourseGrade("Web tasarimi", 60);
        Ahmet.addCourseGrade("Web tasarimi", 45);
        System.out.println(Ahmet.getName() + " not ortalamasi : " + Ahmet.getAverageGrade());
        Student Apo = new Student("Abdullah ", "İzmir");
        System.out.println(Apo.getName() + " not ortalamasi : " + Apo.getAverageGrade());
        Apo.getAverageGrade();
        Student Omer = new Student("Ömer", "İzmit");

        System.out.println(Omer.getName() + " not ortalamasi :");

    }

}
