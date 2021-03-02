package stack;

import org.junit.jupiter.api.Test;
import stack.Truck;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 다리를 건너는 트
 *
 * 1. 큐에 대가 대기 트럭을 담는다.
 * 2. 다리를 지나는 트럭이 아무것도 없으면 대기 트럭을 움직이는 트럭에 넣고 현재 무게를 추가하고 반복문 다음으로 넘어간다.
 * 3. 다리를 지나는 트럭에 반복문을 돌려서 움직이는 위치를 추가한다.
 * 4. 움직이 트럭 중에서 제일 먼저 다리를 건너온 트럭의 움직이는 위치가 다리길이보다 크면 움직이는는 트럭을 빼주고 현재 무게의 움직이는 트럭의 무게를 빼준다.
 * 5. 대기 트럭이 비어있지 않고 현재 무게랑 대기 트럭의 선출 트럭의 무게의 합이 다리의 무게보다 작다면 대기 트럭에 넣는다.
 *
 * bridgeLength     weight          truckWeights                        return
 * 2	            10	            [7,4,5,6]	                        8
 * 100	            100	            [10]	                            101
 * 100	            100	            [10,10,10,10,10,10,10,10,10,10]	    110
 *
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class StackLessonl1Test {
    private int currentBridgeWeight;

    @Test
    public void solution() {
        int bridgeLength = 2;
        int bridgeWeight = 10;
        int[] truckWeights = {7,4,5,6};

        Queue<Truck> waitTrucks = getWaitTrucks(truckWeights);
        Queue<Truck> movingTrucks = new LinkedList<>();
        int result = 0;
        while(!waitTrucks.isEmpty() || !movingTrucks.isEmpty()) {
            result++;
            if (movingTrucks.isEmpty()) {
                addMovingTrucks(movingTrucks, waitTrucks);
                continue;
            }

            moving(movingTrucks);
            passBridge(bridgeLength, movingTrucks);

            if (isAddMovingTruck(waitTrucks, bridgeWeight)) {
                addMovingTrucks(movingTrucks, waitTrucks);
            }
        }
        assertThat(result).isEqualTo(8);

    }

    private Queue<Truck> getWaitTrucks(int[] truckWeights) {
        Queue<Truck> waitTrucks = new LinkedList<>();
        for (int truckWeight : truckWeights) {
            waitTrucks.offer(new Truck(truckWeight));
        }
        return waitTrucks;
    }

    private void addMovingTrucks(Queue<Truck> movingTrucks, Queue<Truck> waitTrucks) {
        Truck truck = waitTrucks.poll();
        currentBridgeWeight += truck.weight();
        movingTrucks.offer(truck);
    }

    private void moving(Queue<Truck> movingTrucks) {
        for (Truck movingTruck : movingTrucks) {
            movingTruck.moving();
        }
    }

    private void passBridge(int bridgeLength, Queue<Truck> movingTrucks) {
        if (movingTrucks.peek().position() > bridgeLength) {
            Truck passTruck = movingTrucks.poll();
            currentBridgeWeight -= passTruck.weight();
        }
    }

    private boolean isAddMovingTruck(Queue<Truck> waitTrucks, int bridgeWeight) {
        return !waitTrucks.isEmpty() && currentBridgeWeight + waitTrucks.peek().weight() <= bridgeWeight;
    }
}
