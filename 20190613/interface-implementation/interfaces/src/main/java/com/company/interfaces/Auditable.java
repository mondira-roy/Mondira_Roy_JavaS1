package com.company.interfaces;

public class SchoolRecord implements Auditable {

    public void runAudit() {
        System.out.print("auditing")
    }

    public void sendAuditToState() {
        System.out.print("audit sent")
    }

}