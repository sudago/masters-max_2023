package cs16.cs10.mission1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCode {
    public static void main(String[] args) {
        List<Process> processList = new ArrayList<>();
        processList.add(new Process("A", 3));
        processList.add(new Process("B", 5));
        processList.add(new Process("C", 7));
        processList.add(new Process("D", 10));
        processList.add(new Process("E", 15));
        processList.add(new Process("F", 21));

        List<Process> randomList = getRandomList(processList);
        OS OS = new OS(randomList, "roundRobin");
        OS.PCB();
        OS.showInfo();
//        program.getProcessList(); // 확인용
    }

    public static List<Process> getRandomList(List<Process> processList) {
        Random random = new Random();
        List<Process> randomList = new ArrayList<>();

        while (randomList.size() < 3) {
            int randomIndex = random.nextInt(processList.size());
            Process randomProcess = processList.get(randomIndex);
            if (!randomList.contains(randomProcess)) randomList.add(randomProcess);
        }

        return randomList;
    }

}
