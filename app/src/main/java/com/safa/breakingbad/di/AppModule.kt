package com.safa.breakingbad.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.safa.breakingbad.R
import com.safa.breakingbad.api.ActorRetrofitAPI
import com.safa.breakingbad.data.BreakingBadDB
import com.safa.breakingbad.data.BreakingBadDao
import com.safa.breakingbad.repo.BreakingBadRepository
import com.safa.breakingbad.repo.BreakingBadRepositoryInterface
import com.safa.breakingbad.utility.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
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


    @Singleton
    @Provides
    fun injectNormalRepo(dao: BreakingBadDao, api: ActorRetrofitAPI) = BreakingBadRepository(dao, api) as BreakingBadRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )

}