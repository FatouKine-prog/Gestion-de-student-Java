import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    StudentDAO dao = new StudentDAO();

    try (Scanner sc = new Scanner(System.in)) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter étudiant");
            System.out.println("2. Lister étudiants");
            System.out.println("3. Modifier nom");
            System.out.println("4. Supprimer étudiant");
            System.out.println("5. Quitter");

            int choice = sc.nextInt();
            sc.nextLine(); // éviter le bug scanner

            switch (choice) {
                case 1:
                    System.out.print("Nom : ");
                    String name = sc.nextLine();
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    dao.addStudent(new Student(name, age));
                    break;

                case 2:
                    dao.getAllStudents().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID : ");
                    int idU = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nouveau nom : ");
                    String newName = sc.nextLine();
                    dao.updateStudentName(idU, newName);
                    break;

                case 4:
                    System.out.print("ID : ");
                    int idD = sc.nextInt();
                    dao.deleteStudent(idD);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
}
