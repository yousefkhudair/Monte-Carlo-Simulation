public class MonteCarlo {

    enum dir { up , down, right, left}

    public static void main(String[] args) {
        System.out.println("Average end distance: " + outputFunction(100, 99999));
    }

    private static double outputFunction(int steps, int trials) {
        long sumOfDistance = 0;

        for (int trial = 0 ; trial < trials ; trial ++){
            sumOfDistance += getEndDistanceOfWalk(steps);
        }

        return ((double) sumOfDistance/trials);
    }

    private static double getEndDistanceOfWalk(int steps) {

        int x =0;
        int y =0;

        for (int step = 0; step < steps; step ++){

            int direction = getRandomDirection();

            if (direction == dir.up.ordinal()) y++;
            if (direction == dir.down.ordinal()) y--;
            if (direction == dir.right.ordinal()) x++;
            if (direction == dir.left.ordinal()) x--;

        }

        return distance(0,0, x , y);
    }

    private static double distance(int x, int y, int x2, int y2) {

        int deltaX = x2 - x;
        int deltaY = y2 - y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    private static int getRandomDirection() {

        return (int) (Math.random() *4);
    }


}
