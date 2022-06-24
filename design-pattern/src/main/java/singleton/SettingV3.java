package singleton;

public class SettingV3 {
    private static SettingV3 setting;

    private SettingV3() {}

    public synchronized SettingV3 getInstance() {
        if (setting == null) {
            return new SettingV3();
        }
        return setting;
    }
}
