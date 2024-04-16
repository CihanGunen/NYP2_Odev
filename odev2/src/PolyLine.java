import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(Line line) {
        this();
        addLine(line);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addLine(Line line) {
        points.add(line.getStart());
        points.add(line.getEnd());
    }

    public void addPolyLine(PolyLine polyLine) {
        points.addAll(polyLine.points);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i)).append(",");
        }
        if (!points.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1); // Son virgülü kaldır
        }
        sb.append("]");
        return sb.toString();
    }

    public double length() {
        double totalLength = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += points.get(i).distanceFromPoint(points.get(i + 1));
        }
        return totalLength;
    }

    public PolyLine reverse() {
        Collections.reverse(points);
        return this;
    }
}
