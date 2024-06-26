package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class allocateBooks {
    public class Solution {
        public int books(int[] A, int B) {
            int n = A.length;
            List<Integer> list = new ArrayList<>();
            for (int i : A) {
                list.add(i);
            }

            if (B > n) {
                return -1;
            }

            int low = Collections.max(list);
            int high = list.stream().mapToInt(Integer::intValue).sum();

            while (low <= high) {
                int mid = (low + high) / 2;
                int students = countStudents(list, mid);
                if (students > B) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public  int countStudents(List<Integer> arr, int pages) {
            int students = 1;
            long pagesStudent = 0;

            for (int i = 0; i < arr.size(); i++) {
                if (pagesStudent + arr.get(i) <= pages) {
                    pagesStudent += arr.get(i);
                } else {
                    students++;
                    pagesStudent = arr.get(i);
                }
            }
            return students;
        }
    }

}
