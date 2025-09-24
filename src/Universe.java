public class Universe {
    private double radius;
    private Body[] bodies;
    private int numBodies;

    public Universe(Body[] bodies, double radius) {
        this.bodies = bodies;
        this.radius = radius;
        numBodies = bodies.length;
    }

    public Vector computeForceOn(int i) {
        Vector force = new Vector(new double[2]);
        for (int j = 0; j < numBodies; j++) {
            if (i != j) {
                force = force.plus(bodies[i].forceFrom(bodies[j]));
            }
        }
        return force;
    }

    public Vector getBodyVelocity(int i) {return bodies[i].getVelocity();}

    public double getBodyMass(int i) {return bodies[i].getMass();}

    public int getNumBodies() {return numBodies;}

    public Vector getBodyPosition(int i) {return bodies[i].getPosition();} //Retorna la posició d'un dels cossos


    public Vector getBodyAcceleration(int i) {return bodies[i].getAcceleration();}

    public void setBodyPosition(int i, Vector position) {bodies[i].setPosition(position);}

    public void setBodyVelocity(int i, Vector velocity) {bodies[i].setVelocity(velocity);}

    public void setBodyAcceleration(int i, Vector acceleration) {bodies[i].setAcceleration(acceleration);}


    public double getRadius(){
        return this.radius;
    }

}
