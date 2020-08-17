import java.util.ArrayList;
import java.util.List;

public class LinesCounter {
    private List<Integer> onLines = new ArrayList<>();

    LinesCounter(Integer lineNumber) {
        addNewValue(lineNumber);
    }

    void addNewValue(Integer lineNumber) {
        onLines.add(lineNumber);
    }

    @Override
    public String toString() {
        if (onLines.size() == 1) {
            return "wystepuje " + onLines.size() + " raz w linii -> " + onLines.toString();
        } else {
            return "wystepuje " + onLines.size() + " razy w liniach -> " + onLines.toString();
        }
    }
}