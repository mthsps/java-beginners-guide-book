package chapter12;

enum TrafficLightColor2 {
	RED(1000), GREEN(200), YELLOW(1200);
	
	private int time;
	
	TrafficLightColor2(int t) {
		time = t;
	};
	
	int getDelay() {
		return time;
	};


}

class TrafficLightSimulator2 implements Runnable {

	private TrafficLightColor2 trafficLightColor;
	private boolean stop = false;
	private boolean changed = false;

	TrafficLightSimulator2(TrafficLightColor2 init) {
		trafficLightColor = init;
	}

	TrafficLightSimulator2() {
		trafficLightColor = TrafficLightColor2.RED;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(trafficLightColor.getDelay());
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			changeColor();
		}

	}

	synchronized void changeColor() {
		switch (trafficLightColor) {
			case RED:
				trafficLightColor = TrafficLightColor2.GREEN;
				break;
			case YELLOW:
				trafficLightColor = TrafficLightColor2.RED;
				break;
			case GREEN:
				trafficLightColor = TrafficLightColor2.YELLOW;
				break;
		}
		changed = true;
		notify();
	}

	synchronized void waitForChange() {
		try {
			while (!changed)
				wait();
			changed = false;
		} catch (InterruptedException exc) {
			System.out.println(exc);

		}
	}

	synchronized TrafficLightColor2 getColor() {
		return trafficLightColor;
	}

	synchronized void cancel() {
		stop = true;
	}

}

public class Question4 {

	public static void main(String[] args) {
		TrafficLightSimulator2 tl = new TrafficLightSimulator2(TrafficLightColor2.GREEN);
		Thread thrd = new Thread(tl);
		thrd.start();

		for (int i = 0; i < 9; i++) {
			System.out.println(tl.getColor());
			tl.waitForChange();
		}

		tl.cancel();
	}

}