package new_engine.entity;

import new_engine.image.Image;

/**
 * author Vostryakov Alexander
 */
public interface GameObject {

    public void draw();

    public long getId();

    public void setId(long id);

    public float getX();

    public void setX(float x);

    public float getY();

    public void setY(float y);

    public int getLevel();

    public void setLevel(int level);

    public Image getDrawImg();

    public void setDrawImg(Image drawImg);

}
