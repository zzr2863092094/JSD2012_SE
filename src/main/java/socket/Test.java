package socket;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] allOut = {12,46,47,43,64,67,69,58};
        int pw = 64;
        System.out.println(Arrays.toString(allOut));
        //将pw从数组allOut中删除
        for(int i=0 ;i<allOut.length;i++)
            if(pw == allOut[i]){
                allOut[i] = allOut[allOut.length-1];
                allOut = Arrays.copyOf(allOut,allOut.length-1);
                break;
            }

        System.out.println(Arrays.toString(allOut));
    }
}
