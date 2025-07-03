import java.util.Scanner;

public class TaskScheduler {
    class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private Task head = null;
    private Task current = null;
    private int size = 0;

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            current = head;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
            if (current == null) {
                current = head;
            }
        }
        size++;
        System.out.println("Task added at beginning successfully!");
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            current = head;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            if (current == null) {
                current = head;
            }
        }
        size++;
        System.out.println("Task added at end successfully!");
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }

        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        if (position == size) {
            addTaskAtEnd(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        size++;
        System.out.println("Task added at position " + position + " successfully!");
    }

    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        if (size == 1 && head.taskId == taskId) {
            head = null;
            current = null;
            size = 0;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (current == temp) {
                        current = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (current == temp) {
                        current = temp.next;
                    }
                }
                size--;
                System.out.println("Task with ID " + taskId + " removed successfully!");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found!");
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        System.out.println("Current Task:");
        System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
    }

    public void moveToNextTask() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        current = current.next;
        System.out.println("Moved to next task:");
        viewCurrentTask();
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        System.out.println("All Tasks:");
        Task temp = head;
        int count = 1;
        do {
            System.out.println(count + ". Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
            count++;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with priority " + priority + ":");
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n=== Task Scheduler ===");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search Task by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    int priority1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate1 = scanner.nextLine();
                    scheduler.addTaskAtBeginning(id1, name1, priority1, dueDate1);
                    break;

                case 2:
                    System.out.print("Enter task ID: ");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    int priority2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate2 = scanner.nextLine();
                    scheduler.addTaskAtEnd(id2, name2, priority2, dueDate2);
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int id3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    int priority3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate3 = scanner.nextLine();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    scheduler.addTaskAtPosition(id3, name3, priority3, dueDate3, position);
                    break;

                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scheduler.removeTaskById(idToRemove);
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.moveToNextTask();
                    break;

                case 7:
                    scheduler.displayAllTasks();
                    break;

                case 8:
                    System.out.print("Enter priority to search: ");
                    int priorityToSearch = scanner.nextInt();
                    scheduler.searchTaskByPriority(priorityToSearch);
                    break;

                case 9:
                    System.out.println("Exiting Task Scheduler...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
