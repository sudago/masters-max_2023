package cs16.cs10.mission1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {
    private final List<Process> processList;

    public Program(List<Process> processList){
        this.processList = processList;
    }

    // ready, running, waiting : Queue 로 만든다. (Queue 클래스 사용해보고 싶었음)
    public void workProcess(){
        Queue<Process> waiting = new LinkedList<>(ready(processList));
        for (Process process : waiting) {
            process.currentStatus = "waiting";
        }
        Queue<Process> terminated = new LinkedList<>();

        while (terminated.size() < 3) {
            running(processList, waiting, terminated);
        } // while - end
        currentProcessInfo(processList);
        showInfo(processList);
    }

    public List<Process> ready(List<Process> processList) {
        for (Process process : processList) {
            process.currentStatus = "ready";
        }
        currentProcessInfo(processList);
        return processList;
    }

    public void running(List<Process> processList, Queue<Process> waiting, Queue<Process> terminated){
        Process running = waiting.poll();
        running.currentStatus = "running";
        running.countTime++;
        for (Process process : waiting) {
            process.waitingTime++;
        }
        currentProcessInfo(processList);

        if (running.countTime == running.getTime()) {
            running.currentStatus = "terminated";
            terminated.add(running);
        } else {
            running.currentStatus = "waiting";
            waiting.add(running);
        }
    }

    public void currentProcessInfo(List<Process> processList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Process process : processList) {
            stringBuilder.append(process.getName() + "(" + process.currentStatus + ")");
            stringBuilder.append(" , " + process.countTime + " / " + process.getTime());
            if (!process.currentStatus.equals("ready")) {
                stringBuilder.append(" , waiting " + process.waitingTime + " sec\n");
            } else {
                stringBuilder.append("\n");
            }// if - end
        } // for - end
        System.out.println(stringBuilder);
    } // currentProcessInfo() - end

    public void showInfo(List<Process> processList) { // 🚫중복되는게 많으므로 수정 필요!
        StringBuilder waitingSB = new StringBuilder();
        waitingSB.append("평균 대기시간 = ( ");
        StringBuilder returnSB = new StringBuilder();
        returnSB.append("평균 반환시간 = ( ");
        double averageWaitingTime = 0;
        double averageReturnTime = 0;

        for (Process process : processList) {
            averageWaitingTime += process.waitingTime;
            waitingSB.append(process.waitingTime + " + ");
            int returnTime = process.waitingTime + process.getTime();
            averageReturnTime += returnTime;
            returnSB.append((int)(returnTime) + " + ");
        }

        waitingSB.delete(waitingSB.length()-3, waitingSB.length());
        returnSB.delete(returnSB.length()-3, returnSB.length());
        averageWaitingTime /= processList.size();
        averageReturnTime /= processList.size();

        waitingSB.append(" ) / " + processList.size() + " = " + String.format("%.1f", averageWaitingTime) + "sec");
        returnSB.append(" ) / " + processList.size() + " = " + String.format("%.1f", averageReturnTime) + "sec\n");
        System.out.println("라운드로빈 방식 스케줄링이 종료되었습니다.");
        System.out.println(waitingSB);
        System.out.println(returnSB);
    }

//    public void getProcessList(){ // 확인용
//        for (Process process : processList) {
//            System.out.println(process);
//        }
//    }

}
