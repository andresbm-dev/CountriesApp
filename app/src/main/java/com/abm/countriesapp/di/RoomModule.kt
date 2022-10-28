package com.abm.countriesapp.di

import android.content.Context
import androidx.room.Room
import com.abm.countriesapp.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val COUNTRY_DATA_BASE_NAME = "country_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)= Room.databaseBuilder(context, AppDataBase::class.java, COUNTRY_DATA_BASE_NAME).build()

    @Singleton
    @Provides
    fun provideCatDao(db: AppDataBase) = db.getCountriesDao()

}