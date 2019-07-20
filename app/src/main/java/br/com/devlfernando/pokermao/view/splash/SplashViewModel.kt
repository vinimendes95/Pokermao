package br.com.devlfernando.pokermao.view.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.devlfernando.pokermao.repository.PokemonRepo


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20

 **/

class SplashViewModel(private val pokemonData: PokemonRepo) : ViewModel() {
    val messageError = MutableLiveData<String>()

    fun checkHealth() {
        pokemonData.checkHealth({
            messageError.value = ""
        }, {
            messageError.value = it.message
        })
    }
}