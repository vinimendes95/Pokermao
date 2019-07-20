package br.com.devlfernando.pokermao

import android.app.Application
import br.com.devlfernando.pokermao.di.networkModule
import br.com.devlfernando.pokermao.di.repoModule
import br.com.devlfernando.pokermao.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20
 * Empresa: PayGo

 **/

class PokermaoApplication : Application() {
    override fun onCreate() {
        Stetho.initializeWithDefaults(this)

        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PokermaoApplication)
            modules(
                    listOf(
                            networkModule,
                            repoModule,
                            viewModelModule
                    )
            )
        }
    }
}