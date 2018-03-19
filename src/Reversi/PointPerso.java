package Reversi;

public class PointPerso extends java.awt.Point {
	int x;
	int y;
	
	public PointPerso(int a,int b) {
		x=a;
		y=b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		PointPerso other = (PointPerso) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
}
