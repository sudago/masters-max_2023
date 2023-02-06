package cs16.cs10.mission1;

public class Process {
    private final String name;
    private final int time;
    public int countTime;
    public int waitingTime;
    public String currentStatus = null;

    public Process(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public int getTime(){
        return time;
    }

//    @Override
//    public String toString() { // 확인용
//        return "Process{" +
//                "name='" + name + '\'' +
//                ", time=" + time +
//                ", countTime=" + countTime +
//                ", waitingTime=" + waitingTime +
//                ", currentStatus='" + currentStatus + '\'' +
//                '}';
//    }
}
