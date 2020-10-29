package leetcode;

import java.util.*;

public class Num1466_MakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        Queue<int[]> queue = new LinkedList<>(Arrays.asList(connections));
        boolean[] isToZero = new boolean[n];
        isToZero[0] = true;

        int counter = 0;

        while(!queue.isEmpty()) {
            int[] connection = queue.poll();
            int from = connection[0];
            int to = connection[1];

            /**
             new int[]{4,3},
             new int[]{2,3},
             new int[]{1,2},
             new int[]{1,0}

              0 <- 1 -> 2 -> 3 <- 4

             */
            if(isToZero[to]) { // direct ok
                isToZero[from] = true;
            } else {
                // 'to' can't reach zero

                if(isToZero[from]) { // 'from' can reach zero
                    counter ++; //reverse
                    isToZero[to] = true;

                } else {
                    // i don't know which direction is right, delay it
                    queue.add(connection);
                }

            }

        }
        return counter;

    }

//    /**
//     * my solution
//
//     Runtime: 122 ms, faster than 29.26% of Java online submissions for Reorder Routes to Make All Paths Lead to the City Zero.
//     Memory Usage: 74.5 MB, less than 5.26% of Java online submissions for Reorder Routes to Make All Paths Lead to the City Zero.
//
//     */
//    public int minReorder(int n, int[][] connections) {
//        City zero = null;
//
//        Map<Integer, City> cityMap = new HashMap<>();
//        for (int[] connection : connections) {
//            City srcCity = cityMap.getOrDefault(connection[0], new City(connection[0]));
//            City destCity = cityMap.getOrDefault(connection[1], new City(connection[1]));
//            srcCity.addLinkTo(destCity);
//            destCity.addLinkBack(srcCity);
//            if(connection[0]==0) {
//                zero = srcCity;
//            }
//            if(connection[1]==0) {
//                zero = destCity;
//            }
//            cityMap.put(srcCity.id, srcCity);
//            cityMap.put(destCity.id, destCity);
//        }
//
//
//        return traceDownAndRevert(zero);
//    }
//
//    private int traceDownAndRevert(City city) {
//        int counter = 0;
//
//        if(city.linkTo!=null) {
//            Iterator<Map.Entry<Integer, City>> parentsIter = city.linkTo.entrySet().iterator();
//            while(parentsIter.hasNext()) {
//                City parent = parentsIter.next().getValue();
//                if(!parent.done) {
//                    parent.linkBack.remove(city.id);
//                    parent.addLinkTo(city);
//                    city.addLinkBack(parent);
//                    parentsIter.remove();
//                    counter ++;
//                }
//            }
//        }
//        city.done = true;
//        if(city.linkBack!=null && !city.linkBack.isEmpty()) {
//            Iterator<Map.Entry<Integer, City>> children = city.linkBack.entrySet().iterator();
//            while(children.hasNext()) {
//                City child = children.next().getValue();
//                counter += traceDownAndRevert(child);
//            }
//        }
//        return counter;
//    }
//
//    class City {
//        private int id;
//        private boolean done = false;
//        private Map<Integer, City> linkTo = null;
//        private Map<Integer, City> linkBack = null;
//
//        public City(int id) {
//            this.id = id;
//        }
//        public void done() {
//            done = true;
//        }
//        public void addLinkTo(City destCity) {
//            if(linkTo == null) {
//                linkTo = new HashMap<>();
//            }
//            linkTo.put(destCity.id, destCity);
//        }
//        public void addLinkBack(City srcCity) {
//            if(linkBack==null) {
//                linkBack = new HashMap<>();
//            }
//            linkBack.put(srcCity.id, srcCity);
//        }
//    }

}
