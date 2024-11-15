import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TollRoad {
    private final Map<String, Vehicle> vehiclesByDescription;
    private final Map<String, Vehicle> vehiclesByState;

    public TollRoad() {

        this.vehiclesByDescription = new TreeMap<>();

        Comparator<String> stateComparator = Comparator
                .comparing((String desc) -> desc.substring(1, 3)) // Primary: state code
                .thenComparing(desc -> desc);
        this.vehiclesByState = new TreeMap<>(stateComparator);
    }

    public void addToll(String description) {
        Vehicle vehicle = vehiclesByDescription.get(description);

        if (vehicle == null) {
            vehicle = new Vehicle(description);
            vehiclesByDescription.put(description, vehicle);
            vehiclesByState.put(description, vehicle);
        } else {
            vehicle.addToll();
        }
    }

    public String getVehicleReportByDescription() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehiclesByDescription.values()) {
            sb.append(vehicle).append("\n");
        }
        return sb.toString();
    }

    public String getVehicleReportByState() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehiclesByState.values()) {
            sb.append(vehicle).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TollRoad tollRoad = new TollRoad();
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("TIA765QRS");
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");

        System.out.println("Vehicle Report By Description:");
        System.out.println(tollRoad.getVehicleReportByDescription());

        System.out.println("\nVehicle Report By State:");
        System.out.println(tollRoad.getVehicleReportByState());
    }
}


