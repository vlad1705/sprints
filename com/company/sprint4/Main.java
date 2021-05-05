package com.company.sprint4;

public class Main {
    public static void main(String[] args) {
    }


    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int[] getXYPair(){
            int pair[] = {getX(),getY()};
            return pair;
        }

        public double distance(int x, int y){
            return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
        }

        public double distance(Point point){
            return Math.sqrt(Math.pow((this.x - point.getX()), 2) + Math.pow((this.y - point.getY()), 2));
        }

        public double distance(){
            return Math.sqrt(Math.pow((this.x - 0), 2) + Math.pow((this.y - 0), 2));
        }



    }
}

