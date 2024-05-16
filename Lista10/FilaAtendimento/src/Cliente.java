import java.util.Random;

public class Cliente {
    private int id;
    private int timeAtnd;

public Cliente(int id) {
    this.id = id;
    Random random = new Random();
    this.timeAtnd = random.nextInt(1, 15);
}

public int getId() {
    return id;
}

public int getTimeAtnd() {
    return timeAtnd;
}
}
