package com.company.interfaces;

public interface Storable {
    public void storeData();
    
    public void retrieveData();
}

public class SchoolRecord implements Storable, Auditable {
    // Properties here
    // Additional methods here

    // Storable methods here
    public void storeData() {
        // method body implementation here
    }

    public void retrieveData() {
        // method body implementation here
    }

    // Auditable methods here
    public void runAudit() {
        // method body implementation here
    }

    public void sendAuditToState() {
        // method body implementation here
    }
}