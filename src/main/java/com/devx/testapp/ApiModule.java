package com.devx.testapp;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(entryPoints = ApiController.class)
public class ApiModule {

    @Provides
    @Singleton
    DbMysql provideDbMysql() {
        return new DbMysql();
    }
}
