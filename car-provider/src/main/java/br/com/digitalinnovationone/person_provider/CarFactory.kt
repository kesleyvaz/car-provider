package br.com.digitalinnovationone.person_provider

object CarFactory {
    fun getCar(type: CarType): Car {
        return when (type) {
            CarType.FAST -> FastCar()
            CarType.SLOW -> SlowCar()
        }
    }
}