fun main() {
    val habitaciones = mutableListOf<Habitacion>()
    val reservas = mutableListOf<Reserva>()
    val clientes = mutableListOf<Cliente>()
//Esaú Rincón Martínez IRD22
    var opcion: Int
    do {
        println("Bienvenido al Sistema de Hotel Rincón, por favor ngrese una opcion:")
        println("1 - Registrar habitación")
        println("2 - Registrar Cliente")
        println("3 - Crear reserva")
        println("4 - Mostrar habitaciones")
        println("5 - Mostrar Clientes")
        println("6 - Mostrar reservas")
        println("7 - Salir")

        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Ingrese el número de habitación:")
                val numero = readln().toInt()
                println("Ingrese el tipo de habitación:")
                val tipo = readln()
                println("Ingrese la capacidad de la habitación:")
                val capacidad = readln().toInt()
                println("Ingrese el precio por noche:")
                val precio = readln().toDouble()

                val nuevaHabitacion = Habitacion(numero, tipo, capacidad, precio)
                habitaciones.add(nuevaHabitacion)
                println("Habitación registrada exitosamente")
            }
            2 -> {
                println("Ingrese el nombre del cliente:")
                val nombre = readln()
                println("Ingrese la dirección del cliente:")
                val direccion = readln()
                println("Ingrese el número de teléfono del cliente:")
                val telefono = readln()

                val nuevoCliente = Cliente(nombre, direccion, telefono)
                clientes.add(nuevoCliente)
                println("Cliente registrado exitosamente")
            }
            3 -> {
                println("Ingrese el número de habitación para la reserva:")
                val numeroHabitacion = readln().toInt()

                val habitacionSeleccionada = habitaciones.find { it.numero == numeroHabitacion }
                if (habitacionSeleccionada != null) {
                    println("Ingrese el nombre del cliente para la reserva:")
                    val nombreCliente = readln()

                    val clienteSeleccionado = clientes.find { it.nombre == nombreCliente }
                    if (clienteSeleccionado != null) {
                        println("Ingrese la fecha de inicio de la reserva (formato dd/mm/yyyy):")
                        val fechaInicio = readln()
                        println("Ingrese la fecha de fin de la reserva (formato dd/mm/yyyy):")
                        val fechaFin = readln()

                        val nuevaReserva = Reserva(habitacionSeleccionada, clienteSeleccionado, fechaInicio, fechaFin)
                        reservas.add(nuevaReserva)
                        println("Reserva creada exitosamente")
                        } else {
                            println("Cliente no encontrado")
                        }
                    } else {
                        println("Habitación no encontrada")

                }
            }
            4 -> {
                println("Habitaciones disponibles:")
                habitaciones.forEach { println(it) }
            }
            5 -> {
                println("Clientes registrados:")
                clientes.forEach { println(it) }
            }
            6 -> {
                println("Reservas realizadas:")
                reservas.forEach { println(it) }
            }
            7 -> println("Saliendo del programa")
            else -> println("Opción no válida")
        }
    } while (opcion != 7)
}