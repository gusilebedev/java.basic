public class Elevator {

    private int currentFloor = 1;
    public int minFloor;
    public int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;

    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;

    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor){
            System.out.println("Ошибка!");
            return;
        } else if (floor == currentFloor) {
            return;
        }
        while (currentFloor < floor) {
            moveUp();
            System.out.println("Вверх: " + currentFloor);
            if (currentFloor == floor) {
                System.out.println("Ваш этаж: " + currentFloor);
                break;
            }
        }
        while (currentFloor > floor) {
            moveDown();
            System.out.println("Вниз: " + currentFloor);
            if (currentFloor == floor) {
                System.out.println("Ваш этаж: " + currentFloor);
                break;
            }

        }
    }
}
