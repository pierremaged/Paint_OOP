package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Ellipse extends Shapes {
    private Map<String,Double> Properties;
    public Ellipse()
    {
        Properties=new HashMap<>();
        Properties.put("width",0.0);
        Properties.put("height",0.0);
        this.setColor(Color.black);
        this.setFillColor(Color.white);
    }
    public Ellipse(int x1,int y1)
    {
        Properties=new HashMap<>();
        this.setPosition(new Point(x1,y1));
        Properties.put("width",0.0);
        Properties.put("height",0.0);
        this.setColor(Color.black);
        this.setFillColor(Color.white);
    }
    @Override
    public void setProperties(Map<String, Double> properties) {
        this.Properties=properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.Properties;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x-(int)Math.round(Properties.get("width"))/2,this.getPosition().y-(int)Math.round(Properties.get("height"))/2,
                 (int)Math.round(Properties.get("width")),(int)Math.round(Properties.get("height")));
        ((Graphics2D)canvas).setStroke(new BasicStroke(2.0F));
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x-(int)Math.round(Properties.get("width"))/2,this.getPosition().y-(int)Math.round(Properties.get("height"))/2,
                 (int)Math.round(Properties.get("width")),(int)Math.round(Properties.get("height")));

    }
    public Object clone() throws CloneNotSupportedException {
        Shape ellipse=new Ellipse(this.getPosition().x+100,this.getPosition().y+100);
        ellipse.setProperties(this.getProperties());
        ellipse.setColor(this.getColor());
        ellipse.setFillColor(this.getFillColor());
        return ellipse;
    }
}
