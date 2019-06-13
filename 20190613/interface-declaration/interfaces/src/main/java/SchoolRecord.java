public class SchoolRecord implements Auditable{

    @Override
    public void runAudit() {
        System.out.println("Auditing");
    }
    public void sendAuditToState(){
        System.out.println("Confirm Audit has been sent");
    }
}
