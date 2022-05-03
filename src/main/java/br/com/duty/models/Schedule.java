package br.com.duty.models;

public enum Schedule {
    MORNING(1),
    NIGHT(2);

    public int scheduleCode;

    Schedule(int scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public int getScheduleCode() {
        return scheduleCode;
    }

    public static Schedule getScheduleByID(int scheduleId) {
        switch (scheduleId) {
            case 1:
                return Schedule.MORNING;
            case 2:
                return Schedule.NIGHT;
            default:
                return null;
        }
    }
}
