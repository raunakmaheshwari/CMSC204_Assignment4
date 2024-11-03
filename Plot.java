
public class Plot {
	private int x;
	private int y; 
	private int width;
	private int depth;
	
	
	public Plot() {
		x = 1;
		y = 1;
		width = 1;
		depth = 1;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean encompasses(Plot otherPlot) {
		int topLeftX = otherPlot.x;
		int topLeftY = otherPlot.y + otherPlot.depth;
		
		
		int bottomRightX = otherPlot.x + otherPlot.width;
		int bottomRightY = otherPlot.y;
		
		
		if (((topLeftX >= x) && (topLeftY <= (y + depth))) && (((bottomRightX <= (x+width)) && (bottomRightY >= y)))) {
			return true;
		}
		return false;
	}
	
	public boolean overlaps(Plot otherPlot) {
		
		if (x >= otherPlot.x + otherPlot.width || x + width <= otherPlot.x) {
			return false;
		}
		
		if (otherPlot.y >= y + depth || otherPlot.y + otherPlot.depth <= y) {
			return false;
		}
		return true;
		/*boolean isOverlapping = false;
		int topLeftX = otherPlot.x;
		int topLeftY = otherPlot.y + otherPlot.depth;
		
		int topRightX = otherPlot.x + otherPlot.width;
		int topRightY = otherPlot.y + otherPlot.depth;
		
		int bottomLeftX = otherPlot.x;
		int bottomLeftY = otherPlot.y;
		
		int bottomRightX = otherPlot.x + otherPlot.width;
		int bottomRightY = otherPlot.y;
		
		if ((x < topLeftX && (x + width) > topLeftX && topLeftY > y && topLeftY < (y + depth))) {
			isOverlapping = true;
		}
		
		if ((x < topRightX && (x + width) > topRightX && topRightY > y && topRightY < (y + depth))) {
			isOverlapping = true;
		}
		
		if ((x < bottomLeftX && (x + width) > bottomLeftX && bottomLeftY > y && bottomLeftY < (y + depth))) {
			isOverlapping = true;
		}
		
		if ((x < bottomRightX && (x + width) > bottomRightX && bottomRightY > y && bottomRightY < (y + depth))) {
			isOverlapping = true;
		}
		
		
		return isOverlapping;*/
		
	}
	
	
	@Override
	public String toString() {
		String s = "";
		s += (x + "," + y + "," + width + "," + depth);
		return s;
	}
	
	
	
}
