package snakegame.Missions;

public class FinalMission extends Mission{
    
    private boolean metalGearDefeat;
    private boolean allPreviousMissionsCompleted;

    public boolean isMetalGearDefeat() {
        return metalGearDefeat;
    }

    public void metalGearDefeat(boolean metalGearDefeat) {
        this.metalGearDefeat = true;
    }

    public boolean isAllPreviousMissionsCompleted() {
        return allPreviousMissionsCompleted;
    }

    public void setAllPreviousMissionsCompleted(boolean allPreviousMissionsCompleted) {
        this.allPreviousMissionsCompleted = allPreviousMissionsCompleted;
    }

    public FinalMission(String name) {
        super(name);
        this.metalGearDefeat = false;
        this.allPreviousMissionsCompleted = false;
    }

    @Override
    public void start() {
        if (!allPreviousMissionsCompleted){
            System.out.println("No puedes iniciar la misión final " + name + " porque no haz completado todas las misiones anteriores.");
            return;
        }
        System.out.println("Iniciando misión final " + name + ".");
        setMissionUnlocked();
    }
    
    @Override
    public boolean startMission() {
        if (!allPreviousMissionsCompleted) {
            System.out.println("No puedes iniciar la misión final " + name + " porque no haz completado todas las misiones anteriores.");
            return false;
        }
        return super.startMission();
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
