package at.htlleonding.observer;

import at.htlleonding.health.controller.MedicalPracticeController;
import at.htlleonding.health.model.WaitingRoom;
import at.htlleonding.observer.ChangeObserver;

public class UpdateObserver implements ChangeObserver<WaitingRoom> {
    private int updateCount;

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(WaitingRoom subject) {

        this.updateCount++;
    }
}
