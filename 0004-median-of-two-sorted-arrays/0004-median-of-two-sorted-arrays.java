/*class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final int n1 = nums1.length;
    final int n2 = nums2.length;
    if (n1 > n2)
      return findMedianSortedArrays(nums2, nums1);

    int l = 0;
    int r = n1;

    while (l <= r) {
      final int partition1 = (l + r) / 2;
      final int partition2 = (n1 + n2 + 1) / 2 - partition1;
      final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
      final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
      final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
      final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];
      if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
        return (n1 + n2) % 2 == 0
            ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
            : Math.max(maxLeft1, maxLeft2);
      else if (maxLeft1 > minRight2)
        r = partition1 - 1;
      else
        l = partition1 + 1;
    }

    throw new IllegalArgumentException();
  }
}*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE : nums1[cut1 - 1];

            int right1 = (cut1 == m)
                    ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right2 = (cut2 == n)
                    ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(left1, left2);
                    int minRight = Math.min(right1, right2);

                    return ((double) maxLeft + minRight) / 2;
                }

                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        throw new IllegalArgumentException("Arrays must be sorted");
    }
}
