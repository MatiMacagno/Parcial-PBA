package snakegame.Missions;

public class IntermediateMission extends Mission {

    private int missionNumber;
    private String[] objectives;
    private boolean[] completedObjectives;
    
    public int getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(int missionNumber) {
        this.missionNumber = missionNumber;
    }

    public IntermediateMission(String name, int missionNumber, String[] objectives) {
        super(name);
        this.missionNumber = missionNumber;
        this.objectives = objectives;
        this.completedObjectives = new boolean [objectives.length];
    }
    
    public void completeObjective(int i) {
        if (i >=0 && i < completedObjectives.length) {
            completedObjectives[i] = true;
            System.out.println("Objetivo completado: " + objectives[i]);
        }
    }
    
    @Override
    public void start() {
        System.out.println("Iniciando misión " + name + ".");
        System.out.println("Objetivos:");
        for (int i = 0; i < objectives.length; i++) {
            System.out.println("- " + objectives[i]);
        }
        setMissionUnlocked();
    }

    @Override
    public boolean verifiedMissionCompleted() {
        for (int i = 0; i < completedObjectives.length; i++) {
            if (!completedObjectives[i]) {
                return false;
            }
        }
        missionCompleted = true;
        return true;
    }
}
