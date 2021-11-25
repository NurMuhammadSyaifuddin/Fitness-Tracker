package com.project.fitness.injection

import android.content.Context
import androidx.room.Room
import com.project.fitness.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "fitness.db"
    ).build()

    @Singleton
    @Provides
    fun provideTrainingDao(db: AppDatabase) = db.trainingDao()

    @Singleton
    @Provides
    fun provideScheduleDao(db: AppDatabase) = db.scheduleDao()

}