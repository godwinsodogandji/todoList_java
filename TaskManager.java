import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManager implements TaskOperations {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> taskList = new ArrayList<>();
    static int id = 1;

    @Override
    public void addTask() {
        System.out.println("Entrer le titre de la tâche");
        String title = scanner.nextLine();
        Task task = new Task(id++, title);
        taskList.add(task);
        System.out.println(task.getTitle());
    }

    @Override
    public void displayTask() {
        System.out.println("***********+++++Liste des tâches+++++++++++***********");
        for (Task task : taskList) {
            System.out.println(task.getTitle());
        }

    }

    public void sauvegarder(ArrayList<Task> tasks) {
        String tasksFil = "tasks.txt";
        // ecriture dans le fichier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tasksFil))) {
            writer.write(tasks.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n *****************Task Management System****************");
            System.out.println("\n ----Choisir une option------");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display All Tasks");
            System.out.println("5. Display Task by id");
            System.out.println("5. Exit");
            System.out.println("NB: Le 2 et le 4 en cours de développement");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addTask();
                    sauvegarder(taskList);
                    break;
                case 2:
                    System.out.println("Choix invalid, réessayer");
                    break;
                case 3:
                    displayTask();
                    break;
                case 4:
                    System.out.println("Choix invalid, réessayer");
                    break;
                case 5:
                    System.out.println("Exiting.........");
                    return;

                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.menu();

    }

}
