package com.douncoding.skeleton.internal.di.components;


import android.content.Context;

import com.douncoding.skeleton.domain.executor.PostExecutionThread;
import com.douncoding.skeleton.domain.executor.ThreadExecutor;
import com.douncoding.skeleton.domain.repository.UserRepository;
import com.douncoding.skeleton.internal.di.modules.ApplicationModule;
import com.douncoding.skeleton.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    UserRepository userRepository();
}

