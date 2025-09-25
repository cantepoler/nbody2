public class Body {
    private Vector position;               // position
    private Vector velocity;               // velocity
    private Vector acceleration;           // acceleration
    private final double mass;             // mass
    private double G = 6.67e-11;           // gravity

    public Body(Vector r, Vector v, double mass) {
        this.position = r;
        this.velocity = v;
        this.mass = mass;
    }

    public Body(Vector r, Vector v, double mass, double G) {
        this.position = r;
        this.velocity = v;
        this.mass = mass;
        this.G = G;
    }

    public Vector forceFrom(Body b) {
        Body a = this;
        Vector delta = b.position.minus(a.position);
        double dist = delta.magnitude();
        double magnitude = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().scale(magnitude);
    }

    public Vector getPosition() {return position;}

    public double getMass() {return mass;}

    public Vector getVelocity() {return velocity;}
    public Vector getAcceleration() {return acceleration;}

    public void setPosition(Vector position) {this.position = position;}
    public void setVelocity(Vector velocity) {this.velocity = velocity;}
    public void setAcceleration(Vector acceleration) {this.acceleration = acceleration;}
    @Override
    public String toString() {
        return "position "+ position.toString()+", velocity "+ velocity.toString() + ", mass "+mass;
    }

}
