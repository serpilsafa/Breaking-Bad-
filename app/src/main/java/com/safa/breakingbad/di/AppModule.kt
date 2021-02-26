package com.safa.breakingbad.di

import android.content.Context
import androidx.room.Room
import com.safa.breakingbad.api.ActorRetrofitAPI
import com.safa.breakingbad.data.BreakingBadDB
import com.safa.breakingbad.utility.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, BreakingBadDB::class.java, "BreakingBadDB"
    ).build()

    @Singleton
    @Provides
    fun injectDao(database: BreakingBadDB) = database.breakingBadDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI(): ActorRetrofitAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ActorRetrofitAPI::class.java)
    }

}