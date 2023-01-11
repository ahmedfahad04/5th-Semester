package Refactored_Code.Refactored_Code;

import java.util.Queue;

/*
PrintJob class holds a queue of PrintRequest Objects that contains the reference
of the Document class and the reference of the TonerSaveMode, PageSaveMode and BoosterMode classes. PrintJob class also holds an object of the PrioritySetting class.
The two methods in PrintJob class namely pullJob and changePriority help to send a specific job to production based on the priority setting and change the priority of a job respectively.
*/

public class PrintJob {
    private Queue<PrintRequest> printRequests;

    private void pullJob(){
        System.out.println("Send specific job on priority settings");
    }
}
