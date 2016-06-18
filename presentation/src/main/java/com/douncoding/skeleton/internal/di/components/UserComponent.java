/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.douncoding.skeleton.internal.di.components;


import com.douncoding.skeleton.internal.di.PerActivity;
import com.douncoding.skeleton.internal.di.modules.ActivityModule;
import com.douncoding.skeleton.internal.di.modules.UserModule;
import com.douncoding.skeleton.presenter.UserListPresenter;
import com.douncoding.skeleton.view.fragment.UserListFragment;
import com.douncoding.skeleton.view.adapter.UsersAdapter;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    /**
     * {@link UserListFragment} 의 DI 대상은 {@link UserListPresenter} 와 {@link UsersAdapter}
     * 이며, 각 각의 클래스가 생성자의 매개변수는 ApplicationComponent 에서 노출되야 한다.
     */
    void inject(UserListFragment userListFragment);
  //void inject(UserDetailsFragment userDetailsFragment);
}
