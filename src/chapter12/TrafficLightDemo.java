package chapter12;

enum TrafficLightColor {
	RED, GREEN, YELLOW
}

class TrafficLightSimulator implements Runnable {

	private TrafficLightColor trafficLightColor;
	private boolean stop = false;
	private boolean changed = false;

	TrafficLightSimulator(TrafficLightColor init) {
		trafficLightColor = init;
	}

	TrafficLightSimulator() {
		trafficLightColor = TrafficLightColor.RED;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				switch (trafficLightColor) {
					case GREEN -> Thread.sleep(1000);
					case YELLOW -> Thread.sleep(200);
					case RED -> Thread.sleep(1200);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			changeColor();
		}

	}

	synchronized void changeColor() {
		switch (trafficLightColor) {
			case RED:
				trafficLightColor = TrafficLightColor.GREEN;
				break;
			case YELLOW:
				trafficLightColor = TrafficLightColor.RED;
				break;
			case GREEN:
				trafficLightColor = TrafficLightColor.YELLOW;
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

	synchronized TrafficLightColor getColor() {
		return trafficLightColor;
	}

	synchronized void cancel() {
		stop = true;
	}

}

public class TrafficLightDemo {

	public static void main(String[] args) {
		TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);
		Thread thrd = new Thread(tl);
		thrd.start();

		for (int i = 0; i < 9; i++) {
			System.out.println(tl.getColor());
			tl.waitForChange();
		}

		tl.cancel();
	}

}
