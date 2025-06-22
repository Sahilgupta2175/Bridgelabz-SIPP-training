class Q2_StringLengthManual {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        String text = "OpenAI";
        int manualLength = getLength(text);
        int builtinLength = text.length();

        System.out.println("Manual Length: " + manualLength);
        System.out.println("Built-in Length: " + builtinLength);
    }
}
