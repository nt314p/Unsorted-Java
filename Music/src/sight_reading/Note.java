package sight_reading;

public class Note {
	
	private char pitch; // capital letter, A-G
	private int value; // based on how many measures, 1/1, 1/2, 1/4, 1/8, 1/16 (take the denominator)
	// private int art; // the articulation of the note (maybe later)
	private char accid; // no not acid, the accidental of a note #, -, b
	private boolean rest; // is the note a rest or not
	
	public Note (char p, int v, char a, boolean r) {
		pitch = p;
		value = v;
		accid = a;
		rest = r;
	}

	public char getPitch() {
		return pitch;
	}

	public void setPitch(char pitch) {
		this.pitch = pitch;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getAccid() {
		return accid;
	}

	public void setAccid(char accid) {
		this.accid = accid;
	}

	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}
}
