package cs16.cs10.mission1;

public class Process {
    private final String name;
    private final int time;
    public Process(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
