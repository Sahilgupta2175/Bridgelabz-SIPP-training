import java.util.Scanner;

public class RoundRobinScheduler {
    class Process {
        int processId;
        int burstTime;
        int priority;
        int remainingTime;
        int waitingTime;
        int turnaroundTime;
        int completionTime;
        Process next;

        public Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            this.remainingTime = burstTime;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
            this.completionTime = 0;
            this.next = null;
        }
    }

    private Process head = null;
    private Process current = null;
    private int size = 0;
    private int timeQuantum = 2;
    private int totalTime = 0;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            current = head;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
            if (current == null) {
                current = head;
            }
        }
        size++;
        System.out.println("Process " + processId + " added successfully!");
    }

    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        if (size == 1 && head.processId == processId) {
            head = null;
            current = null;
            size = 0;
            System.out.println("Process " + processId + " removed successfully!");
            return;
        }

        Process temp = head;
        Process prev = null;

        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    Process last = head;
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
                System.out.println("Process " + processId + " removed successfully!");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Process " + processId + " not found!");
    }

    public void setTimeQuantum(int quantum) {
        this.timeQuantum = quantum;
        System.out.println("Time quantum set to: " + quantum);
    }

    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        System.out.println("\n=== Round Robin Scheduling Simulation ===");
        System.out.println("Time Quantum: " + timeQuantum);
        totalTime = 0;

        Process temp = head;
        int completedProcesses = 0;
        int[] processCompletionOrder = new int[size];
        int orderIndex = 0;

        while (completedProcesses < size) {
            if (temp.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, temp.remainingTime);
                temp.remainingTime -= executionTime;
                totalTime += executionTime;

                System.out.println("Process " + temp.processId + " executed for " + executionTime
                        + " units. Remaining time: " + temp.remainingTime);

                if (temp.remainingTime == 0) {
                    temp.completionTime = totalTime;
                    temp.turnaroundTime = temp.completionTime;
                    temp.waitingTime = temp.turnaroundTime - temp.burstTime;
                    processCompletionOrder[orderIndex++] = temp.processId;
                    completedProcesses++;
                    System.out.println("Process " + temp.processId + " completed!");
                }
            }
            temp = temp.next;
        }

        System.out.println("\nExecution completed!");
        displayProcessDetails();
        calculateAverageTime();
    }

    public void displayProcessDetails() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        System.out.println("\n=== Process Details ===");
        System.out.println("PID\tBurst\tPriority\tWaiting\tTurnaround\tCompletion");
        System.out.println("-----------------------------------------------------------");

        Process temp = head;
        do {
            System.out.println(temp.processId + "\t" + temp.burstTime + "\t" + temp.priority + "\t\t" +
                    temp.waitingTime + "\t" + temp.turnaroundTime + "\t\t" + temp.completionTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void calculateAverageTime() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        Process temp = head;
        do {
            totalWaitingTime += temp.waitingTime;
            totalTurnaroundTime += temp.turnaroundTime;
            temp = temp.next;
        } while (temp != head);

        double avgWaitingTime = totalWaitingTime / size;
        double avgTurnaroundTime = totalTurnaroundTime / size;

        System.out.println("\n=== Average Times ===");
        System.out.println("Average Waiting Time: " + String.format("%.2f", avgWaitingTime));
        System.out.println("Average Turnaround Time: " + String.format("%.2f", avgTurnaroundTime));
    }

    public void displayProcessQueue() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        System.out.println("Current process queue:");
        Process temp = head;
        int count = 1;
        do {
            System.out.println(count + ". Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                    ", Priority: " + temp.priority + ", Remaining Time: " + temp.remainingTime);
            temp = temp.next;
            count++;
        } while (temp != head);
    }

    public void resetProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        Process temp = head;
        do {
            temp.remainingTime = temp.burstTime;
            temp.waitingTime = 0;
            temp.turnaroundTime = 0;
            temp.completionTime = 0;
            temp = temp.next;
        } while (temp != head);

        totalTime = 0;
        System.out.println("All processes reset successfully!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\n=== Round Robin Scheduling Algorithm ===");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Set Time Quantum");
            System.out.println("4. Simulate Scheduling");
            System.out.println("5. Display Process Queue");
            System.out.println("6. Display Process Details");
            System.out.println("7. Calculate Average Times");
            System.out.println("8. Reset Processes");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter process ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter burst time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(id, burstTime, priority);
                    break;

                case 2:
                    System.out.print("Enter process ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scheduler.removeProcess(idToRemove);
                    break;

                case 3:
                    System.out.print("Enter time quantum: ");
                    int quantum = scanner.nextInt();
                    scheduler.setTimeQuantum(quantum);
                    break;

                case 4:
                    scheduler.simulateScheduling();
                    break;

                case 5:
                    scheduler.displayProcessQueue();
                    break;

                case 6:
                    scheduler.displayProcessDetails();
                    break;

                case 7:
                    scheduler.calculateAverageTime();
                    break;

                case 8:
                    scheduler.resetProcesses();
                    break;

                case 9:
                    System.out.println("Exiting Round Robin Scheduler...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
