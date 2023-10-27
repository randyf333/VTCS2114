package towerofhanoi;

public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Main method
     * 
     * @param args
     *            arguments to put personal number of disks
     */
    public static void main(String[] args)
    {
        int disks = 6;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(hanoi);

    }

}
