public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("rerun the program and pass in your apiToken as an program argument.");
            return;
        }
        String apiToken = args[0];
        Scheduler scheduler = new Scheduler();
        scheduler.getAppointments(apiToken);
    }
}
