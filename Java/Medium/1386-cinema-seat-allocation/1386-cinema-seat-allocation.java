class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> rows = new HashMap<>();

        // Store reserved seats row by row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            rows.computeIfAbsent(row, x -> new HashSet<>()).add(col);
        }

        // Initially every row can fit 2 families
        int answer = 2 * n;

        // Only inspect rows having reservations
        for (int row : rows.keySet()) {

            Set<Integer> reserved = rows.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Left = 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(seat)) {
                    left = false;
                    break;
                }
            }

            // Middle = 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if (reserved.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            // Right = 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(seat)) {
                    right = false;
                    break;
                }
            }

            // This row was previously counted as 2.
            // Remove those 2 and add the actual number.
            answer -= 2;

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}