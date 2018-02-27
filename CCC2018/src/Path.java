public class Path {
	public int page;
	public int[] toPath;
	public int[] fromPath;
	public boolean reachable;
	public boolean checkedTo;
	public boolean checkedFrom;
	public int distToEnd;
	
	public Path(int p, int[] tp, int[] fp, boolean r, boolean ct, boolean cf, int d) {
		page = p;
		toPath = tp; // the paths that the page can lead to
		fromPath = fp; // the paths of pages that lead to the page
		reachable = r; // is the page reachable?
		checkedTo = ct; // was the paged checked already for to? prevents loops
		checkedFrom = cf; //was the paged checked already for from? prevents loops
		distToEnd = d; // the page's distance from the end
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int[] getToPath() {
		return toPath;
	}

	public void setToPath(int[] toPath) {
		this.toPath = toPath;
	}

	public int[] getFromPath() {
		return fromPath;
	}

	public void setFromPath(int[] fromPath) {
		this.fromPath = fromPath;
	}
	
	public boolean isReachable() {
		return reachable;
	}
	
	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
	
	public boolean checkedTo() {
		return checkedTo;
	}
	
	public void setCheckedTo(boolean checkedTo) {
		this.checkedTo = checkedTo;
	}
	
	public boolean checkedFrom() {
		return checkedFrom;
	}
	
	public void setCheckedFrom(boolean checkedFrom) {
		this.checkedFrom = checkedFrom;
	}
	
	public int getDistToEnd() {
		return distToEnd;
	}

	public void setDistToEnd(int distToEnd) {
		this.distToEnd = distToEnd;
	}
}