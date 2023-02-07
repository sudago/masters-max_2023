package cs16.cs10.mission1;

import java.util.List;

public class OS {
    private final List<Process> processList;
    private Scheduler scheduler;

    public OS(List<Process> processList, String scheduler){
        this.processList = processList;
        if (scheduler.equals("roundRobin")) this.scheduler = new RoundRobin();
    }

    // PCB 를 class -> method 로 수정
    public void PCB(){
        scheduler.start(processList);
    }

    public void showInfo(){
        System.out.println(scheduler.getInfo());
    }

//    public void getProcessList(){ // 확인용
//        for (Process process : processList) {
//            System.out.println(process);
//        }
//    }

}
