package snakegame.Missions;

public class FinalMission extends Mission{
    
    private boolean metalGearDefeat;
    private boolean allMissionsCompleted;

    public boolean isMetalGearDefeat() {
        return metalGearDefeat;
    }

    public void metalGearDefeat(boolean metalGearDefeat) {
        this.metalGearDefeat = true;
    }

    public boolean isAllMissionsCompleted() {
        return allMissionsCompleted;
    }

    public void setAllMissionsCompleted(boolean allMissionsCompleted) {
        this.allMissionsCompleted = allMissionsCompleted;
    }

    public FinalMission(String name) {
        super(name);
        this.metalGearDefeat = false;
        this.allMissionsCompleted = false;
    }

    @Override
    public void start() {
        if (!allMissionsCompleted){
            System.out.println("No puedes iniciar la misión final " + name + " porque no haz completado todas las misiones anteriores.");
        }
        setMissionUnlocked();
        System.out.println("Iniciando misión final " + name + ".");
    }

    @Override
    public boolean verifiedMissionCompleted() {
        if (!metalGearDefeat) {
            return false;
        }
        missionCompleted = true;
        return true;
    }
    
}
