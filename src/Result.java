public class Result {
    private boolean match;
    private int index;

    public Result(boolean m, int i) {
        match = m;
        index = i;

    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}