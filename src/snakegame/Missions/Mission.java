package snakegame.Missions;

public abstract class Mission {
    protected String name;
    protected boolean missionCompleted;
    protected boolean missionUnlocked; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMissionCompleted() {
        return missionCompleted;
    }

    public void setMissionCompleted(boolean missionCompleted) {
        this.missionCompleted = missionCompleted;
    }

    public boolean isMissionUnlocked() {
        return missionUnlocked;
    }

    public void setMissionUnlocked() {
        this.missionUnlocked = true;
    }

    public Mission(String name) {
        this.name = name;
        this.missionCompleted = false;
        this.missionUnlocked = false;
    }
    
    public abstract void start();
   
    public abstract boolean verifiedMissionCompleted();
    
    public boolean startMission() {
        if (!missionUnlocked) {
            System.out.println("La misión " + name + " no está desbloqueada aún.");
            return false;
        }
        
        start();
        return true;
    }

    @Override
    public String toString() {
        return "Mission{" + "name=" + name + ", missionCompleted=" + missionCompleted + ", missionUnlocked=" + missionUnlocked + '}';
    }
     
}
