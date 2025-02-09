package com.test.binarySearch;

/**
 * Given an array of integers A of size N and an integer B.
 * <p>
 * The College library has N books. The ith book has A[i] number of pages.
 * <p>
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 * <p>
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * <p>
 * NOTE: Return -1 if a valid assignment is not possible.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * 1 <= A[i], B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return that minimum possible number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = [12, 34, 67, 90]
 * B = 2
 * Input 2:
 * A = [12, 15, 78]
 * B = 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 113
 * Output 2:
 * -1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There are two students. Books can be distributed in following fashion :
 * 1)  [12] and [34, 67, 90]
 * Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2)  [12, 34] and [67, 90]
 * Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3)  [12, 34, 67] and [90]
 * Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * Explanation 2:
 * Each student has to be allocated at least one book.
 * But the Total number of books is less than the number of students.
 * Thus each student cannot be allocated to atleast one book.
 * <p>
 * Therefore, the result is -1.
 */
public class AllocateBooks {

    public int books(int[] A, int B) {

        int n = A.length;
        //No of books is lesser than no of students
        if (B > n)
            return -1;

        int lower = 0;
        int higher = 0;
        for (int i = 0; i < n; i++) {
            higher += A[i];
            lower = Math.max(lower, A[i]);
        }

        while (lower <= higher) {

            int mid = lower + (higher-lower)/2;
            int count = 1;
            int pages = 0;
            for(int i = 0; i<n; i++) {
                pages += A[i];
                if(pages>mid) {
                    pages = A[i]; //reset pages
                    count++;
                }
            }

            if (count<=B) {
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }
        }

        return lower;
    }

    public static void main(String[] args) {
        AllocateBooks ab = new AllocateBooks();
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println("Minimum allocated maximum pages = " + ab.books(A, B));
    }
}
