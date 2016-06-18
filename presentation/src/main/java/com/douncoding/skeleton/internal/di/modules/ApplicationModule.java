package com.douncoding.skeleton.internal.di.modules;

import  android.content.Context;

import com.douncoding.skeleton.AndroidApplication;
import com.douncoding.skeleton.UIThread;
import com.douncoding.skeleton.data.cache.UserCache;
import com.douncoding.skeleton.data.cache.UserCacheImpl;
import com.douncoding.skeleton.data.executor.JobExecutor;
import com.douncoding.skeleton.data.repository.UserDataRepository;
import com.douncoding.skeleton.domain.executor.PostExecutionThread;
import com.douncoding.skeleton.domain.executor.ThreadExecutor;
import com.douncoding.skeleton.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    UserCache provideUserCache(UserCacheImpl userCache) {
        return userCache;
    }

    @Provides @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
