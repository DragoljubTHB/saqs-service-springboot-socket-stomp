package saqs.eis;

public class StationMemory {
    private static StationMemory ourInstance = new StationMemory();

    public static StationMemory getInstance() {
        return ourInstance;
    }

    private StationMemory() {
    }
}
