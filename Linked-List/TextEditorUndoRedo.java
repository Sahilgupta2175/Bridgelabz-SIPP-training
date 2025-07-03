import java.util.Scanner;

public class TextEditorUndoRedo {
    class TextState {
        String content;
        TextState next;
        TextState prev;

        public TextState(String content) {
            this.content = content;
            this.next = null;
            this.prev = null;
        }
    }

    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public TextEditorUndoRedo() {
        addTextState("");
    }

    public void addTextState(String content) {
        TextState newState = new TextState(content);

        if (head == null) {
            head = tail = current = newState;
        } else {
            if (current != tail) {
                TextState temp = current.next;
                while (temp != null) {
                    TextState nodeToDelete = temp;
                    temp = temp.next;
                    nodeToDelete.prev = null;
                    nodeToDelete.next = null;
                }
                tail = current;
                current.next = null;
                size = getActualSize();
            }

            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
        }

        size++;

        if (size > MAX_HISTORY) {
            TextState nodeToDelete = head;
            head = head.next;
            head.prev = null;
            nodeToDelete.next = null;
            size--;
        }

        System.out.println("Text state saved!");
    }

    private int getActualSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo!");
            return;
        }

        current = current.prev;
        System.out.println("Undo performed!");
        displayCurrentState();
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo!");
            return;
        }

        current = current.next;
        System.out.println("Redo performed!");
        displayCurrentState();
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No current state!");
            return;
        }

        System.out.println("Current text content:");
        System.out.println("\"" + current.content + "\"");
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("No history available!");
            return;
        }

        System.out.println("Text History:");
        TextState temp = head;
        int index = 1;

        while (temp != null) {
            String marker = (temp == current) ? " [CURRENT]" : "";
            System.out.println(index + ". \"" + temp.content + "\"" + marker);
            temp = temp.next;
            index++;
        }
    }

    public void appendText(String text) {
        String newContent = current.content + text;
        addTextState(newContent);
    }

    public void replaceText(String text) {
        addTextState(text);
    }

    public void deleteText(int numChars) {
        String currentContent = current.content;
        if (numChars >= currentContent.length()) {
            addTextState("");
        } else {
            String newContent = currentContent.substring(0, currentContent.length() - numChars);
            addTextState(newContent);
        }
    }

    public void insertTextAtPosition(String text, int position) {
        String currentContent = current.content;
        if (position < 0 || position > currentContent.length()) {
            System.out.println("Invalid position!");
            return;
        }

        String newContent = currentContent.substring(0, position) + text + currentContent.substring(position);
        addTextState(newContent);
    }

    public void clearHistory() {
        head = tail = current = null;
        size = 0;
        addTextState("");
        System.out.println("History cleared!");
    }

    public void showStats() {
        System.out.println("=== Text Editor Statistics ===");
        System.out.println("History size: " + size);
        System.out.println("Max history limit: " + MAX_HISTORY);
        System.out.println("Current text length: " + (current != null ? current.content.length() : 0));
        System.out.println("Can undo: " + (current != null && current.prev != null));
        System.out.println("Can redo: " + (current != null && current.next != null));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        while (true) {
            System.out.println("\n=== Text Editor with Undo/Redo ===");
            System.out.println("1. Append Text");
            System.out.println("2. Replace Text");
            System.out.println("3. Delete Characters");
            System.out.println("4. Insert Text at Position");
            System.out.println("5. Undo");
            System.out.println("6. Redo");
            System.out.println("7. Display Current State");
            System.out.println("8. Display History");
            System.out.println("9. Show Statistics");
            System.out.println("10. Clear History");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to append: ");
                    String appendText = scanner.nextLine();
                    editor.appendText(appendText);
                    break;

                case 2:
                    System.out.print("Enter new text: ");
                    String replaceText = scanner.nextLine();
                    editor.replaceText(replaceText);
                    break;

                case 3:
                    System.out.print("Enter number of characters to delete: ");
                    int numChars = scanner.nextInt();
                    editor.deleteText(numChars);
                    break;

                case 4:
                    System.out.print("Enter text to insert: ");
                    String insertText = scanner.nextLine();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    editor.insertTextAtPosition(insertText, position);
                    break;

                case 5:
                    editor.undo();
                    break;

                case 6:
                    editor.redo();
                    break;

                case 7:
                    editor.displayCurrentState();
                    break;

                case 8:
                    editor.displayHistory();
                    break;

                case 9:
                    editor.showStats();
                    break;

                case 10:
                    editor.clearHistory();
                    break;

                case 11:
                    System.out.println("Exiting Text Editor...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
