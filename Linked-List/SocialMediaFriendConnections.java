import java.util.Scanner;

public class SocialMediaFriendConnections {
    class FriendNode {
        int friendId;
        FriendNode next;

        public FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    class User {
        int userId;
        String name;
        int age;
        FriendNode friendList;
        User next;

        public User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendList = null;
            this.next = null;
        }
    }

    private User head = null;

    public void addUser(int userId, String name, int age) {
        if (findUserById(userId) != null) {
            System.out.println("User with ID " + userId + " already exists!");
            return;
        }

        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User " + name + " added successfully!");
    }

    public User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null) {
            System.out.println("User with ID " + userId1 + " not found!");
            return;
        }

        if (user2 == null) {
            System.out.println("User with ID " + userId2 + " not found!");
            return;
        }

        if (userId1 == userId2) {
            System.out.println("A user cannot be friends with themselves!");
            return;
        }

        if (areFriends(user1, userId2)) {
            System.out.println("Users are already friends!");
            return;
        }

        FriendNode friend1 = new FriendNode(userId2);
        friend1.next = user1.friendList;
        user1.friendList = friend1;

        FriendNode friend2 = new FriendNode(userId1);
        friend2.next = user2.friendList;
        user2.friendList = friend2;

        System.out.println("Friend connection established between " + user1.name + " and " + user2.name);
    }

    public boolean areFriends(User user, int friendId) {
        FriendNode temp = user.friendList;
        while (temp != null) {
            if (temp.friendId == friendId) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null) {
            System.out.println("User with ID " + userId1 + " not found!");
            return;
        }

        if (user2 == null) {
            System.out.println("User with ID " + userId2 + " not found!");
            return;
        }

        if (!areFriends(user1, userId2)) {
            System.out.println("Users are not friends!");
            return;
        }

        removeFriendFromList(user1, userId2);
        removeFriendFromList(user2, userId1);

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    private void removeFriendFromList(User user, int friendId) {
        if (user.friendList == null) {
            return;
        }

        if (user.friendList.friendId == friendId) {
            user.friendList = user.friendList.next;
            return;
        }

        FriendNode temp = user.friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null) {
            System.out.println("User with ID " + userId1 + " not found!");
            return;
        }

        if (user2 == null) {
            System.out.println("User with ID " + userId2 + " not found!");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");

        FriendNode temp1 = user1.friendList;
        boolean foundMutual = false;

        while (temp1 != null) {
            if (areFriends(user2, temp1.friendId)) {
                User mutualFriend = findUserById(temp1.friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
                    foundMutual = true;
                }
            }
            temp1 = temp1.next;
        }

        if (!foundMutual) {
            System.out.println("No mutual friends found.");
        }
    }

    public void displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found!");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendList;
        int count = 1;

        if (temp == null) {
            System.out.println("No friends found.");
            return;
        }

        while (temp != null) {
            User friend = findUserById(temp.friendId);
            if (friend != null) {
                System.out
                        .println(count + ". " + friend.name + " (ID: " + friend.userId + ", Age: " + friend.age + ")");
                count++;
            }
            temp = temp.next;
        }
    }

    public void searchUserById(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found!");
            return;
        }

        System.out.println("User found:");
        System.out.println("ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
    }

    public void searchUserByName(String name) {
        User user = findUserByName(name);
        if (user == null) {
            System.out.println("User with name '" + name + "' not found!");
            return;
        }

        System.out.println("User found:");
        System.out.println("ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
    }

    public void countFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found!");
            return;
        }

        FriendNode temp = user.friendList;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println(user.name + " has " + count + " friends.");
    }

    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system!");
            return;
        }

        System.out.println("All Users:");
        User temp = head;
        int count = 1;
        while (temp != null) {
            System.out.println(count + ". ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaFriendConnections system = new SocialMediaFriendConnections();

        while (true) {
            System.out.println("\n=== Social Media Friend Connections ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends");
            System.out.println("6. Search User by ID");
            System.out.println("7. Search User by Name");
            System.out.println("8. Count Friends");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    system.addUser(userId, name, age);
                    break;

                case 2:
                    System.out.print("Enter first user ID: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter second user ID: ");
                    int userId2 = scanner.nextInt();
                    system.addFriendConnection(userId1, userId2);
                    break;

                case 3:
                    System.out.print("Enter first user ID: ");
                    int removeUserId1 = scanner.nextInt();
                    System.out.print("Enter second user ID: ");
                    int removeUserId2 = scanner.nextInt();
                    system.removeFriendConnection(removeUserId1, removeUserId2);
                    break;

                case 4:
                    System.out.print("Enter first user ID: ");
                    int mutualUserId1 = scanner.nextInt();
                    System.out.print("Enter second user ID: ");
                    int mutualUserId2 = scanner.nextInt();
                    system.findMutualFriends(mutualUserId1, mutualUserId2);
                    break;

                case 5:
                    System.out.print("Enter user ID: ");
                    int displayUserId = scanner.nextInt();
                    system.displayAllFriends(displayUserId);
                    break;

                case 6:
                    System.out.print("Enter user ID to search: ");
                    int searchId = scanner.nextInt();
                    system.searchUserById(searchId);
                    break;

                case 7:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    system.searchUserByName(searchName);
                    break;

                case 8:
                    System.out.print("Enter user ID: ");
                    int countUserId = scanner.nextInt();
                    system.countFriends(countUserId);
                    break;

                case 9:
                    system.displayAllUsers();
                    break;

                case 10:
                    System.out.println("Exiting Social Media Friend Connections...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
