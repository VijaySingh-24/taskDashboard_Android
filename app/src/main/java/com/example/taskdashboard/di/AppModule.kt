package com.example.taskdashboard.di

import com.example.taskdashboard.data.remote.api.TaskApi
import com.example.taskdashboard.data.repository.TaskGroupRepositoryImpl
import com.example.taskdashboard.data.repository.TaskRepositoryImpl
import com.example.taskdashboard.domain.repository.TaskGroupRepository
import com.example.taskdashboard.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTaskApi(): TaskApi {
        return Retrofit.Builder()
      //  https://dummyjson.com/
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(TaskApi::class.java)
    }
    @Provides
    fun provideRepository(api: TaskApi): TaskRepository = TaskRepositoryImpl(api)

    @Provides
    fun provideTaskGroupRepository(api: TaskApi): TaskGroupRepository =TaskGroupRepositoryImpl(api)

}
