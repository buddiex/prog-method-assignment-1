
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		// while (notAtTheTop()) {
		// fillRow();
		// goToNextRow();
		// }
		// fillRow();
		// faceNorth();
		// while (notAtTheTop()) {
		// fillDiagonal();
		// }
		faceNorth();
		fillOddColumn();
//		while (frontIsClear()) {
//			fillOddColumn();
//			moveBack();
//			nextColumn();
//			fillEvenColumn();
//			moveBack();
//			nextColumn();
//		}
	}

	private void fillOddColumn() {
		faceNorth();
		placeOneBeeper();
		while (frontIsClear()) {
			placeOneBeeper();
			moveMultiple(2);
		};
        fillLastBeeper();
	}

	private void fillLastBeeper() {
		if (noBeepersPresent()){
			faceOpposite();
			move();
			if (noBeepersPresent()){
				faceOpposite();
				move();
				placeOneBeeper();
			}
			faceOpposite();
			move();
		}
		
	}

	private void fillEvenColumn() {
		faceNorth();
		move();
		while (frontIsClear()) {
			placeOneBeeper();
			moveMultiple(2);
		}
		placeOneBeeper();
	}

	private void nextColumn() {
		faceEast();
		if (frontIsClear()) {
			move();
		}
		;
	}

	private void faceOpposite(){
		if (facingNorth()) {
			faceSouth();
		} else if (facingSouth()) {
			faceNorth();
		} else if (facingEast()) {
			faceWest();
		} else if (facingWest()) {
			faceEast();
		}
	}
	private void moveBack() {
		faceOpposite();
		moveToWall();
	}

	private void placeSpacedBeeper() {
	
	}

	private void goToNextRow() {
		faceNorth();
		move();
		faceEast();
		if (frontIsBlocked()) {
			faceWest();
		}

	}

	private boolean notAtTheTop() {
		faceNorth();
		if (frontIsBlocked()) {
			return false;
		} else {
			return true;
		}
	}

	private void placeOneBeeper() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

	private void moveMultiple(int n) {
		for (int i = 1; i <= n; i++) {
			if (frontIsClear()) move();
		}
	}

	private void moveToWall() {
		while (frontIsClear()) {
			moveMultiple(1);
		}
	}

	private void faceSouth() {

		if (facingEast()) {
			turnMultipleLeft(3);
		} else if (facingNorth()) {
			turnMultipleLeft(2);
		} else if (facingWest()) {
			turnMultipleLeft(1);
		}
	}

	private void faceEast() {
		if (facingNorth()) {
			turnMultipleLeft(3);
		} else if (facingSouth()) {
			turnMultipleLeft(1);
		} else if (facingWest()) {
			turnMultipleLeft(2);
		}
	}

	private void faceNorth() {
		if (facingEast()) {
			turnMultipleLeft(1);
		} else if (facingSouth()) {
			turnMultipleLeft(2);
		} else if (facingWest()) {
			turnMultipleLeft(3);
		}
	}

	private void faceWest() {
		if (facingEast()) {
			turnMultipleLeft(2);
		} else if (facingSouth()) {
			turnMultipleLeft(3);
		} else if (facingNorth()) {
			turnMultipleLeft(1);
		}
	}

	private void turnMultipleLeft(int n) {
		for (int i = 1; i <= n; i++) {
			turnLeft();
		}
	}

}
