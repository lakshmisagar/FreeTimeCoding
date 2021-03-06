import java.util.Arrays;

public class BoxStacking {

    public int solve(int [][] x){

        Box [] boxes = new Box[x.length*2];
        for (int i = 0; i<x.length ; i++) {
            int h = x[i][0];
            int w = x[i][1];
            int d = x[i][2];
            boxes[i] = new Box(h,w,d); //normal dimension
            //boxes[i*3+1] = new Box(w,h,d); //first dimension
            boxes[i*3+1] = new Box(d,h,w); //second dimension
        }

        //all options are created.
        Arrays.sort(boxes);
        //to display all the possible boxes.
        System.out.println("All possible combination of boxes after rotation");
        for (int i = 0; i <boxes.length ; i++) {
            System.out.println(boxes[i].height + " " + boxes[i].width + " " + boxes[i].depth);
        }

        int [] optHeight = new int [boxes.length+1];

        //if there are no boxes then optimal height = 0
        optHeight[0] =0;
        int i = 0;
        for (i = 1; i <optHeight.length ; i++) {
            int maxHeightIndex = 0;
            for (int j = i-1; j >=0 ; j--) {
                //first check if box can be placed
                if(boxes[j].width>boxes[i-1].width && boxes[j].depth>boxes[i-1].depth){
                    if(optHeight[maxHeightIndex]<optHeight[j+1]){
                        maxHeightIndex = j+1;
                    }
                }
            }
            optHeight[i]=optHeight[maxHeightIndex] + boxes[i-1].height;
        }

//        System.out.println(Arrays.toString(optHeight));
       return optHeight.length;
    }

    public static void main(String[] args) {
        int [][] x = {{1,9,4},
        {1,6,9},
        {1,6,9},
        {1,6,4},
        {1,6,4},
        {1,1,1}};
        BoxStacking boxStacking = new BoxStacking();
        System.out.println("Max height which can be obtained :" + boxStacking.solve(x));
    }
}

class Box implements Comparable<Box>{
    int height;
    int width;
    int depth;
    public Box(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int compareTo(Box o) {
        int area = o.depth*o.width;
        int thisArea = this.depth*this.width;

        return  area - thisArea;
    }
}