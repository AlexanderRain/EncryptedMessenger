package com.bvblogic.examplearbvb.bean.newMessage;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface NewMessageComponent {

    void inject(NewMessageView view);
}
