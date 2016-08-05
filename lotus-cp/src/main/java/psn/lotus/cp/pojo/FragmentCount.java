package psn.lotus.cp.pojo;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/5 8:50
 */
public class FragmentCount {

    private int higher;

    private int lower;

    private int roadZero;

    private int roadOne;

    private int roadTwo;

    private int odd;

    private int even;

    private int prime;

    private int composite;

    public int getHigher() {
        return higher;
    }

    public void setHigher(int higher) {
        this.higher = higher;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getRoadZero() {
        return roadZero;
    }

    public void setRoadZero(int roadZero) {
        this.roadZero = roadZero;
    }

    public int getRoadOne() {
        return roadOne;
    }

    public void setRoadOne(int roadOne) {
        this.roadOne = roadOne;
    }

    public int getRoadTwo() {
        return roadTwo;
    }

    public void setRoadTwo(int roadTwo) {
        this.roadTwo = roadTwo;
    }

    public int getOdd() {
        return odd;
    }

    public void setOdd(int odd) {
        this.odd = odd;
    }

    public int getEven() {
        return even;
    }

    public void setEven(int even) {
        this.even = even;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public int getComposite() {
        return composite;
    }

    public void setComposite(int composite) {
        this.composite = composite;
    }

    @Override
    public String toString() {
        return "FragmentCount{" +
                "higher=" + higher +
                ", lower=" + lower +
                ", roadZero=" + roadZero +
                ", roadOne=" + roadOne +
                ", roadTwo=" + roadTwo +
                ", odd=" + odd +
                ", even=" + even +
                ", prime=" + prime +
                ", composite=" + composite +
                '}';
    }

}
