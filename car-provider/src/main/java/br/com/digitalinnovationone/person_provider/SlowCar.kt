package br.com.digitalinnovationone.person_provider

class SlowCar : Car {

    private var _state = "Carro lento está parado"

    override val state: String
        get() = _state

    override fun brake() {
        _state = "Carro lento está freando"
    }

    override fun speedUp() {
        _state = "Carro lento está acelerando"
    }

    override fun turnRight() {
        _state = "Carro lento está virando a direita"
    }

    override fun turnLeft() {
        _state = "Carro lento está virando a esquerda"
    }

    override fun backUp() {
        _state = "Carro lento está dando ré"
    }
}