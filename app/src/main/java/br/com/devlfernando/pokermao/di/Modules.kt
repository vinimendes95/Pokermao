package br.com.devlfernando.pokermao.di

import br.com.devlfernando.pokermao.api.PokemonService
import br.com.devlfernando.pokermao.api.interceptor.AuthInterceptor
import br.com.devlfernando.pokermao.repository.PokemonRepo
import br.com.devlfernando.pokermao.repository.PokemonRepoImpl
import br.com.devlfernando.pokermao.view.splash.SplashViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20

 **/


val networkModule = module {
    single<Interceptor> { AuthInterceptor() }
    single { createOkhttpClientAuth(get()) }
    single { createNetworkClient(get()).create(PokemonService::class.java) }
}

val repoModule = module {
    single<PokemonRepo> { PokemonRepoImpl(get()) }

}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://pokedexdx.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

private fun createOkhttpClientAuth(authInterceptor: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}