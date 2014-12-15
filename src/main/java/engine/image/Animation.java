package engine.image;

/**
 * author Vostryakov Alexander
 */
public class Animation {

    private int period;
    private ImageStorage image;
    private int count;
    private long time;
    private boolean isAnimation;

    public Animation(ImageStorage image) {
        this.isAnimation = false;
        this.image = image;
    }

    public Animation(int period, ImageStorage image, int count, long time) {
        this.period = period;
        this.image = image;
        this.count = count;
        this.time = time;
        this.isAnimation = true;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public ImageStorage getImage() {
        return image;
    }

    public void setImage(ImageStorage image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
