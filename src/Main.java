//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numargs = args.length;
        assert numargs >= 4 : "invalid number of arguments";
        double dt = Double.parseDouble(args[0]);
        int pauseTime = Integer.parseInt(args[1]);
        boolean trace = args[2].toLowerCase().equals("trace");
        String fname = args[3];
        int integratorMethod = Integer.parseInt(args[4]);
        int universeMaker = Integer.parseInt(args[5]);
        Universe universe;
        switch (universeMaker)
        {
            case 0:
                universe = UniverseFactory.makeUniverseFromFile(fname);
                break;
            case 1:
                universe = UniverseFactory.makeChoreography(1);
                break;
            case 2:
                universe = UniverseFactory.makePlanetaryConfiguration(7);
                break;
            case 3:
                universe = UniverseFactory.makeCentralConfiguration(7, 0, 1);
                break;
            default:
                universe = UniverseFactory.makeUniverseFromFile(fname);

        }
        NBodySimulator simulator = new NBodySimulator(universe, dt, pauseTime, trace, integratorMethod);
        simulator.simulate();
    }
}