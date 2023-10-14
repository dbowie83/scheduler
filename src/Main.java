public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("rerun the program and pass in your apiToken as an program argument.");
            return;
        }
        String apiToken = args[0];
        Scheduler scheduler = new Scheduler();

        scheduler.start(apiToken);
        scheduler.getAppointments(apiToken);

        scheduler.start(apiToken);
        scheduler.getNextAppointment(apiToken);

        scheduler.start(apiToken);
        String dateString = "2021-11-14T18:48:27.203Z";
            dateString = "2021-12-24T14:00:00";
        AppointmentInfoRequest request = new AppointmentInfoRequest(1, 0, dateString, true, 0);
        scheduler.scheduleAppointment(apiToken, request);

        scheduler.stop(apiToken);
    }
}
