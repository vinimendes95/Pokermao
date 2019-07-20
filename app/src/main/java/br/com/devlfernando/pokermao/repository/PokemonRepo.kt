package br.com.devlfernando.pokermao.repository


/**

 * Criado por Luis Fernando F. Araujo em 2019-07-20

 **/

interface PokemonRepo {
    fun checkHealth(onComplete:() -> Unit, onError:(t: Throwable) -> Unit)
}