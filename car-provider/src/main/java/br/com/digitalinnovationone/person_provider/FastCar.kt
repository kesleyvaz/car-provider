package br.com.digitalinnovationone.person_provider

class FastCar : Car {

    private var _state = "O carro rápido está parado"

    override val state: String
        get() = _state

    override fun brake() {
        _state = "Carro rápido está freando"
    }

    override fun speedUp() {
        _state = "Carro rápido está acelerando"
    }

    override fun turnRight() {
        _state = "Carro rápido está virando a direita"
    }

    override fun turnLeft() {
        _state = "Carro rápido está virando a esquerda"
    }

    override fun backUp() {
        _state = "Carro rápido está dando ré"
    }
}
