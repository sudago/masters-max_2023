package cs16.cs10.mission1;

public enum ProcessState {
    READY("ready"), WAITING("waiting"), RUNNING("running"), TERMINATED("terminated");

    private final String processState;

    ProcessState(String processState){
        this.processState = processState;
    }

    public String getProcessState(){
        return processState;
    }
}
