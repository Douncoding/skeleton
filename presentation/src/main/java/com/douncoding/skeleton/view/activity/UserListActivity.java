package com.douncoding.skeleton.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.douncoding.skeleton.R;
import com.douncoding.skeleton.internal.di.HasComponent;
import com.douncoding.skeleton.internal.di.components.DaggerUserComponent;
import com.douncoding.skeleton.internal.di.components.UserComponent;
import com.douncoding.skeleton.model.UserModel;
import com.douncoding.skeleton.view.fragment.UserListFragment;

/**
 * Activity that shows a list of Users.
 */
public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>,
        UserListFragment.UserListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    private UserComponent userComponent;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    @Override public void onUserClicked(UserModel userModel) {
        //this.navigator.navigateToUserDetails(this, userModel.getUserId());
    }
}
