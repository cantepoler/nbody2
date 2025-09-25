import java.awt.*;

class NBodySimulator {
    private Universe universe;
    private double timeStep;
    private int pauseTime;
    private boolean trace;
    private int integratorMethod;

    public NBodySimulator(Universe universe, double dt, int pt, boolean doTrace, int integratorMethod) {
        this.universe = universe;
        timeStep = dt;
        pauseTime = pt;
        trace = doTrace;
        this.integratorMethod = integratorMethod;
    }

    private void createCanvas() {
        //StdDraw.setCanvasSize(700, 700); // uncomment for a larger window
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius (0.025);
        double radius = universe.getRadius();
        // read from txt file, second line
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
    }


    public void simulate() {
        createCanvas();
        Integrator integrator;

        if (integratorMethod == 0) {
            integrator = new EulerIntegrator(timeStep);
        }
        else {
            integrator = new LeapFrogIntegrator(timeStep);
        }
        if (trace) {
            StdDraw.clear(StdDraw.LIGHT_GRAY);
            while (true) {
                StdDraw.setPenColor(StdDraw.WHITE);
                drawUniverse();
                integrator.move(universe);
                StdDraw.setPenColor(StdDraw.BLACK);
                drawUniverse();
                integrator.move(universe);
                StdDraw.show();
                StdDraw.pause(pauseTime);
            }
        } else {
            while (true) {
                StdDraw.clear();
                integrator.move(universe);
                drawUniverse();
                StdDraw.show();
                StdDraw.pause(pauseTime);
            }
        }
    }

    private void drawUniverse() {
        for (int i = 0; i < universe.getNumBodies(); i++) {
            Vector position = universe.getBodyPosition(i);
            double x = position.cartesian(0);
            double y = position.cartesian(1);
            StdDraw.point(x, y);
        }
    }
}