package it.unibo.argumentation.arg2p

import Main
import it.unibo.tuprolog.theory.Theory
import it.unibo.tuprolog.theory.parsing.parse

actual fun loadTheoryFromFile(fileName: String): Theory {
    return Main::class.java.classLoader.getResource(fileName).let {
        Theory.parse(it!!.readText())
    }
}