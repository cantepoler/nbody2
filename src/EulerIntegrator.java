public class EulerIntegrator extends Integrator {
    public  EulerIntegrator(double dt) {
        super(dt);
    }

    public void move(Universe universe) {           //Moves every body of a universe by computing the force and setting the new velocities and positions.
        int numBodies = universe.getNumBodies();
        Vector[] newPositions = new Vector[numBodies];
        Vector[] newVelocities = new Vector[numBodies];
        for (int i = 0; i < numBodies; i++) {
            Vector a = universe.computeForceOn(i).scale(1.0 / universe.getBodyMass(i));
            newVelocities[i] = universe.getBodyVelocity(i).plus(a.scale(timeStep));
            newPositions[i] = universe.getBodyPosition(i).plus(newVelocities[i].scale(timeStep));
        }
        for (int i = 0; i < numBodies; i++) {
            universe.setBodyPosition(i, newPositions[i]);
            universe.setBodyVelocity(i, newVelocities[i]);
        }
    }
}
