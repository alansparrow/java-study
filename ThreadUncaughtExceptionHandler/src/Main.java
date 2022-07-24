public class Main {
    public static void main(String[] args) {
        Thread handledThread = new Thread(
                ()-> {
                    throw new UnsupportedOperationException();
                }
        );

        handledThread.setName("My Broken Thread");

        handledThread.setUncaughtExceptionHandler((t, e) -> {
            System.err.printf("Exception in thread %d '%s':" +
                            "%s at line %d of %s%n",
                    t.getId(), // Thread id
                    t.getName(), // Thread name
                    e.toString(), // Exception name and message
                    e.getStackTrace()[0].getLineNumber(),
                    e.getStackTrace()[0].getFileName());
        });

        handledThread.start();
    }
}

// Out example
// Exception in thread 22 'My Broken Thread':java.lang.UnsupportedOperationException at line 5 of Main.java