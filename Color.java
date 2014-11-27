public enum Color {
	
	blue(0,0,255),
	red(255,0,0),
	green(0,255,0),
	yellow(255,255,0),
	white(255,255,255),
	black(0,0,0);

	private int R;
	private int G;
	private int B;

	private Color(int R, int G, int B) {
		this.R = R;
		this.G = G;
		this.B = B;
	}
	public int getR() { return R; }
	public int getB() { return B; }
	public int getG() { return G; }
}
