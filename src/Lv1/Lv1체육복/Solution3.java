package Lv1.Lv1체육복;

/**
 * @author kim, eun soo - devegoist
 * @date 05/02/2019
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 3, 4}, new int[]{3, 4, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] a = new int[n+2];
        for(int i = 1; i <= n; i++)
            a[i] = 1;

        for(int i = 0; i < reserve.length; i++)
            a[reserve[i]] = 2;

        for(int i = 0; i < lost.length; i++)
            if(a[lost[i]] == 1) a[lost[i]] = 0;
            else a[lost[i]] = 1;

        for(int i = 1; i <= n ; i++){
            if(a[i] == 0){
                if(a[i-1] == 2){
                    a[i] = 1;
                    a[i-1] = 1;
                }else if(a[i+1] == 2){
                    a[i] = 1;
                    a[i+1] = 1;
                }
            }
        }

        int ret = 0;
        for(int i = 1; i <= n; i++)
            if(a[i] == 0) ret++;

        return n-ret;
    }
}
