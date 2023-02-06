package cs16.cs10.mission1;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private final List<Process> processList;

    public Program(List<Process> processList){
        this.processList = processList;
    }

    public List<Process> getProcessList(){
        return processList;
    }

}
