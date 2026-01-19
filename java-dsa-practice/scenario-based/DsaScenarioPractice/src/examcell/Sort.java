package examcell;



public class Sort{

    public void Sort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        // divide
        Sort(arr, si, mid);
        Sort(arr, mid + 1, ei);

        // merge
        merge(arr, si, mid, ei);
    }

    private void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];

        int i = si;       
        int j = mid + 1;
        int k = 0;        


        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

       
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

    
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
}