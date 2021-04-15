package calculators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test extends Calculator {

	@Test
	public void test() {
		String answer;
		double a;
		double b;
		double result;
		a = 18697;
		b = 20;
		result = -1 * (a / (1 + b / 100) - a);
		answer = String.format("%.5f",result);
	}
}
