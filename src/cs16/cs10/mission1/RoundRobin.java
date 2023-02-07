package cs16.cs10.mission1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin implements Scheduler {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void start(List<Process> processList) {
        Queue<Process> waiting = new LinkedList<>(ready(processList));
        for (Process process : waiting) {
            process.currentStatus = ProcessState.WAITING.getProcessState();
        }
        Queue<Process> terminated = new LinkedList<>();

        while (terminated.size() < 3) {
            running(processList, waiting, terminated);
        } // while - end
        currentProcessInfo(processList);
        stringBuilder.append("라운드로빈 방식 스케줄링이 종료되었습니다.\n");
        calculateFinalInfo(processList); // OS로 옮기고 싶음.
    }

    public List<Process> ready(List<Process> processList) {
        for (Process process : processList) {
            process.currentStatus = ProcessState.READY.getProcessState();
        }
        currentProcessInfo(processList);
        return processList;
    }

    @Override
    public void running(List<Process> processList, Queue<Process> waiting, Queue<Process> terminated) {
        Process running = waiting.poll();
        assert running != null; // assert❓
        running.currentStatus = ProcessState.RUNNING.getProcessState();
        running.countTime++;
        for (Process process : waiting) {
            process.waitingTime++;
        }
        currentProcessInfo(processList);

        if (running.countTime == running.getTime()) {
            running.currentStatus = ProcessState.TERMINATED.getProcessState();
            terminated.add(running);
        } else {
            running.currentStatus = ProcessState.WAITING.getProcessState();
            waiting.add(running);
        }
    }

    @Override
    public void currentProcessInfo(List<Process> processList) {
        for (Process process : processList) {
            stringBuilder.append(process.getName()).append("(").append(process.currentStatus).append(")");
            stringBuilder.append(" , ").append(process.countTime).append(" / ").append(process.getTime());
            if (!process.currentStatus.equals("ready")) {
                stringBuilder.append(" , waiting ").append(process.waitingTime).append(" sec\n");
            } else {
                stringBuilder.append("\n");
            }// if - end
        } // for - end
        stringBuilder.append("\n");
    }

    @Override
    public void calculateFinalInfo(List<Process> processList) {
        StringBuilder waitingSB = new StringBuilder();
        waitingSB.append("평균 대기시간 = ( ");
        StringBuilder returnSB = new StringBuilder();
        returnSB.append("평균 반환시간 = ( ");
        double averageWaitingTime = 0;
        double averageReturnTime = 0;

        for (Process process : processList) {
            averageWaitingTime += process.waitingTime;
            waitingSB.append(process.waitingTime).append(" + ");
            int returnTime = process.waitingTime + process.getTime();
            averageReturnTime += returnTime;
            returnSB.append(returnTime).append(" + ");
        }

        waitingSB.delete(waitingSB.length()-3, waitingSB.length());
        returnSB.delete(returnSB.length()-3, returnSB.length());
        averageWaitingTime /= processList.size();
        averageReturnTime /= processList.size();

        waitingSB.append(" ) / ").append(processList.size()).append(" = ")
                .append(String.format("%.1f", averageWaitingTime)).append("sec\n");
        returnSB.append(" ) / ").append(processList.size()).append(" = ")
                .append(String.format("%.1f", averageReturnTime)).append("sec\n");

        stringBuilder.append(waitingSB.append(returnSB));
    }

    @Override
    public StringBuilder getInfo(){
        return stringBuilder;
    }
}
