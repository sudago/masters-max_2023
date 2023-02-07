package cs16.cs10.mission1;

import java.util.List;
import java.util.Queue;

public interface Scheduler {
    void start(List<Process> processList);

    void running(List<Process> processList, Queue<Process> waiting,
                 Queue<Process> terminated);

    void currentProcessInfo(List<Process> processList);

    void calculateFinalInfo(List<Process> processList);
    StringBuilder getInfo();
}
