package fleetmanager;

public class FleetManager {

    public static void mergeSort(Vehicle[] vehicles, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(vehicles, left, mid);
            mergeSort(vehicles, mid + 1, right);

            merge(vehicles, left, mid, right);
        }
    }

    private static void merge(Vehicle[] vehicles, int start, int mid, int end) {

        Vehicle[] temp = new Vehicle[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (vehicles[i].mileage <= vehicles[j].mileage) {
                temp[k++] = vehicles[i++];
            } else {
                temp[k++] = vehicles[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = vehicles[i++];
        }

        while (j <= end) {
            temp[k++] = vehicles[j++];
        }

        // Copy back to original array
        for (int m = 0; m < temp.length; m++) {
            vehicles[start + m] = temp[m];
        }
    }
}
