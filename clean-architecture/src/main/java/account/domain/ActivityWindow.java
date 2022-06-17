package account.domain;

import account.domain.Account.AccountId;
import java.util.ArrayList;
import java.util.List;

public class ActivityWindow {

    private List<Activity> activities = new ArrayList<>();

    public ActivityWindow(List<Activity> mappedActivities) {
        this.activities = mappedActivities;
    }

    public Money calculateBalance(AccountId id) {
        return null;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

}
